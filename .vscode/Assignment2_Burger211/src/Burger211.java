// Ema Ikeda
// ID: 950607512
// 10/14/21
// Superclass of USA.java and Japan.java that Contains abstract methods for those two subclasses in order to create a menu for each country.

import java.util.*;

class BurgerInfo {
    String name;
    double price;
    String topping;

    protected BurgerInfo(String name, double price, String topping) { // ??? Should this constructor be encapsulated?
        this.name = name;
        this.price = price;
        this.topping = topping;
    }
}

public abstract class Burger211 {
    private ArrayList <BurgerInfo> Burger = new ArrayList<>();
    Burger211() {
        Burger.add(new BurgerInfo("Inheritance Burger", 3.0, "beef patty, tomato, onion, ranch sauce"));
        Burger.add(new BurgerInfo("Overriding Burger", 2.0, "beef patty, lime, onion, lettuce, tomato sauce"));
        Burger.add(new BurgerInfo("Polymorphism Burger", 3.5, "chicken breast, gallo, onion, ranch sauce"));
    }

    // Get the name of the burger of the given index
    public String getBurgerName(int i) {
        return Burger.get(i).name;
    }

    // Get the price of a burger of the given index
    public double getBurgerPrice(int i) {
        return Burger.get(i).price;
    }

    // Get the toppings of a burger of the given index
    public String getBurgerTopping(int i) {
        return Burger.get(i).topping;
    }

    // Get the number of burgers in menu
    public int getHowManyBurgers () {
        return Burger.size();
    }

    // Print menu for the given franchise
    abstract void Menu(String franchise);
    
    // Do promotion for the given franchise
    abstract void Promotion(Double discountRate, String promote);

}
