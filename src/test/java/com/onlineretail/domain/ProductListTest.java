package com.onlineretail.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.onlineretail.repository.ProductRepository;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class ProductListTest extends TestCase {

	@Mock
	private ProductRepository productRepository;
	ProductList productList;;

	@Before
	public void setUp() {
		productList = new ProductList(productRepository);
	}

	@Test
	public void test_getCost() {

		// Category A products
		Category categoryA = new Category("A", 10);
		Product bat = new Product("Bat", 100.00, 2, categoryA);
		productList.addProduct(bat);

		double expected = 220.00;
		double actual = productList.getCost();
		assertEquals("adding 3 and 4", expected, actual);
	}
}
