import java.util.*;
import java.io.*;
import java.text.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.net.*;

public class BitCoinPrice {

    public static double getRate(JSONObject currency) {
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault()); // Ready to read number
        Number number;
        double price = 0.00;
        try {
            number = format.parse((String) currency.get("rate"));
            price = number.doubleValue(); // type casting
        } catch (ParseException e) {
            e.printStackTrace();
        }  
        // read “rate” from usd object, 
        return price;
    }

    public static String getDescription(JSONObject currency) {
        String descr= "";
        descr = (String) currency.get("description"); // read “description” from usd object.
        return descr;
    }

    private static String coinURL = "https://api.coindesk.com/v1/bpi/currentprice.json";
    public static void main(String[] args) throws Exception {
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(coinURL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = "";
            while (null != (str = br.readLine())) {
                builder.append(str + "\n");
            }
            JSONParser jsonParser = new JSONParser(); 
            Object obj = jsonParser.parse(builder.toString());
            JSONObject jsonObject = (JSONObject)obj;
            JSONObject bpi = (JSONObject)jsonObject.get("bpi");  // Create JSON object, read “bpi”. save it into bpi object   
            
            // USD
            JSONObject usd = (JSONObject)bpi.get("USD");  // Create JSON object usd, select “USD” from bpi object. save it into usd
            System.out.println(getDescription(usd));
            System.out.println(getRate(usd));
            
            // GBP
            JSONObject gbp = (JSONObject)bpi.get("GBP");  // Create JSON object usd, select “USD” from bpi object. save it into usd
            System.out.println(getDescription(gbp));
            System.out.println(getRate(gbp));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
