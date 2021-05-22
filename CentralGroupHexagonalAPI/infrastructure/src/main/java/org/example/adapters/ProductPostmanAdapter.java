package org.example.adapters;


import org.example.data.ProductDto;
import org.example.entity.Product;
import org.example.mappers.ProductMapper;
import org.example.ports.spi.ProductPostmanPersistencePort;
import org.example.repository.ProductPostmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPostmanAdapter implements ProductPostmanPersistencePort {
    @Autowired
    private ProductPostmanRepository productPostmanRepository;

    @Override
    public List<ProductDto> getProducts() {

        List<Product> productList = productPostmanRepository.findAll();

        return ProductMapper.INSTANCE.productListToProductDtoList(productList);
    }

}
