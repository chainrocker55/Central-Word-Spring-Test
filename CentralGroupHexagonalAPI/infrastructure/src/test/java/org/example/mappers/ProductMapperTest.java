package org.example.mappers;

import org.example.data.ProductDto;
import org.example.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitPlatform.class)
class ProductMapperTest {
    @Test
    public void givenProductDtoToProductEntity_whenMaps_thenCorrect() {
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setName("Toyota");
        productDto.setDescription("หนังสือเรียน");
        productDto.setPrice(500.0);

        Product entity = ProductMapper.INSTANCE.productDtoToProduct(productDto);
        assertEquals(productDto.getId(),entity.getId());
        assertEquals(productDto.getName(),entity.getName());
        assertEquals(productDto.getDescription(),entity.getDescription());
        assertEquals(productDto.getPrice(),entity.getPrice());


    }
    @Test
    public void givenProductEntityToProductDto_whenMaps_thenCorrect() {
        Product entity = new Product();
        entity.setId(1);
        entity.setName("Toyota");
        entity.setDescription("หนังสือเรียน");
        entity.setPrice(500.0);

        ProductDto productDto = ProductMapper.INSTANCE.productToProductDto(entity);
        assertEquals(productDto.getId(),entity.getId());
        assertEquals(productDto.getName(),entity.getName());
        assertEquals(productDto.getDescription(),entity.getDescription());
        assertEquals(productDto.getPrice(),entity.getPrice());


    }
    @Test
    public void givenProductEntityListToProductDtoList_whenMaps_thenCorrect() {
        List<Product> productsEntity = new ArrayList<>();
        for(int i = 1;i<=3;i++){
            Product entity = new Product();
            entity.setId(i);
            entity.setName("Toyota_"+i);
            entity.setDescription("หนังสือเรียน"+i);
            entity.setPrice(500.0+i);
            productsEntity.add(entity);
        }

        List<ProductDto> productDto = ProductMapper.INSTANCE.productListToProductDtoList(productsEntity);

        assertEquals(productDto.get(0).getId(),productsEntity.get(0).getId());
        assertEquals(productDto.get(0).getName(),productsEntity.get(0).getName());
        assertEquals(productDto.get(0).getDescription(),productsEntity.get(0).getDescription());
        assertEquals(productDto.get(0).getPrice(),productsEntity.get(0).getPrice());

        assertEquals(productDto.get(1).getId(),productsEntity.get(1).getId());
        assertEquals(productDto.get(1).getName(),productsEntity.get(1).getName());
        assertEquals(productDto.get(1).getDescription(),productsEntity.get(1).getDescription());
        assertEquals(productDto.get(1).getPrice(),productsEntity.get(1).getPrice());


        assertEquals(productDto.get(2).getId(),productsEntity.get(2).getId());
        assertEquals(productDto.get(2).getName(),productsEntity.get(2).getName());
        assertEquals(productDto.get(2).getDescription(),productsEntity.get(2).getDescription());
        assertEquals(productDto.get(2).getPrice(),productsEntity.get(2).getPrice());

    }
    @Test
    public void givenProductDtoListToProductEntityList_whenMaps_thenCorrect() {
        List<ProductDto> productsDto = new ArrayList<>();
        for(int i = 1;i<=3;i++){
            ProductDto productDto = new ProductDto();
            productDto.setId(i);
            productDto.setName("Toyota_"+i);
            productDto.setDescription("หนังสือเรียน"+i);
            productDto.setPrice(500.0+i);
            productsDto.add(productDto);
        }

        List<Product> productDto = ProductMapper.INSTANCE.productDtoListToProductList(productsDto);

        assertEquals(productDto.get(0).getId(),productsDto.get(0).getId());
        assertEquals(productDto.get(0).getName(),productsDto.get(0).getName());
        assertEquals(productDto.get(0).getDescription(),productsDto.get(0).getDescription());
        assertEquals(productDto.get(0).getPrice(),productsDto.get(0).getPrice());

        assertEquals(productDto.get(1).getId(),productsDto.get(1).getId());
        assertEquals(productDto.get(1).getName(),productsDto.get(1).getName());
        assertEquals(productDto.get(1).getDescription(),productsDto.get(1).getDescription());
        assertEquals(productDto.get(1).getPrice(),productsDto.get(1).getPrice());


        assertEquals(productDto.get(2).getId(),productsDto.get(2).getId());
        assertEquals(productDto.get(2).getName(),productsDto.get(2).getName());
        assertEquals(productDto.get(2).getDescription(),productsDto.get(2).getDescription());
        assertEquals(productDto.get(2).getPrice(),productsDto.get(2).getPrice());


    }
}