
package org.example.controller;

import org.example.data.ProductDto;
import org.example.ports.api.ProductServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/database/product")
public class ProductController {

    @Autowired
    private ProductServicePort productServicePort;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @PostMapping("/add")
    public ProductDto addBook(@RequestBody ProductDto productDto) {
        return productServicePort.addProduct(productDto);
    }

    @PutMapping("/update")
    public ProductDto updateBook(@RequestBody ProductDto productDto) {
        return productServicePort.updateProduct(productDto);
    }

    @GetMapping("/get/{id}")
    public ProductDto getBookByID(@PathVariable long id) {
        return productServicePort.getProductById(id);
    }

    @GetMapping("/get")
    public List<ProductDto> getAllBooks() {
        return productServicePort.getProducts();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBookByID(@PathVariable long id) {
        productServicePort.deleteProductById(id);
    }
}
