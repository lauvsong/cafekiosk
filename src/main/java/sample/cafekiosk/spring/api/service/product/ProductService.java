package sample.cafekiosk.spring.api.service.product;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.cafekiosk.spring.api.service.product.request.ProductCreateServiceRequest;
import sample.cafekiosk.spring.api.service.product.response.ProductResponse;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductRepository;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<ProductResponse> getSellingProducts() {
    List<Product> products = productRepository.findAllBySellingStatusIn(
        ProductSellingStatus.forDisplay());

    return products.stream()
        .map(ProductResponse::of)
        .toList();
  }

  public ProductResponse createProduct(ProductCreateServiceRequest request) {
    String nextProductNumber = createNextProductNumber();

    Product product = request.toEntity(nextProductNumber);
    Product savedProduct = productRepository.save(product);

    return ProductResponse.of(savedProduct);
  }

  private String createNextProductNumber() {
    String latestProductNumber = productRepository.findLatestProductNumber();
    if (latestProductNumber == null) {
      return "001";
    }

    int latestProductNumberInt = Integer.parseInt(latestProductNumber);
    int nextProductNumberInt = latestProductNumberInt + 1;
    return String.format("%03d", nextProductNumberInt);
  }
}
