package bot;

//import java.io.IOException;
//import org.json.JSONException;
import org.json.JSONObject;

import net.aksingh.owmjapis.*;

public class Weather {
	
	public static String temperatura(String city) {
	    String ret = new String();
		boolean isMetric = true;
	    String owmApiKey = "3a7935bcb1178cede69ad833c05e37b8";
	    String weatherCity = city;
	    OpenWeatherMap.Units units = (isMetric)
	        ? OpenWeatherMap.Units.METRIC
	        : OpenWeatherMap.Units.IMPERIAL;
	    OpenWeatherMap owm = new OpenWeatherMap(units, owmApiKey);
	    try {
	    	CurrentWeather weather = owm.currentWeatherByCityName(weatherCity);
	      	JSONObject clima = new JSONObject(weather.getRawResponse());
	      	ret = "La temperatura actual para " + weather.getCityName() + " es de " + clima.getJSONObject("main").getDouble("temp") 
	      			+ "°C" + " (Min: " + clima.getJSONObject("main").getDouble("temp_min") + "°C, Max: " 
	      			+ clima.getJSONObject("main").getDouble("temp_max") + "°C) con humedad del " 
	      			+ clima.getJSONObject("main").getDouble("humidity") + "%.";
	    }
	    catch (Exception e) {
	    	//e.printStackTrace();
	    	return "Ciudad no valida.";
	    }
	    return ret;
	  }
	}

