import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WeatherAPI_OUTLINE {

//	private static HashMap<String, Integer> tempByCityName = new HashMap<>();
	
	public static String getCityWeather (String cityName, String code) throws Exception {
	
		String result="";
		
		try {	
				//JSON parser object to parse read file
				JSONParser jsonParser = new JSONParser();
				
				///Create a URL instance
				String firstPartURL = "https://api.openweathermap.org/data/2.5/weather?q=";
				String secondPartURL ="&appid=your API key"; 
				String theURL = firstPartURL + cityName + secondPartURL;
				URL url = new URL(theURL); 
				
				///Access the site   
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				
				//Read JSON file. All the data for the city is stored in jsonObject 
				JSONObject jsonObj = (JSONObject)jsonParser.parse(br);	 		
					
							
				//*** to read the JSON file, you MUST understand the above JSON file structure. See bottom of this program ****
			
				
				// Some examples of how to read category
				
			    // temp
				// jsonObject -> main -> temp
			    if (code.equals("temp")) {// code: came from main test program.	See line # 15. getCityWeather (String cityName, String code) throws Exception {	      
				    double temp = (double)((JSONObject)jsonObj.get("main")).get(code);//get temperature in Kelvin;
				    System.out.println("Test: temp = " + temp);	
				    result = Double.toString(temp);
			    }
			    
			    
			    // sunset
			    // jsonObject -> sys -> code
			    if (code.equals("sunset")) {			
				    long sun = (long)((JSONObject) jsonObj.get("sys")).get(code);
					System.out.println("Test: sunset = " + sun);	
					result=Long.toString(sun);
				}	
			    			    
			    
			   // description (description is in the array of weather) Use JSONArray
			    JSONArray weather = (JSONArray)jsonObj.get("weather");
			    JSONObject w = (JSONObject) weather.get(0);		       
			    System.out.println("Test: description = " + w.get("description"));
		    
			    
			    // country
			    String country = (String)((JSONObject)jsonObj.get("sys")).get("country");
			    System.out.println("Test: Country = " + country);   
			    		    	   
		      }
		 
		   catch (Exception ex) {			
		   }
	     return result;

	}
}
/*
 
 Weather data for Bellevue
 
 https://api.openweathermap.org/data/2.5/weather?q=Bellevue&appid=53cb. . . . . .

YOU MUST UNDERSTAND THIS JSON STRUCTURE

 {
"coord":{"lon":-122.2007,"lat":47.6104},
"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],
"base":"stations",
"main":{"temp":284.23,"feels_like":283.82,"temp_min":282.34,"temp_max":285.5,"pressure":1024,"humidity":93},
"visibility":10000,
"wind":{"speed":0.89,"deg":279,"gust":2.68},
"clouds":{"all":90},
"dt":1636777853,
"sys":{"type":2,"id":2035708,"country":"US","sunrise":1636729809,"sunset":1636763762},
"timezone":-28800,
"id":5786882,
"name":"Bellevue",
"cod":200
}

  

 */

