// Ema Ikeda
// ID: 950607512
// 11/08/21
// Driver code to test Weather API. Requests the API to retrieve the specific information about the weather in the city selected by the user.

import java.util.*;

public class WeatherTest {
    public static String codeToAPICategory(int code) { // convert category into format in JSON file
        String apiCategory = "";
        switch (code) {
            case 1:
                apiCategory = "main";
                break;
            case 2: 
                apiCategory = "temp";
                break;
            case 3: 
                apiCategory = "pressure";
                break;
            case 4: 
                apiCategory = "humidity";
                break;
            case 5:
                apiCategory = "deg";
                break;
            case 6: 
                apiCategory = "speed";
                break;
            case 7:
                apiCategory = "gust";
                break;
            default:
                System.out.println("Invalid input. Type a number 1-7.");
                break;
        }
        return apiCategory;
    }

    public static String APItoCategory(String apiCategory) {
        String category = "";
        switch (apiCategory) {
            case "main":
                category = "Overall Weather";
                break;
            case "temp":
                category = "Temperature";
                break;
            case "pressure":
                category = "Pressure";
                break;
            case "humidity":
                category = "Humidity";
                break;
            case "deg":
                category = "Wind Degree";
                break;
            case "speed":
                category = "Wind Speed";
                break;
            case "gust":
                category = "Wind Gust";
                break;
            default:
                break;
        }
        return category;
    }
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String result = "";

        while (true) {
            System.out.println("Select a city:\n 1: Bellevue \n 2: Tehran \n 3: Hong Kong \n 4: New Delhi \n 5: Paris \n 6: Cairo \n 7: Moscow \n 8: Tokyo \n 9: Sydney \n 10: Cape Town \n 0: exit");
            String cityName = "";
            int cityCode;
            String city = input.next();
            // Select city: Set cityName to specific city based on code inputted by user. 
            // If user typed 0, exit the loop and close the program

            try{   
                cityCode = Integer.parseInt(city);
            } catch (NumberFormatException e){  // if input error happened 
                System.out.println("Invalid input. Type a number 0-10.");   
                continue;
            }

            if (cityCode == 0) {
                break;
            }

            boolean validCityCode = false;
            while (!validCityCode) {
                switch (cityCode) {
                    case 1: 
                        cityName = "Bellevue";
                        break;
                    case 2: 
                        cityName = "Tehran";
                        break;
                    case 3: 
                        cityName = "Hong Kong";
                        break;
                    case 4: 
                        cityName = "New Delhi";
                        break;
                    case 5: 
                        cityName = "Paris";
                        break;
                    case 6: 
                        cityName = "Cairo";
                        break;
                    case 7: 
                        cityName = "Moscow";
                        break;
                    case 8: 
                        cityName = "Tokyo";
                        break;
                    case 9: 
                        cityName = "Sydney";
                        break;
                    case 10: 
                        cityName = "Cape Town";
                        break;
                    default: 
                        System.out.println("Invalid number. Type numbers 0-10.");
                        break;
                }
                if (cityName != "") {
                    validCityCode = true;
                } else {
                    cityCode = input.nextInt();
                }
            }

            // Select weather category: Set category to specific city based on code inputted by user.
            System.out.println("Select a weather category:\n 1: Overall Weather \n 2: Temperature \n 3: Pressure \n 4: Humidity \n 5: Wind Degree \n 6: Wind Speed \n 7: Wind Gust");
            int categoryCode;
            String code = input.next();
            try{
                categoryCode = Integer.parseInt(code);
                String category = codeToAPICategory(categoryCode);
                if (category == "temp" || category == "speed" || category == "gust") {
                    // Select units: User can change to metric or imperial. Standard if invalid input or no input
                    System.out.println("Optional: Select unit measurement: \n 1: Metric \n 2: Imperial");
                    int unitCode;
                    String unit = input.next(); // User can also press enter to move onto standard units
                    try {
                        unitCode = Integer.parseInt(unit);
                        switch (unitCode) {
                            case 1:
                                unit = "metric";
                                result = WeatherAPI.getCityWeather(cityName, category, unit);
                                break;
                            case 2:
                                unit = "imperial";
                                result = WeatherAPI.getCityWeather(cityName, category, unit);
                                break;
                            default:
                                unit = "";
                                result = WeatherAPI.getCityWeather(cityName, category); // call vanilla version
                                break;
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Using standard measurements.");
                        result = WeatherAPI.getCityWeather(cityName, category);
                    }              
                } else {
                    result = WeatherAPI.getCityWeather(cityName, category);
                }
                 
                System.out.println();
                System.out.println("=== Weather Information ===");
                System.out.println("City: " + cityName);
                System.out.println(APItoCategory(category) +": "+ result);    
            }
            catch(NumberFormatException e) {
                System.out.println("Invalid input. Type a number 1-7.");
            }
        }
        input.close();
    }
}
