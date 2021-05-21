package org.example.service;

import org.example.data.ProductDto;
import org.example.ports.api.ProductServicePort;
import org.example.ports.spi.ProductPersistencePort;

import java.util.List;

public class ProductServiceImpl implements ProductServicePort {
    private ProductPersistencePort productPersistencePort;

    public ProductServiceImpl(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public ProductDto addBook(ProductDto productDto) {
        return productPersistencePort.addBook(productDto);
    }

    @Override
    public void deleteBookById(Long id) {
        productPersistencePort.deleteBookById(id);
    }

    @Override
    public ProductDto updateBook(ProductDto productDto) {
        return productPersistencePort.updateBook(productDto);
    }

    @Override
    public List<ProductDto> getBooks() {
        return productPersistencePort.getBooks();
    }

    @Override
    public ProductDto getBookById(Long bookId) {
        return productPersistencePort.getBookById(bookId);
    }
}
