package org.example.mappers;

import org.example.data.ProductDto;
import org.example.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToProductDto(Product product);

    Product productDtoToProduct(ProductDto productDto);

    List<ProductDto> productListToProductDtoList(List<Product> productList);

    List<Product> productDtoListToProductList(List<ProductDto> productDtoList);
}