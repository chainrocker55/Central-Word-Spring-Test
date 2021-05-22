package org.example.ports.spi;

import org.example.data.ProductDto;

import java.util.List;

public interface ProductPostmanPersistencePort {
    List<ProductDto> getProducts();
}
