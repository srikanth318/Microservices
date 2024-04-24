package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.exception.ProductServiceException;
import com.product.model.ProductRequest;
import com.product.model.ProductResponse;
import com.product.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/addProduct")
	public ResponseEntity<Integer> addProduct(@RequestBody ProductRequest productRequest) {

		int saveProduct = productService.saveProduct(productRequest);

		return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
	}

	@GetMapping("/getProduct/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") int id) throws ProductServiceException {

		ProductResponse response = productService.getProductById(id);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") int productId, @RequestParam int quantity) throws ProductServiceException {

		productService.reduceQuantity(productId,quantity);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
