package org.example.controller;

import org.example.data.ProductDto;
import org.example.ports.api.ProductPostmanServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/postman/product")
public class ProductPostmanController {

    @Autowired
    private ProductPostmanServicePort productPostmanServicePort;

    @GetMapping("/get")
    public List<ProductDto> getAllBooks() {
       return productPostmanServicePort.getProducts();
    }




}
