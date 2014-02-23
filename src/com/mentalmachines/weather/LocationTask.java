package com.mentalmachines.weather;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;

public class LocationTask extends AsyncTask<String, String, String> {
	
	public String jsonResponse;
	
	protected String doInBackground(String... requestStrings) {
		// Acquire a reference to the system Location Manager
		LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

		// Define a listener that responds to location updates
		LocationListener locationListener = new LocationListener() {
		    public void onLocationChanged(Location location) {
		      // Called when a new location is found by the network location provider.
				Geocoder gcd = new Geocoder(getActivity(), Locale.getDefault());
				List<Address> addresses = null;
				try {
					addresses = gcd.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (addresses.size() > 0) 
				    System.out.println(addresses.get(0).getLocality());
		    }

		    public void onStatusChanged(String provider, int status, Bundle extras) {}

		    public void onProviderEnabled(String provider) {}

		    public void onProviderDisabled(String provider) {}
		  };

		// Register the listener with the Location Manager to receive location updates
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
		
		return null;

	}

	protected void onProgressUpdate(Integer... progress) {
		// TODO You are on the GUI thread, and the first element in 
		// the progress parameter contains the last progress
		// published from doInBackground, so update your GUI
	}

	protected void onPostExecute(String result) {
		
	}
}
