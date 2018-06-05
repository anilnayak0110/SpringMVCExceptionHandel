package com.example.mvc.exception.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.exception.OrderException;
import com.example.mvc.exception.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping("/getPrice/{productName}")
	public String getOrderByName(@PathVariable("productName") String productName) throws OrderException {
		double amount = service.getOrderPriceByName(productName);
		return "Price is "+amount;
	}
	

}
