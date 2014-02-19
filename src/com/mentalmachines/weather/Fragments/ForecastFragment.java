package com.mentalmachines.weather.Fragments;

import java.util.concurrent.ExecutionException;

import android.support.v4.app.Fragment;

import com.google.gson.Gson;
import com.mentalmachines.weather.CurrentResponse;
import com.mentalmachines.weather.FetchJSONTask;
import com.mentalmachines.weather.ForecastResponse;

public class ForecastFragment extends Fragment{

	ForecastResponse forecastWeatherResponse = new ForecastResponse();
	
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
		
		forecastWeatherResponse = gson.fromJson(jsonString, ForecastResponse.class);
	}

	private String getURL(String location){
		String currentWeatherURL = "http://api.openweathermap.org/data/2.5/weather?q=" + location;
		return currentWeatherURL;
	}
	
	private void displayData(){
		
	}
}