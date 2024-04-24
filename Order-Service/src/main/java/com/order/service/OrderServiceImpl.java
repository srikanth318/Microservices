package com.order.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.client.ProductService;
import com.order.entity.Order;
import com.order.model.OrderRequest;
import com.order.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;
	
	
	@Override
	public int createOder(OrderRequest orderRequest) {
		log.info("before placing the order");
		productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
		log.info("after checking product availabilaty "+orderRequest.getProductId());
		Order order = Order.builder()
				.productId(orderRequest.getProductId())
				.price(orderRequest.getAmount())
				.quantity(orderRequest.getQuantity())
				.orderDate(Instant.now())
				.orderStatus("Created..")
				.build();
		
		order = orderRepository.save(order);
		log.info("product saved successfully..After placing order ");
		return order.getOrderId();
	}

}
