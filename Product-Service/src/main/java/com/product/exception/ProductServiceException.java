package com.product.exception;

import lombok.Data;

@Data
public class ProductServiceException extends Exception{

	private int errorcode;
	public ProductServiceException(String message,int errorcode) {
		super(message);
		this.errorcode=errorcode;
	}
}
