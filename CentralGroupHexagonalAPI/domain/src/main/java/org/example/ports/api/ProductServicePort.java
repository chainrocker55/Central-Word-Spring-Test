package org.example.ports.api;

import org.example.data.ProductDto;

import java.util.Map;

public interface ProductServicePort {

    ProductDto addProduct(ProductDto productDto);

    void deleteProductById(Integer id);

    ProductDto updateProduct(ProductDto productDto);

    Map<Integer, ProductDto> getProducts();

    ProductDto getProductById(Integer productId);
}
