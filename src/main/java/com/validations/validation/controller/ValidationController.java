package com.validations.validation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.validations.validation.model.BulkProduct;

import jakarta.validation.Valid;

@RestController
@Validated
public class ValidationController {
	
	@PostMapping("/products")
	public ResponseEntity<?> saveProducts(@Valid @RequestBody BulkProduct pro)
	{
		return new ResponseEntity<>(pro,HttpStatus.OK);		
	}

}
