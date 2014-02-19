package com.mentalmachines.weather;

import java.util.ArrayList;

public class CurrentResponse {
	Coordinates coord;
	Sys sys;
	// Weather weather;
	ArrayList<Weather> weather;
	String base;
	
	Integer dt;
	Integer id;
	String name;
	Integer cod;
	
	private class Coordinates{
		Double lon, lat;
	} 
	
	
	private class Sys{
		Double message;
		String country;
		String sunrise, sunset; 
	}

	private class Weather{
		Integer id;
		String main;
		String description;
		String icon;
	}

	
	public class Main{
		Double temp;
		Integer pressure;
		Integer humidity;
		Double temp_min, temp_max;
	}
	
	public class Wind {
		Double speed;
		Integer deg;
	}
	
	public class Rain {
		Double threeh;
	}
	
	private class Clouds{
		Integer all;
	}
	

	}
