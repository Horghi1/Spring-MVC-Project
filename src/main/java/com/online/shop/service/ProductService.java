package com.online.shop.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.online.shop.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product getProductById(String productId);

	void addProduct(Product product);
	void updateProduct(String productId, Product newProduct);
	void deleteProduct(String productId);

	String getFileExtension(String fileName);
}
