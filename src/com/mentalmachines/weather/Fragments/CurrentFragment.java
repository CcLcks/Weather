package com.mentalmachines.weather.Fragments;

import java.util.concurrent.ExecutionException;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mentalmachines.weather.CurrentResponse;
import com.mentalmachines.weather.FetchJSONTask;
import com.mentalmachines.weather.R;

public class CurrentFragment extends Fragment{
	TextView sunriseIdTextView, sunriseTextView, sunsetIdTextView,  sunsetTextView,
		tempIdTextView, tempTextView, pressureIdTextView, pressureTextView,
		humidityIdTextView, humidityTextView, tempMinIdTextView, tempMinTextView, 
		tempMaxIdTextView, tempMaxTextView, windIdTextView, windMaxTextView, 
		rainIdTextView, rainTextView, cloudsIdTextView, cloudsTextView;
	
	CurrentResponse current= new CurrentResponse();
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		jsonToObject();
		displayData();
		super.onStart();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		
        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);
		sunriseIdTextView = (TextView) view.findViewById(R.id.sunriseIdTextView);
		sunriseTextView = (TextView) view.findViewById(R.id.sunriseTextView);
		sunsetIdTextView = (TextView) view.findViewById(R.id.sunsetIdTextView);
		sunsetTextView = (TextView) view.findViewById(R.id.sunsetTextView);
		tempIdTextView = (TextView) view.findViewById(R.id.tempIdTextView); 
		tempTextView = (TextView) view.findViewById(R.id.tempTextView);
		pressureIdTextView = (TextView) view.findViewById(R.id.pressureIdTextView);
		pressureTextView = (TextView) view.findViewById(R.id.pressureTextView);
		humidityIdTextView = (TextView) view.findViewById(R.id.humidityIdTextView);
		humidityTextView = (TextView) view.findViewById(R.id.humidityTextView);
		tempMinIdTextView = (TextView) view.findViewById(R.id.tempMinIdTextView);
		tempMinTextView = (TextView) view.findViewById(R.id.tempMinTextView);
		tempMaxIdTextView = (TextView) view.findViewById(R.id.tempMaxIdTextView);
		tempMaxTextView = (TextView) view.findViewById(R.id.tempMaxTextView);
		windIdTextView = (TextView) view.findViewById(R.id.windIdTextView);
		windMaxTextView = (TextView) view.findViewById(R.id.windMaxTextView);
		rainIdTextView = (TextView) view.findViewById(R.id.rainIdTextView);
		rainTextView = (TextView) view.findViewById(R.id.rainTextView);
		cloudsIdTextView = (TextView) view.findViewById(R.id.cloudsIdTextView);
		cloudsTextView = (TextView) view.findViewById(R.id.cloudsTextView);
        return view;
	}
	
	private void jsonToObject(){
		Gson gson = new Gson();
		String jsonString = null;
		
		try {
			jsonString = new FetchJSONTask().execute(getURL("London, UK"), "", "").get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		current = gson.fromJson(jsonString, CurrentResponse.class);
	}

	private String getURL(String location){
		Uri.Builder builder = new Uri.Builder();
		builder.scheme("https").authority("api.openweathermap.org").appendPath("data").appendPath("2.5").appendPath("weather")
			.appendQueryParameter("q", location).appendQueryParameter("mode", "json");
		return builder.build().toString();
	}
	
	public void displayData(){
		sunriseTextView.setText(current.sys.sunrise);

	}  

}