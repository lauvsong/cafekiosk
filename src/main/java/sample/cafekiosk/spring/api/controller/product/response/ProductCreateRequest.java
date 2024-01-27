package sample.cafekiosk.spring.api.controller.product.response;

import lombok.Builder;
import lombok.Getter;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.ProductType;

@Getter
public class ProductCreateRequest {

  private String productNumber;
  private ProductType type;
  private ProductSellingStatus sellingStatus;
  private String name;
  private int price;

  @Builder
  public ProductCreateRequest(String productNumber, ProductType type,
      ProductSellingStatus sellingStatus, String name,
      int price) {
    this.productNumber = productNumber;
    this.type = type;
    this.sellingStatus = sellingStatus;
    this.name = name;
    this.price = price;
  }

  public Product toEntity(String productNumber) {
    return Product.builder()
        .productNumber(productNumber)
        .type(type)
        .sellingStatus(sellingStatus)
        .name(name)
        .price(price)
        .build();
  }
}
