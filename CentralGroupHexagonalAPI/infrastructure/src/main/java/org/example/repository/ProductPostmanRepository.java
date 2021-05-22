package org.example.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.data.ProductDto;
import org.example.entity.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductPostmanRepository {

    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "http://www.postman-echo.com";

    public List<Product> findAll() {

        List<ProductDto> productsDto = new ArrayList<>();
        for(int i = 1;i<=10;i++){
            ProductDto productDto = new ProductDto();
            productDto.setId(i);
            productDto.setName("Programmer_"+i);
            productDto.setDescription("หนังสือเรียน"+i);
            productDto.setPrice(500.0+i);
            productsDto.add(productDto);
        }

        Product[] products =  null;
        HttpEntity<List<ProductDto>> request = new HttpEntity<>(productsDto);
        ResponseEntity<String>  response = restTemplate.postForEntity(fooResourceUrl+"/post", request,String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(response.getBody());
            JsonNode data = root.path("data");
            products = mapper.treeToValue(data,Product[].class);


        } catch (JsonProcessingException e) {
            return null;
        }


        return Arrays.asList(products.clone());

    }
}
