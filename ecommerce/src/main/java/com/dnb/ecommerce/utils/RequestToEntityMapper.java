package com.dnb.ecommerce.utils;

import org.springframework.stereotype.Component;

import com.dnb.ecommerce.dto.Product;
import com.dnb.ecommerce.payload.request.ProductRequest;

@Component
public class RequestToEntityMapper {
	public Product getProductEntityObject(ProductRequest productRequest) {
		Product product = new Product();
		product.setProductName(productRequest.getProductName());
		product.setDescription(productRequest.getDescription());
		product.setCategory(productRequest.getCategory());
		product.setPrice(productRequest.getPrice());
		product.setExpirationDate(productRequest.getExpirationDate());
		return product;
	}
}