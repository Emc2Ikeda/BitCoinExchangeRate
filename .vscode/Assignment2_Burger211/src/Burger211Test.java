// Ema Ikeda
// ID: 950607512
// 10/14/21
// Test program for Buger211 class

public class Burger211Test {
    public static void main(String[] args) throws Exception {
        Burger211 Bellevue = new USA();
        Bellevue.Promotion(0.2, "20% off any item from menu if you show off a costume.");
        Bellevue.Menu("Bellevue");

        Burger211 LA = new USA();
        LA.Promotion(0.1, "40% off any item from menu if you are vaccinated. Show us the QR code!");
        LA.Menu("Los Angeles");

        Burger211 Tokyo = new Japan();
        Tokyo.Promotion(0.15, "Morning special: 15% off any item from menu from 6AM to 10AM.");
        Tokyo.Menu("Tokyo"); // TODO: fix menu's bug

        Burger211 Osaka = new Japan();
        Osaka.Promotion(0.10, "Special offer! 10% off any item if ordered via drive through, delivery, or curbside pickup.");
        Osaka.Menu("Osaka");
    }
}
