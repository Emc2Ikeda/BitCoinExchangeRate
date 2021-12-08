// Ema Ikeda
// ID: 950607512
// 11/08/21
// API for WeatherTest. Read JSON file on weather for the following cities in real time:
    // Bellevue
    // New York 
    // Hong Kong
    // New Delhi 
    // Paris
    // Cairo 
    // Moscow 
    // Tokyo 
    // Sydney 
    // Cape Town

// Then return the following information on weather depending on user input: 
    // 1. Overall weather (i.e. clear, light rain, etc)
    // 2. Current temperature in Kelvins (default), Degrees Celcius (metric), Degrees Fahrenheit (imperial) 
    // 3. Pressure in hPa (default, metric, and imperial)
    // 4. Humidity in % (default, metric, and imperial)
    // 5. Wind Degree in Degrees (default, metric, and imperial)
    // 6. Wind Speed in m/s (default and metric), mph (imperial)
    // 7. Wind Gust in m/s (default and metric), mph (imperial)

// Additional Feature: User can select units from the following:
    // Standard (default)
    // Metric
    // Imperial

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WeatherAPI {
    static HashMap<String, String> units = new HashMap<String, String>(); // category, units pair for standard measurements
    private static void initializeHashMap(String measurement) {
        if (measurement == "metric") {
            units.put("temp","\u00B0C");
        } else if (measurement == "imperial") {
            units.put("temp","\u00B0F");
        } else {
            units.put("temp","K");
        }

        units.put("pressure", "hPa");
        units.put("humidity", "%");
        units.put("deg", "\u00B0");

        if (measurement == "imperial") {
            units.put("speed", "mph");
        } else {
            units.put("speed", "m/s");
        }

        if (measurement == "imperial") {
            units.put("gust", "mph");
        } else {
            units.put("gust", "m/s");
        }
    }

    // tack on corresponding units for each weather category.
    private static String showUnits (String category, String measurement) {
        initializeHashMap(measurement);
        return units.get(category);
    }

    // convert city name inputted by user to api format
    private static String convertCityNametoAPI (String cityName) {
        String apiCityName = cityName.replace(" ", "+");
        return apiCityName;
    }

    public static String getCityWeather (String cityName, String category) {
        String result = "";
        try {
            JSONParser jsonParser = new JSONParser();
            // Replace spaces with "+" to fit openweathermap's API format
            String apiCityName = convertCityNametoAPI(cityName);
            String weatherURL = "https://api.openweathermap.org/data/2.5/weather?q=" + apiCityName + "&appid=f00ca714434de41038f777640431f305";
            
            // make a dedicated method to read JSON file
            URL url = new URL(weatherURL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            JSONObject obj = (JSONObject)jsonParser.parse(br);

            switch (category) { // return a different output depending on category
                case "main":
                    JSONArray weather = (JSONArray)obj.get("weather"); 
                    JSONObject w = (JSONObject)weather.get(0); // get weather array
                    result = (String)w.get("description");
                    break;
                case "temp":
                    double temp = (double)((JSONObject)obj.get("main")).get("temp"); //get temperature in Kelvin;
                    result = Double.toString(temp);
                    break;
                case "pressure":
                    long pressure = (long)((JSONObject)obj.get("main")).get("pressure"); //get temperature in Kelvin;
                    result = Long.toString(pressure);
                    break;
                case "humidity":
                    long humidity = (long)((JSONObject)obj.get("main")).get("humidity");
                    result = Long.toString(humidity);
                    break;
                case "deg":
                    long windDegree = (long)((JSONObject)obj.get("wind")).get("deg");
                    result = Long.toString(windDegree);
                    break;
                case "speed":
                    double windSpeed = (double)((JSONObject)obj.get("wind")).get("speed");
                    result = Double.toString(windSpeed);
                    break;
                case "gust":
                    double windGust = (double)((JSONObject)obj.get("wind")).get("gust");
                    result = Double.toString(windGust);
                    break;
                default: 
                    break;
            }
        }
        catch (Exception ex) {
        }
        if (category != "main") {
            if (result == "") { // return "No data" if the information was not in JSON file. Otherwise, tack on corresponding unit based on measurement
                result = "No data";
            } else {
                result += showUnits(category, "std");
            }
        }
        return result;
    }

    // override for users who wants to see variables in other unit measurements, such as imperial measuremenets
    public static String getCityWeather (String cityName, String category, String units) {
        String result = "";
        try {
            JSONParser jsonParser = new JSONParser();
            // Replace spaces with "+" to fit openweathermap's API format
            String apiCityName = convertCityNametoAPI(cityName);
            String weatherURL = "https://api.openweathermap.org/data/2.5/weather?q=" + apiCityName + "&units=" + units + "&appid=f00ca714434de41038f777640431f305";
            
            // make a dedicated method to read JSON file
            URL url = new URL(weatherURL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            JSONObject obj = (JSONObject)jsonParser.parse(br);

            switch (category) { // return a different output depending on category
                case "main":
                    JSONArray weather = (JSONArray)obj.get("weather"); 
                    JSONObject w = (JSONObject)weather.get(0); // get weather array
                    result = (String)w.get("description");
                    break;
                case "temp":
                    double temp = (double)((JSONObject)obj.get("main")).get("temp"); //get temperature in Kelvin;
                    result = Double.toString(temp);
                    break;
                case "pressure":
                    long pressure = (long)((JSONObject)obj.get("main")).get("pressure"); //get temperature in Kelvin;
                    result = Long.toString(pressure);
                    break;
                case "humidity":
                    long humidity = (long)((JSONObject)obj.get("main")).get("humidity");
                    result = Long.toString(humidity);
                    break;
                case "deg":
                    long windDegree = (long)((JSONObject)obj.get("wind")).get("deg");
                    result = Long.toString(windDegree);
                    break;
                case "speed":
                    double windSpeed = (double)((JSONObject)obj.get("wind")).get("speed");
                    result = Double.toString(windSpeed);
                    break;
                case "gust":
                    double windGust = (double)((JSONObject)obj.get("wind")).get("gust");
                    result = Double.toString(windGust);
                    break;
                default: 
                    break;
            }
        }
        catch (Exception ex) {
        }
        if (category != "main") {
            if (result == "") { // return "No data" if the information was not in JSON file. Otherwise, tack on corresponding unit based on measurement
                result = "No data";
            } else {
                result += showUnits(category, units);
            }  
        }
        return result;
    }
}
