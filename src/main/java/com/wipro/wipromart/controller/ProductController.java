package com.wipro.wipromart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.wipromart.model.ProductDto;
import com.wipro.wipromart.service.ProductService;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<ProductDto>addProduct(@Valid @RequestBody ProductDto productDto){
		
	productDto=	productService.saveProduct(productDto);
		
		return new ResponseEntity<>(productDto,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{productId}")
	public ResponseEntity<ProductDto>fetchProductById(@PathVariable long productId){
		
		ProductDto productDto=productService.getProductById(productId);
		
		return new ResponseEntity<>(productDto,HttpStatus.OK);
	}
	
	@GetMapping("/get/all")
	public List<ProductDto>fetchAllProduct(){
		
		List<ProductDto> products=productService.getAllProducts();
		
		return products;
	}
}
