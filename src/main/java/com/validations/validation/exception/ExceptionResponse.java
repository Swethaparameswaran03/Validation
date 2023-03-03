package com.validations.validation.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.validations.validation.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
	
	private String Productname;
	private String code;
	private String error;
	private String message;
	private LocalDateTime date;
		

	

}
