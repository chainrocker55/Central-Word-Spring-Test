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
    public void givenBookDtoToBookEntity_whenMaps_thenCorrect() {
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setName("Toyota");
        productDto.setDescription("หนังสือเรียน");
        productDto.setPrice(500.0);

        Product entity = ProductMapper.INSTANCE.bookDtoToBook(productDto);
        assertEquals(productDto.getId(),entity.getId());
        assertEquals(productDto.getName(),entity.getName());
        assertEquals(productDto.getDescription(),entity.getDescription());
        assertEquals(productDto.getPrice(),entity.getPrice());


    }
    @Test
    public void givenBookEntityToBookDto_whenMaps_thenCorrect() {
        Product entity = new Product();
        entity.setId(1);
        entity.setName("Toyota");
        entity.setDescription("หนังสือเรียน");
        entity.setPrice(500.0);

        ProductDto productDto = ProductMapper.INSTANCE.bookToBookDto(entity);
        assertEquals(productDto.getId(),entity.getId());
        assertEquals(productDto.getName(),entity.getName());
        assertEquals(productDto.getDescription(),entity.getDescription());
        assertEquals(productDto.getPrice(),entity.getPrice());


    }
    @Test
    public void givenBookEntityListToBookDtoList_whenMaps_thenCorrect() {
        List<Product> booksEntity = new ArrayList<>();
        for(int i = 1;i<=3;i++){
            Product entity = new Product();
            entity.setId(i);
            entity.setName("Toyota_"+i);
            entity.setDescription("หนังสือเรียน"+i);
            entity.setPrice(500.0+i);
            booksEntity.add(entity);
        }

        List<ProductDto> productDto = ProductMapper.INSTANCE.bookListToBookDtoList(booksEntity);

        assertEquals(productDto.get(0).getId(),booksEntity.get(0).getId());
        assertEquals(productDto.get(0).getName(),booksEntity.get(0).getName());
        assertEquals(productDto.get(0).getDescription(),booksEntity.get(0).getDescription());
        assertEquals(productDto.get(0).getPrice(),booksEntity.get(0).getPrice());

        assertEquals(productDto.get(1).getId(),booksEntity.get(1).getId());
        assertEquals(productDto.get(1).getName(),booksEntity.get(1).getName());
        assertEquals(productDto.get(1).getDescription(),booksEntity.get(1).getDescription());
        assertEquals(productDto.get(1).getPrice(),booksEntity.get(1).getPrice());


        assertEquals(productDto.get(2).getId(),booksEntity.get(2).getId());
        assertEquals(productDto.get(2).getName(),booksEntity.get(2).getName());
        assertEquals(productDto.get(2).getDescription(),booksEntity.get(2).getDescription());
        assertEquals(productDto.get(2).getPrice(),booksEntity.get(2).getPrice());

    }
    @Test
    public void givenBookDtoListToBookEntityList_whenMaps_thenCorrect() {
        List<ProductDto> booksDto = new ArrayList<>();
        for(int i = 1;i<=3;i++){
            ProductDto productDto = new ProductDto();
            productDto.setId(i);
            productDto.setName("Toyota_"+i);
            productDto.setDescription("หนังสือเรียน"+i);
            productDto.setPrice(500.0+i);
            booksDto.add(productDto);
        }

        List<Product> productDto = ProductMapper.INSTANCE.BookDtoListToBookList(booksDto);

        assertEquals(productDto.get(0).getId(),booksDto.get(0).getId());
        assertEquals(productDto.get(0).getName(),booksDto.get(0).getName());
        assertEquals(productDto.get(0).getDescription(),booksDto.get(0).getDescription());
        assertEquals(productDto.get(0).getPrice(),booksDto.get(0).getPrice());

        assertEquals(productDto.get(1).getId(),booksDto.get(1).getId());
        assertEquals(productDto.get(1).getName(),booksDto.get(1).getName());
        assertEquals(productDto.get(1).getDescription(),booksDto.get(1).getDescription());
        assertEquals(productDto.get(1).getPrice(),booksDto.get(1).getPrice());


        assertEquals(productDto.get(2).getId(),booksDto.get(2).getId());
        assertEquals(productDto.get(2).getName(),booksDto.get(2).getName());
        assertEquals(productDto.get(2).getDescription(),booksDto.get(2).getDescription());
        assertEquals(productDto.get(2).getPrice(),booksDto.get(2).getPrice());


    }
}