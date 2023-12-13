package sample.cafekiosk.unit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import sample.cafekiosk.beverage.Beverage;
import sample.cafekiosk.order.Order;

@Getter
public class CafeKiosk {

  private final List<Beverage> beverages = new ArrayList<>();

  public void add(Beverage beverage) {
    beverages.add(beverage);
  }

  public void add(Beverage beverage, int count) {
    if (count <= 0) {
      throw new IllegalArgumentException("beverage count must be greater than 0");
    }
    
    for (int i = 0; i < count; i++) {
      beverages.add(beverage);
    }
  }

  public void remove(Beverage beverage) {
    beverages.remove(beverage);
  }

  public void clear() {
    beverages.clear();
  }

  public int calculateTotalPrice() {
    int totalPrice = 0;
    for (Beverage beverage : beverages) {
      totalPrice += beverage.getPrice();
    }
    return totalPrice;
  }

  public Order createOrder() {
    return new Order(LocalDateTime.now(), beverages);
  }

}
