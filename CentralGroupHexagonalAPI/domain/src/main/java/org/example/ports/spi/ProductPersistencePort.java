package org.example.ports.spi;

import org.example.data.ProductDto;

import java.util.List;

public interface ProductPersistencePort {
    ProductDto addProduct(ProductDto productDto);

    void deleteProductById(Integer id);

    ProductDto updateProduct(ProductDto productDto);

    List<ProductDto> getProducts();

    ProductDto getProductById(Integer productId);

}
