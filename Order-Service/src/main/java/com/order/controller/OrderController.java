package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.OrderRequest;
import com.order.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/placeOrder")
	public ResponseEntity<Integer> placeOrder(@RequestBody OrderRequest orderRequest) {

		int orderResponse = orderService.createOder(orderRequest);

		return new ResponseEntity<Integer>(orderResponse, HttpStatus.CREATED);
	}

}
