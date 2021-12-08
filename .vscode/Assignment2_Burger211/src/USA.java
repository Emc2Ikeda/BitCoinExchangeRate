// Ema Ikeda
// ID: 950607512
// 10/14/21
// Create Burger211's USA branch menu and promotion. Uses abstract methods from superclass Burger211.

import java.text.DecimalFormat;

public class USA extends Burger211 {
    String [] burgerNamePrice = new String[getHowManyBurgers()];
    double discountRate; // Discount Rate
    String pro; // Promotion message

    @Override
    public void Promotion(Double discount, String promote) {
        discountRate = discount;
        pro = promote;
    }
    
    @Override // Print out menu for US franchises
    public void Menu(String franchise) {
        DecimalFormat df = new DecimalFormat("#,###,###.00");
        for (int i = 0; i < getHowManyBurgers(); i++) {
            burgerNamePrice[i] = getBurgerName(i) + " / " + "$" + df.format(getBurgerPrice(i) * (1.0 - discountRate));
            if (discountRate > 0.0) {
                burgerNamePrice[i] += " (regular:" + df.format(getBurgerPrice(i)) + ")";
            }
        }
        // Call API
        new MenuGUI(franchise, pro, burgerNamePrice[0], getBurgerTopping(0), burgerNamePrice[1], getBurgerTopping(1), burgerNamePrice[2], getBurgerTopping(2));
    }
}
