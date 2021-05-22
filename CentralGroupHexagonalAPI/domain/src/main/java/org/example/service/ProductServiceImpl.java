package org.example.service;

import org.example.data.ProductDto;
import org.example.ports.api.ProductServicePort;
import org.example.ports.spi.ProductPersistencePort;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

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
    public void deleteProductById(Long id) {
        productPersistencePort.deleteProductById(id);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return productPersistencePort.updateProduct(productDto);
    }

    @Cacheable("getAllProduct")
    @Override
    public List<ProductDto> getProducts() {
        return productPersistencePort.getProducts();
    }

    @Override
    public ProductDto getProductById(Long bookId) {
        return productPersistencePort.getProductById(bookId);
    }
}
