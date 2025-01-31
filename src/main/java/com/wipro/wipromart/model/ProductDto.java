package com.wipro.wipromart.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter


public class ProductDto {

	private long productId;
	
	@NotNull(message="Product Name should not be null")
	private String productName;
	
	@Positive(message="Product price should not be Negative")
	private double productPrice;
	
	@PastOrPresent
	private LocalDate mfd;
	
	private String category;
}
