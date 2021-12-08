// Ema Ikeda
// ID: 950607512
// 10/14/21
// Changes menu's price based on real-time exchange rate

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ExchangeRate {
    private static String rateURL = "https://v6.exchangerate-api.com/v6/bcc5a7e9209431d978618cdd/latest/USD";  // URL of JSON file
    private double exchangeRate = 100.0;
    // read JSON file
    private void readJSONFile () {
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(rateURL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = "";
            while (null != (str = br.readLine())) {
                builder.append(str + "\n");
            }
            static HashMap<String, Double> rates = new HashMap<>();
            Object object = parseJson(ratesURL);
            JSONObject jsonObject = (JSONObject)obj;
            rates = (HashMap<String, Double>) jsonObject.get("conversion_rates");
            // double exchangeRate = rates.get(“EUR”);  
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    double getExchangeRate(string country) { // TODO: Change to retrieve current exchange rate
        return exchangeRate;
    }
}
