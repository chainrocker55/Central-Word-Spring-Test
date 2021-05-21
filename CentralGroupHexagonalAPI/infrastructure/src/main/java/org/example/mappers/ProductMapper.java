package org.example.mappers;

import org.example.data.ProductDto;
import org.example.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto bookToBookDto(Product product);

    Product bookDtoToBook(ProductDto productDto);

    List<ProductDto> bookListToBookDtoList(List<Product> productList);

    List<Product> BookDtoListToBookList(List<ProductDto> productDtoList);
}