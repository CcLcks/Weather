package com.mentalmachines.weather.Fragments;

import java.util.concurrent.ExecutionException;

import android.support.v4.app.Fragment;

import com.google.gson.Gson;
import com.mentalmachines.weather.CurrentResponse;
import com.mentalmachines.weather.FetchJSONTask;

public class CurrentFragment extends Fragment{
	CurrentResponse currentWeatherResponse = new CurrentResponse();
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		JsonToObject();
		displayData();
		super.onStart();
	}
	
	private void JsonToObject(){
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
		
		currentWeatherResponse = gson.fromJson(jsonString, CurrentResponse.class);
	}

	private String getURL(String location){
		String currentWeatherURL = "http://api.openweathermap.org/data/2.5/weather?q=" + location;
		return currentWeatherURL;
	}
	
	private void displayData(){
		
	}  

}