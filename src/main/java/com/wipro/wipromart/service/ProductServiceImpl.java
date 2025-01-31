package com.wipro.wipromart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.wipromart.entity.Product;
import com.wipro.wipromart.exception.ResourceNotFoundException;
import com.wipro.wipromart.model.ProductDto;
import com.wipro.wipromart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDto saveProduct(ProductDto productDto) {
	
	//	productRepository.save(productDto);
		
		Product product = modelMapper.map(productDto, Product.class);
		
		Product newProduct = productRepository.save(product);
		productDto= modelMapper.map(newProduct, ProductDto.class);
		return productDto;
	}
	@Override
	public ProductDto getProductById(long productId) {
		
		Optional<Product>optionalProduct=productRepository.findById(productId);
		
		if(optionalProduct.isEmpty()){
			
			throw new ResourceNotFoundException("Product not found with id:"+productId);
		}
		Product product=optionalProduct.get();
		
		ProductDto productDto=modelMapper.map(product, ProductDto.class);
		return productDto;
	}

	@Override
	public List<ProductDto> getAllProducts() {
		
		List<Product> products =  productRepository.findAll();
		
		List<ProductDto>productsDtos = new ArrayList<>();
		
		products.forEach(c-> {
			ProductDto productsDto = modelMapper.map(c, ProductDto.class);
			
			productsDtos.add(productsDto);
			
		});
		

		return productsDtos;
	}
	@Override
	public void deleteProduct(long productId) {
		
		Optional<Product> optionalProduct = productRepository.findById(productId);
		
		if(optionalProduct.isEmpty()) {		
			throw new ResourceNotFoundException("Product not found with id: "+productId);
		}
				
		Product product = optionalProduct.get();	
		
		productRepository.delete(product);		
	}
	

}
