package com.online.shop.domain.repository;

import java.util.List;

import com.online.shop.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	Product getProductById(String productid);

	void addProduct(Product product);
	void updateProduct(String productId, Product newProduct);
	void deleteProduct(String productId);
}
