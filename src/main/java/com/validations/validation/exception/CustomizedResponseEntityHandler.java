package com.validations.validation.exception;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.validations.validation.model.Product;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice

public class CustomizedResponseEntityHandler extends ResponseEntityExceptionHandler{

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<ExceptionResponse> customErrorResponses = new LinkedList<>();
		System.out.println(status);
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			Product fieldValue = (Product) ex.getFieldValue(error.getField().split("[.]")[0]);
			System.out.println(error.getField());

			ExceptionResponse customErrorResponse = new ExceptionResponse();
			customErrorResponse.setProductname(fieldValue.getProductName());
			customErrorResponse.setCode(error.getCode());
			customErrorResponse.setMessage(error.getDefaultMessage());
			customErrorResponse.setError(error.getField() + "  : " + error.getCode() + " : " + error.getDefaultMessage()
					+ ": " + error.getRejectedValue());
			customErrorResponse.setDate(LocalDateTime.now());
			customErrorResponses.add(customErrorResponse);
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			ExceptionResponse customErrorResponse = new ExceptionResponse();
			customErrorResponse.setCode(error.getCode());
			customErrorResponse.setMessage(error.getDefaultMessage());
			customErrorResponse
					.setError(error.getObjectName() + " : " + error.getCode() + " : " + error.getDefaultMessage());
			customErrorResponse.setDate(LocalDateTime.now());
			customErrorResponses.add(customErrorResponse);
		}

		return ResponseEntity.status(status).body(customErrorResponses);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handle(ConstraintViolationException constraintViolationException) {
		Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
		List<ExceptionResponse> customErrorResponses = new LinkedList<>();
		for (ConstraintViolation<?> constraintViolation : violations) {
			ExceptionResponse customErrorResponse = new ExceptionResponse();
			customErrorResponse.setMessage(constraintViolation.getMessage());
			customErrorResponses.add(customErrorResponse);

		}
		return ResponseEntity.badRequest().body(customErrorResponses);
	}
}