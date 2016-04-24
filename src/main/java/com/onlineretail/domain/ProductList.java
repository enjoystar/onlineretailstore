package com.onlineretail.domain;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.onlineretail.repository.ProductRepository;

public class ProductList {
	private static final Logger log = LoggerFactory.getLogger(ProductList.class);

	private final ProductRepository productRepository;
	private List<Product> productList = new ArrayList<Product>();

	public ProductList(final ProductRepository repository) {
		this.productRepository = repository;
	}

	public void addProduct(Product product) {
		productList.add(product);
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public void displayProducts() {
		log.info(" Total products -> " + productList.size());
		for (Product product : productList) {
			log.info(product.toString() + " Quantity: " + product.getQuantity());
		}
	}

	public double getCost() {
		double totalCost = 0.0;

		for (Product product : productList) {
			totalCost = totalCost + product.calculateTotalCost();
			totalCost = product.getCategory().calculateTax(totalCost);
		}
		return totalCost;

	}

}