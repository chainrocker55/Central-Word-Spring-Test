
package org.example.controller;

import org.example.data.ProductDto;
import org.example.ports.api.ProductServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class ProductController {

    @Autowired
    private ProductServicePort productServicePort;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @PostMapping("/add")
    public ProductDto addBook(@RequestBody ProductDto productDto) {
        return productServicePort.addBook(productDto);
    }

    @PutMapping("/update")
    public ProductDto updateBook(@RequestBody ProductDto productDto) {
        return productServicePort.updateBook(productDto);
    }

    @GetMapping("/get/{id}")
    public ProductDto getBookByID(@PathVariable long id) {
        return productServicePort.getBookById(id);
    }

    @GetMapping("/get")
    public List<ProductDto> getAllBooks() {
        return productServicePort.getBooks();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBookByID(@PathVariable long id) {
        productServicePort.deleteBookById(id);
    }
}
