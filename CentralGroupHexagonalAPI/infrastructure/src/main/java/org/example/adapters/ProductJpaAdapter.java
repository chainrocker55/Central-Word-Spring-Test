
package org.example.adapters;

import org.example.data.ProductDto;
import org.example.entity.Product;
import org.example.mappers.ProductMapper;
import org.example.repository.ProductRepository;
import org.example.ports.spi.ProductPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductJpaAdapter implements ProductPersistencePort {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto addBook(ProductDto productDto) {

        Product product = ProductMapper.INSTANCE.bookDtoToBook(productDto);

        Product productSaved = productRepository.save(product);

        return ProductMapper.INSTANCE.bookToBookDto(productSaved);
    }

    @Override
    public void deleteBookById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto updateBook(ProductDto productDto) {
        return addBook(productDto);
    }

    @Override
    public List<ProductDto> getBooks() {

        List<Product> productList = productRepository.findAll();

        return ProductMapper.INSTANCE.bookListToBookDtoList(productList);
    }

    @Override
    public ProductDto getBookById(Long bookId) {

        Optional<Product> book = productRepository.findById(bookId);

        if (book.isPresent()) {
            return ProductMapper.INSTANCE.bookToBookDto(book.get());
        }

        return null;
    }
}
