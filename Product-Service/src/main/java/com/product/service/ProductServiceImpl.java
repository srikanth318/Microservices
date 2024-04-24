package com.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.exception.ProductServiceException;
import com.product.model.ProductRequest;
import com.product.model.ProductResponse;
import com.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	public int saveProduct(ProductRequest productRequest) {
		log.info("<<enter into saveProduct method>>");
		Product product = Product.builder()
				.productName(productRequest.getProductName())
				.price(productRequest.getPrice())
				.quantity(productRequest.getQuantity())
				.build();
		
		productRepository.save(product);
		
		log.info("<<product saved successfully..... saveProduct method>>");
		
		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(int productId) throws ProductServiceException {
		Product product = productRepository.findById(productId)
				.orElseThrow(()->new ProductServiceException("Product not found with given id "
						+productId,HttpStatus.NOT_FOUND.value()));
		
		ProductResponse response = ProductResponse.builder()
				.productName(product.getProductName())
				.price(product.getPrice())
				.quantity(product.getQuantity())
				.build();
		
		return response;
	}

	@Override
	public void reduceQuantity(int productId, int quantity) throws ProductServiceException{
		log.info("<<enter into reduceQuantity method>>");
		Product product = productRepository.findById(productId)
				.orElseThrow(()->new ProductServiceException("Product not found with given id "+productId,HttpStatus.NOT_FOUND.value()));
		
		if(product instanceof Product) {
			if(product.getQuantity()<quantity) {
				throw new ProductServiceException("not having enough quantity of products ",HttpStatus.NOT_FOUND.value());
			}
			
			product.setQuantity(product.getQuantity() - quantity);
			productRepository.save(product);
			log.info("<<product updated..>>");
		}
		
	}

}
