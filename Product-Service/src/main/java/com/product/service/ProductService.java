package com.product.service;

import com.product.exception.ProductServiceException;
import com.product.model.ProductRequest;
import com.product.model.ProductResponse;

public interface ProductService {

	public int saveProduct(ProductRequest productRequest);
	public ProductResponse getProductById(int productId) throws ProductServiceException;
	public void reduceQuantity(int productId, int quantity)throws ProductServiceException;
}
