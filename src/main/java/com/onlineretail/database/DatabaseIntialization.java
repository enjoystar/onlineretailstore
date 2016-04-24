package com.onlineretail.database;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.onlineretail.domain.Category;
import com.onlineretail.domain.Product;
import com.onlineretail.repository.CategoryRepository;
import com.onlineretail.repository.ProductRepository;

public class DatabaseIntialization {

	private static final Logger log = LoggerFactory.getLogger(DatabaseIntialization.class);

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public DatabaseIntialization(final ProductRepository productRepository,
			final CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		intializeProductDatabase();

	}

	public void intializeProductDatabase() {

		// Category A products
		Category categoryA = new Category("A", 10);
		Product bat = new Product("Bat", 100.00, 1, categoryA);
		Product tennisBall = new Product("Tennis Ball", 20.00, 1, categoryA);

		Set<Product> products = new HashSet<Product>();
		products.add(bat);
		products.add(tennisBall);
		categoryA.setProducts(products);
		categoryRepository.save(categoryA);

		// Category B products
		Category categoryB = new Category("B", 20);
		Product appleLaptop = new Product("Apple Laptop", 90000.00, 1, categoryB);
		Product samsungMobile = new Product("Samsung Mobile", 55000.00, 1, categoryB);

		products = new HashSet<Product>();
		products.add(appleLaptop);
		products.add(samsungMobile);
		categoryB.setProducts(products);
		categoryRepository.save(categoryB);

		// Category C products
		Category categoryC = new Category("C", 0);
		Product chair = new Product("Apple Laptop", 400.00, 1, categoryC);
		Product bed = new Product("Samsung Mobile", 11000.00, 1, categoryC);

		products = new HashSet<Product>();
		products.add(chair);
		products.add(bed);
		categoryC.setProducts(products);
		categoryRepository.save(categoryC);

		log.info("Product List:");
		log.info("-------------");

		for (Product product : productRepository.findAll()) {
			log.info(product.toString());
		}
		log.info("");
	}

}
