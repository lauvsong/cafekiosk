package sample.cafekiosk.beverage;

public class Americano implements Beverage {
    @Override
    public int getPrice() {
        return 4000;
    }

    @Override
    public String getName() {
        return "Americano";
    }
}
