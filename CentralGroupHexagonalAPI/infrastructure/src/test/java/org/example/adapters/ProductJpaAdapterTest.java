package org.example.adapters;

import org.example.data.ProductDto;
import org.example.repository.ProductRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ProductJpaAdapterTest {
    @Mock
    private ProductJpaAdapter productJpaAdapter;

    @InjectMocks
    private ProductRepository productRepository;

    @Disabled
    @Test
    void addProduct_returnProduct(){
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setName("Test");
        productDto.setDescription("Description");
        productDto.setPrice(100.0);

        ProductDto productDtoReturn = productJpaAdapter.addProduct(productDto);
        assertEquals(productDto.getId(),productDtoReturn.getId());
        assertEquals(productDto.getName(),productDtoReturn.getName());
        assertEquals(productDto.getDescription(),productDtoReturn.getDescription());
        assertEquals(productDto.getPrice(),productDtoReturn.getPrice());
    }

}