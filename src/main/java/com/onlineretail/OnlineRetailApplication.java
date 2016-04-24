package com.onlineretail;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.onlineretail.database.DatabaseIntialization;
import com.onlineretail.domain.Product;
import com.onlineretail.domain.ProductList;
import com.onlineretail.repository.CategoryRepository;
import com.onlineretail.repository.ProductRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class OnlineRetailApplication {

	private static final Logger log = LoggerFactory.getLogger(OnlineRetailApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OnlineRetailApplication.class, args);
	}

	@Bean
	public CommandLineRunner intialSetup(ProductRepository productRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("***********************************************");
			log.info("\t\t Online Retail Store");
			log.info("***********************************************");

			new DatabaseIntialization(productRepository, categoryRepository);
			userInput(productRepository);

		};
	}

	private void userInput(ProductRepository productRepository) {
		Scanner scanner = new Scanner(System.in);
		ProductList productList = new ProductList(productRepository);
		int input = 0;
		while (input != MenuOption.EXIT.getValue()) {
			log.info("");
			log.info("--------------------------");
			log.info("\t\tMenu");
			log.info("--------------------------");

			log.info("(1) Add product to the list. ");
			log.info("(2) Display all product list");
			log.info("(3) Total Bill ");
			log.info("(4) Exit. ");
			input = scanner.nextInt();
		
			if (input == MenuOption.ADD_PRODUCT.getValue()) {
				log.info("Enter Product ID");
				long productId = scanner.nextLong();
				Product product = productRepository.findOne(productId);
				log.info("Added Product Info -> " + product.toString());
				log.info("Enter Quantity");
				int productQuantity = scanner.nextInt();
				product.setQuantity(productQuantity);
				productList.addProduct(product);
			} else if (input == MenuOption.DISPLAY_PRODUCTS.getValue()) {
				productList.displayProducts();
			} else if (input == MenuOption.TOTAL_BILL.getValue()) {
				log.info("Total Cost -> " + productList.getCost());
			}
		}
		scanner.close();

	}

}