package com.example.mvc.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.mvc.exception.OrderException;
import com.example.mvc.exception.model.OrderError;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<OrderError> mapException(OrderException orderException){
		OrderError orderError = new OrderError(HttpStatus.INTERNAL_SERVER_ERROR.value(),orderException.getMessage());
		return new ResponseEntity<OrderError>(orderError,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
