
package org.example;

import org.example.data.ProductDto;
import org.example.ports.api.ProductServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class Application {

    @Autowired
    private ProductServicePort productServicePort;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void initialDataForTesting() {
        for(int i = 1; i<=10 ; i++){
            ProductDto product = new ProductDto();
            product.setId(i);
            product.setName("Product_"+i);
            product.setDescription("Product Episode "+i);
            product.setPrice(100.0);

            productServicePort.addProduct(product);
        }


    }
}