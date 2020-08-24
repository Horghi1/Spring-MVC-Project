package com.online.shop.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.online.shop.utils.InMemoryData;
import org.springframework.stereotype.Repository;

import com.online.shop.domain.Product;
import com.online.shop.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	private List<Product> listOfProducts;

	public InMemoryProductRepository() {
		listOfProducts =new ArrayList<>(InMemoryData.listOfProducts);
	}

	@Override
	public List<Product> getAllProducts() {
		return listOfProducts;
	}

	@Override
	public Product getProductById(String productid) {
		Product productById = null;
		for (Product product : listOfProducts) {
			if (product != null && product.getProductId() != null && product.getProductId().equals(productid)) {
				productById = product;
				break;
			}
		}
		
		return productById;
	}

	@Override
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}

	@Override
	public void updateProduct(String productId, Product newProduct) {
		for(int i = 0; i < listOfProducts.size(); i++) {
			if(listOfProducts.get(i).getProductId().equals(productId)) {
				listOfProducts.get(i).setUnitsInStock(newProduct.getUnitsInStock());
				listOfProducts.get(i).setCategory(newProduct.getCategory());
				listOfProducts.get(i).setDescription(newProduct.getDescription());
				listOfProducts.get(i).setManufacturer(newProduct.getManufacturer());
				listOfProducts.get(i).setUnitPrice(newProduct.getUnitPrice());
				listOfProducts.get(i).setCondition(newProduct.getCondition());
				listOfProducts.get(i).setName(newProduct.getName());
				
			}
		}
	}

	@Override
	public void deleteProduct(String productId) {
		for (Product product : listOfProducts) {
			if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
				listOfProducts.remove(product);
				break;
			}
		}
	}
}
