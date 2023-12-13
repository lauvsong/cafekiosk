package sample.cafekiosk.beverage;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AmericanoTest {

  @Test
  void getPrice() {
    Americano americano = new Americano();
    assertThat(americano.getPrice()).isEqualTo(4000);
  }

  @Test
  void getName() {
    Americano americano = new Americano();
    assertThat(americano.getName()).isEqualTo("Americano");
  }

}