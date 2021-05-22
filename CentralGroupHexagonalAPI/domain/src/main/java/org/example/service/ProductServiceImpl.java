package org.example.service;

import org.example.data.ProductDto;
import org.example.ports.api.ProductServicePort;
import org.example.ports.spi.ProductPersistencePort;
import org.springframework.cache.annotation.Cacheable;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductServicePort {
    private ProductPersistencePort productPersistencePort;

    public ProductServiceImpl(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        return productPersistencePort.addProduct(productDto);
    }

    @Override
    public void deleteProductById(Integer id) {
        productPersistencePort.deleteProductById(id);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return productPersistencePort.updateProduct(productDto);
    }

    @Cacheable("getAllProductByH2")
    @Override
    public Map<Integer, ProductDto> getProducts() {
        Map<Integer, ProductDto> hm = productPersistencePort.getProducts()
                .stream().
                parallel().
                collect(Collectors.toMap(ProductDto::getId, Function.identity()));

        return hm;
    }

    @Override
    public ProductDto getProductById(Integer productId) {
        return productPersistencePort.getProductById(productId);
    }
}
