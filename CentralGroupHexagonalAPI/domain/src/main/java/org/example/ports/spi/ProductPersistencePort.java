package org.example.ports.spi;

import org.example.data.ProductDto;

import java.util.List;

public interface ProductPersistencePort {
    ProductDto addBook(ProductDto productDto);

    void deleteBookById(Long id);

    ProductDto updateBook(ProductDto productDto);

    List<ProductDto> getBooks();

    ProductDto getBookById(Long bookId);

}
