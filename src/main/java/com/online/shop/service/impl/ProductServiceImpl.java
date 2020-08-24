package com.online.shop.service.impl;

import java.util.List;

import com.online.shop.domain.Product;
import com.online.shop.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public Product getProductById(String productId) {
		return productRepository.getProductById(productId);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
		
	}

	@Override
	public void updateProduct(String productId, Product newProduct) {
		productRepository.updateProduct(productId, newProduct);
	}

	@Override
	public void deleteProduct(String productId) {
		productRepository.deleteProduct(productId);
	}

	@Override
	public String getFileExtension(String fileName){
		
		if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
	        return fileName.substring(fileName.lastIndexOf(".")+1);
		else
			return "";
	}
}
