package com.example.mvc.exception.model;

public class OrderError {
	
	private int errorCode;
	private String errorMessage;
	
	
	public OrderError() {
		super();
		
	}


	public OrderError(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	};
	

}
