package sample.cafekiosk.unit;

import org.junit.jupiter.api.Test;
import sample.cafekiosk.beverage.Americano;
import sample.cafekiosk.beverage.Beverage;

import static org.junit.jupiter.api.Assertions.*;

class CafeKioskTest {

    @Test
    void add() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());

        System.out.println(">>> beverage count: " + cafeKiosk.getBeverages().size());
        System.out.println(">>> beverage: " + cafeKiosk.getBeverages().get(0).getName());
    }

}