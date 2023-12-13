package sample.cafekiosk.beverage;

import sample.cafekiosk.beverage.Beverage;

public class Latte implements Beverage {

    @Override
    public int getPrice() {
        return 4500;
    }

    @Override
    public String getName() {
        return "Latte";
    }

}
