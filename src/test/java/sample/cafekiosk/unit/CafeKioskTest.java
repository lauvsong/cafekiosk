package sample.cafekiosk.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import sample.cafekiosk.beverage.Americano;
import sample.cafekiosk.beverage.Latte;

class CafeKioskTest {

  @Test
  void add_manual_test() {
    CafeKiosk cafeKiosk = new CafeKiosk();
    cafeKiosk.add(new Americano());

    System.out.println(">>> beverage count: " + cafeKiosk.getBeverages().size());
    System.out.println(">>> beverage: " + cafeKiosk.getBeverages().get(0).getName());
  }

  @Test
  void add() {
    CafeKiosk cafeKiosk = new CafeKiosk();
    cafeKiosk.add(new Americano());

    assertThat(cafeKiosk.getBeverages()).hasSize(1);
    assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("Americano");
  }

  @Test
  void remove() {
    CafeKiosk cafeKiosk = new CafeKiosk();
    Americano americano = new Americano();

    cafeKiosk.add(americano);
    assertThat(cafeKiosk.getBeverages()).hasSize(1);

    cafeKiosk.remove(americano);
    assertThat(cafeKiosk.getBeverages()).isEmpty();
  }

  @Test
  void clear() {
    CafeKiosk cafeKiosk = new CafeKiosk();

    cafeKiosk.add(new Americano());
    cafeKiosk.add(new Latte());
    assertThat(cafeKiosk.getBeverages()).hasSize(2);

    cafeKiosk.clear();
    assertThat(cafeKiosk.getBeverages()).isEmpty();
  }

}