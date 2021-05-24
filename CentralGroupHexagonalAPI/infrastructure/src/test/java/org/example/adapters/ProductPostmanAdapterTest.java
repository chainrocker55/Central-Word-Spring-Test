package org.example.adapters;

import org.example.data.ProductDto;
import org.example.entity.Product;
import org.example.mappers.ProductMapper;
import org.example.repository.ProductPostmanRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ProductPostmanAdapterTest {
    @Mock
    private ProductPostmanRepository postmanRepository;

    @InjectMocks
    private ProductPostmanAdapter productPostmanAdapter;


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
        when(postmanRepository.findAll()).thenReturn(products);
        List<ProductDto> productsDtoReturn = productPostmanAdapter.getProducts();

        verify(postmanRepository,atLeastOnce()).findAll();
        assertEquals(productsDtoReturn.size(),productsDto.size());
        assertEquals(productsDtoReturn.get(0),productsDto.get(0));
        assertEquals(productsDtoReturn.get(1),productsDto.get(1));
        assertEquals(productsDtoReturn.get(2),productsDto.get(2));

    }
}