package sample.cafekiosk.unit;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import sample.cafekiosk.beverage.Beverage;
import sample.cafekiosk.order.Order;

@Getter
public class CafeKiosk {

  public static final LocalTime SHOP_OPEN_TIME = LocalTime.of(10, 0);
  public static final LocalTime SHOP_CLOSE_TIME = LocalTime.of(22, 0);

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

  public Order createOrder(LocalDateTime currentDatetime) {
    LocalTime currentTime = currentDatetime.toLocalTime();
    if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
      throw new IllegalStateException("shop is closed");
    }

    return new Order(currentDatetime, beverages);
  }

}
