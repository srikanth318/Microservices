package com.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Product-Service/api")
public interface ProductService {
	
	
	@PutMapping("/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") int productId, @RequestParam int quantity);


}
