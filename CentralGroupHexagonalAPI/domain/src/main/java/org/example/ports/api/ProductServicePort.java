package org.example.ports.api;

import org.example.data.ProductDto;

import java.util.List;

public interface ProductServicePort {

    ProductDto addBook(ProductDto productDto);

    void deleteBookById(Long id);

    ProductDto updateBook(ProductDto productDto);

    List<ProductDto> getBooks();

    ProductDto getBookById(Long bookId);
}
