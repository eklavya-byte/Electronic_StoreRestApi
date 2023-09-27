package com.lcwd.electronic.store.services;

import com.lcwd.electronic.store.dtos.PagebleResponse;
import com.lcwd.electronic.store.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    //create
    ProductDto create (ProductDto productDto);

    //update
    ProductDto update( ProductDto productDto, String productId);
    // delete

    void  delete(String productId);

    //get single
    ProductDto get(String productId);

    // get all
    PagebleResponse<ProductDto> getAll(int pageNumber , int pageSize ,String sortBy,String sortDir );

    //get all : live
    PagebleResponse<ProductDto> getAllLive(int pageNumber , int pageSize ,String sortBy,String sortDir );

    //search product
    PagebleResponse<ProductDto> searchByTitle(String subtitle,int pageNumber , int pageSize ,String sortBy,String sortDir);

    // other methods

    //create product with category
    ProductDto createWithCategory(ProductDto productDto , String categoryId);

    // update category of product
    ProductDto updateCategory(String productId , String categoryId);

    PagebleResponse<ProductDto> getAllOfCategory(String categoryId,int pageNumber,int pageSize,String sortBy,String sortDir);

}
