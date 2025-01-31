package com.wipro.wipromart.service;

import java.util.List;

import com.wipro.wipromart.model.ProductDto;

public interface ProductService {

	ProductDto saveProduct(ProductDto productDto);
	
	ProductDto getProductById(long productId);
	
	List<ProductDto> getAllProducts();
	
	
	void deleteProduct(long productId);
}
