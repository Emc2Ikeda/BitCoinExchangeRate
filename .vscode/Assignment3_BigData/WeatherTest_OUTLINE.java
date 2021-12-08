import java.util.HashMap;
import java.util.Scanner;

public class WeatherTest_OUTLINE {

// This is an outline.
	
	   public static void main(String[] args) throws Exception {
	
	
		   System.out.println("Welcome to Weather 211");
		   System.out.println();
		   	   
		   // just to test
		   String city = "Bellevue";
		   String category ="temp";
		   
		   String result = WeatherAPI_OUTLINE.getCityWeather(city,category);
	    
		   System.out.println();
		   System.out.println("=== Weather Information ===");
		   System.out.println("City: " + city);
		   System.out.println(category +": "+ result);
		   
		}
	   
	
}
