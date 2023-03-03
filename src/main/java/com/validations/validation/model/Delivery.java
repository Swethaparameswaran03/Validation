package com.validations.validation.model;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    
	@Range(min = 10, max=20, message = "Delivery of food area values should be within 10 to 20")
	private int deliveryArea;
	@Range(min=1000,max=2000,message="cost shud be between 1000 to 2000")
	private double cost;
}
