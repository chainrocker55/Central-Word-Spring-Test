package org.example.adapters;

import org.example.data.ProductDto;
import org.example.entity.Product;
import org.example.mappers.ProductMapper;
import org.example.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ProductJpaAdapterTest {
    @InjectMocks
    private ProductJpaAdapter productJpaAdapter;

    @Mock
    private ProductRepository productRepository;

    @Test
    void addProduct_returnProduct(){
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setName("Test");
        productDto.setDescription("Description");
        productDto.setPrice(100.0);

        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);

        when(productRepository.save(product)).thenReturn(product);
        ProductDto productDtoReturn = productJpaAdapter.addProduct(productDto);

        verify(productRepository,atLeastOnce()).save(product);
        assertEquals(productDto.getId(),productDtoReturn.getId());
        assertEquals(productDto.getName(),productDtoReturn.getName());
        assertEquals(productDto.getDescription(),productDtoReturn.getDescription());
        assertEquals(productDto.getPrice(),productDtoReturn.getPrice());
    }
    @Test
    void deleteProduct_returnProduct(){
        doNothing().when(productRepository).deleteById(1);
        productJpaAdapter.deleteProductById(1);
        verify(productRepository,atLeastOnce()).deleteById(1);

    }
    @Test
    void updateProduct_returnProduct(){
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setName("Test");
        productDto.setDescription("Description");
        productDto.setPrice(100.0);

        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);

        when(productRepository.save(product)).thenReturn(product);
        ProductDto productDtoReturn = productJpaAdapter.updateProduct(productDto);

        verify(productRepository,atLeastOnce()).save(product);
        assertEquals(productDto.getId(),productDtoReturn.getId());
        assertEquals(productDto.getName(),productDtoReturn.getName());
        assertEquals(productDto.getDescription(),productDtoReturn.getDescription());
        assertEquals(productDto.getPrice(),productDtoReturn.getPrice());

    }
    @Test
    void getProductById_returnProduct(){
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setName("Test");
        productDto.setDescription("Description");
        productDto.setPrice(100.0);
        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);
        when(productRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(product));
        ProductDto productDtoReturn = productJpaAdapter.getProductById(1);

        verify(productRepository,atLeastOnce()).findById(1);
        assertEquals(productDto.getId(),productDtoReturn.getId());
        assertEquals(productDto.getName(),productDtoReturn.getName());
        assertEquals(productDto.getDescription(),productDtoReturn.getDescription());
        assertEquals(productDto.getPrice(),productDtoReturn.getPrice());

    }

    @Test
    void getAllProduct_returnAllProduct(){
        List<ProductDto> productsDto = new ArrayList<>();
        for(int i = 1;i<=3;i++){
            ProductDto productDto = new ProductDto();
            productDto.setId(i);
            productDto.setName("Toyota_"+i);
            productDto.setDescription("หนังสือเรียน"+i);
            productDto.setPrice(500.0+i);
            productsDto.add(productDto);
        }

        List<Product> products = ProductMapper.INSTANCE.productDtoListToProductList(productsDto);

        when(productRepository.findAll()).thenReturn(products);
        List<ProductDto> hm = productJpaAdapter.getProducts();

        verify(productRepository,atLeastOnce()).findAll();
        assertEquals(hm.size(),productsDto.size());


    }


}