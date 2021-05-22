
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
    public ProductDto addProduct(ProductDto productDto) {

        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);

        Product productSaved = productRepository.save(product);

        return ProductMapper.INSTANCE.productToProductDto(productSaved);
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return addProduct(productDto);
    }

    @Override
    public List<ProductDto> getProducts() {

        List<Product> productList = productRepository.findAll();

        return ProductMapper.INSTANCE.productListToProductDtoList(productList);
    }

    @Override
    public ProductDto getProductById(Integer productId) {

        Optional<Product> book = productRepository.findById(productId);

        return book.map(ProductMapper.INSTANCE::productToProductDto).orElse(null);

    }
}
