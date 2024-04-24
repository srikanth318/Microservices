package com.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

	private String productName;
	private double price;
	private int quantity;
}
