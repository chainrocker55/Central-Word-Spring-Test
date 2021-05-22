package org.example.service;

import org.example.data.ProductDto;
import org.example.ports.api.ProductPostmanServicePort;
import org.example.ports.spi.ProductPostmanPersistencePort;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public class ProductPostmanServiceImpl implements ProductPostmanServicePort {
    private ProductPostmanPersistencePort productPostmanPersistencePort;

    public ProductPostmanServiceImpl(ProductPostmanPersistencePort productPersistencePort) {
        this.productPostmanPersistencePort = productPersistencePort;
    }
    @Cacheable("getAllProductByPostman")
    @Override
    public List<ProductDto> getProducts() {
        return productPostmanPersistencePort.getProducts();
    }
}
