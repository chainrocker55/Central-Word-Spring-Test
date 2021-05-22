package org.example.ports.api;

import org.example.data.ProductDto;

import java.util.List;

public interface ProductPostmanServicePort {
    List<ProductDto> getProducts();
}
