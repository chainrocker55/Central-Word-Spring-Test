
package org.example.controller;

import org.example.data.ProductDto;
import org.example.ports.api.ProductServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/database/product")
public class ProductController {

    @Autowired
    private ProductServicePort productServicePort;

    @PostMapping("/add")
    public ProductDto addBook(@RequestBody ProductDto productDto) {
        return productServicePort.addProduct(productDto);
    }

    @PutMapping("/update")
    public ProductDto updateBook(@RequestBody ProductDto productDto) {
        return productServicePort.updateProduct(productDto);
    }

    @GetMapping("/get/{id}")
    public ProductDto getBookByID(@PathVariable int id) {
        return productServicePort.getProducts().get(id);
    }

    @GetMapping("/get")
    public List<ProductDto> getAllBooks() {

        return new ArrayList<>(productServicePort.getProducts().values());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBookByID(@PathVariable int id) {
        productServicePort.deleteProductById(id);
    }
}
