package org.example.configuration;

import org.example.adapters.ProductJpaAdapter;
import org.example.ports.api.ProductServicePort;
import org.example.ports.spi.ProductPersistencePort;
import org.example.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public ProductPersistencePort productPersistence(){
        return new ProductJpaAdapter();
    }

    @Bean
    public ProductServicePort productService(){
        return new ProductServiceImpl(productPersistence());
    }
}