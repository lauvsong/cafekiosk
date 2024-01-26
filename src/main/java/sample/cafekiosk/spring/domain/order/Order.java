package sample.cafekiosk.spring.domain.order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.cafekiosk.spring.domain.BaseEntity;
import sample.cafekiosk.spring.domain.orderproduct.OrderProduct;
import sample.cafekiosk.spring.domain.product.Product;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;

  private int totalPrice;

  private LocalDateTime registeredDatetime;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderProduct> orderProducts = new ArrayList<>();

  public Order(List<Product> products, LocalDateTime registeredDatetime) {
    this.orderStatus = OrderStatus.INIT;
    this.registeredDatetime = registeredDatetime;
    this.totalPrice = calculateTotalPrice(products);
    this.orderProducts = products.stream()
        .map(product -> OrderProduct.create(this, product))
        .toList();
  }

  private static int calculateTotalPrice(List<Product> products) {
    return products.stream().mapToInt(Product::getPrice).sum();
  }

  public static Order create(List<Product> products, LocalDateTime registeredDatetime) {
    return new Order(products, registeredDatetime);
  }
}
