package org.example.service;

import org.example.data.ProductDto;
import org.example.ports.spi.ProductPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ProductServiceImplTest {

    @Mock
    private ProductPersistencePort productPersistencePort;

    @InjectMocks
    private ProductServiceImpl productService;


    @Test
    void addProduct_returnProduct(){
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setName("Test");
        productDto.setDescription("Description");
        productDto.setPrice(100.0);

        when(productPersistencePort.addProduct(productDto)).thenReturn(productDto);
        ProductDto productDtoReturn = productService.addProduct(productDto);

        verify(productPersistencePort,atLeastOnce()).addProduct(productDto);
        assertEquals(productDto.getId(),productDtoReturn.getId());
        assertEquals(productDto.getName(),productDtoReturn.getName());
        assertEquals(productDto.getDescription(),productDtoReturn.getDescription());
        assertEquals(productDto.getPrice(),productDtoReturn.getPrice());
    }
    @Test
    void deleteProduct_returnProduct(){
        doNothing().when(productPersistencePort).deleteProductById(1);
        productService.deleteProductById(1);
        verify(productPersistencePort,atLeastOnce()).deleteProductById(1);

    }
    @Test
    void updateProduct_returnProduct(){
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setName("Test");
        productDto.setDescription("Description");
        productDto.setPrice(100.0);

        when(productPersistencePort.updateProduct(productDto)).thenReturn(productDto);
        ProductDto productDtoReturn = productService.updateProduct(productDto);

        verify(productPersistencePort,atLeastOnce()).updateProduct(productDto);
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

        when(productPersistencePort.getProductById(1)).thenReturn(productDto);
        ProductDto productDtoReturn = productService.getProductById(1);

        verify(productPersistencePort,atLeastOnce()).getProductById(1);
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

        when(productPersistencePort.getProducts()).thenReturn(productsDto);
        Map<Integer, ProductDto> hm = productService.getProducts();

        verify(productPersistencePort,atLeastOnce()).getProducts();
        assertEquals(hm.size(),productsDto.size());

    }

}