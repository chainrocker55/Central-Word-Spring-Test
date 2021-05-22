package org.example.ports.api;

import org.example.data.ProductDto;

import java.util.List;

public interface ProductServicePort {

    ProductDto addProduct(ProductDto productDto);

    void deleteProductById(Long id);

    ProductDto updateProduct(ProductDto productDto);

    List<ProductDto> getProducts();

    ProductDto getProductById(Long bookId);
}
