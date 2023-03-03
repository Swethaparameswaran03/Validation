package com.validations.validation.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@NotEmpty(message="Product name should not be empty")
	private String productName;
	@NotNull(message="Product type should not be null")
	private String productType;
	@Valid
	private int quantity;
	@Valid
	private User user;
	@Valid
	private Delivery delivery;
	
}
