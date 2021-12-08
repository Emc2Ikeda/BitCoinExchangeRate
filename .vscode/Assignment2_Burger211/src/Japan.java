// Ema Ikeda
// ID: 950607512
// 10/14/21
// Creates Burger211's Japanese branch menu and promotion. Uses abstract methods from superclass Burger211.
    // Also converts original price of burgers (USD) to JPY

// ??? Is DecimalFormat necessary?
import java.text.DecimalFormat;

public class Japan extends Burger211 {
    String [] burgerNamePrice = new String[getHowManyBurgers()]; // Would it be better to use ArrayList?
    double discountRate; // Discount Rate
    String pro; // Promotion message
    // TODO: get exchange rate for usd to jpy in real time using big data
    double exchangeRate = 114.54;

    @Override // Convert the base price of selected burger to local price
    public double getBurgerPrice(int i) {
        return super.getBurgerPrice(i) * exchangeRate;
    }

    @Override // Customize the topping of Override Burger
    public String getBurgerTopping(int i) {
        if (i == 2) {
            return "chicken breast, onion, tomato, ketchup, mayo";
        } else {
            return super.getBurgerTopping(i);
        }
    }

    @Override
    public void Promotion(Double discount, String promote) {
        discountRate = discount;
        pro = promote;
    }
    
    @Override // Print out menu for Japanese franchises
    public void Menu(String franchise) {
        // DecimalFormat df = new DecimalFormat("#,###,###.00"); // TODO: get rid of decimals
        for (int i = 0; i < getHowManyBurgers(); i++) {
            int burgerPrice = (int)Math.round(getBurgerPrice(i)); // Round to nearest JPY
            burgerNamePrice[i] = getBurgerName(i) + " / " + (int)Math.round(burgerPrice * (1.0 - discountRate)) + "円";
            // burgerNamePrice[i] = getBurgerName(i) + " / " + df.format(getBurgerPrice(i) * (1.0 - discountRate) + "円");
            if (discountRate > 0.0) {
                // burgerNamePrice[i] += " (regular:" + df.format(getBurgerPrice(i)) + ")";
                burgerNamePrice[i] += " (regular:" + burgerPrice + "円)";
            }
        }
        // Call API
        new MenuGUI(franchise, pro, burgerNamePrice[0], getBurgerTopping(0), burgerNamePrice[1], getBurgerTopping(1), burgerNamePrice[2], getBurgerTopping(2));
    }
}
