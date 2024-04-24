package com.order.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequest {

	private int productId;
	private int quantity;
	private double amount;
	private PaymentMode paymentMode;
}
