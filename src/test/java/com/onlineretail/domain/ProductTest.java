package com.onlineretail.domain;

import com.onlineretail.domain.Category;
import com.onlineretail.domain.Product;

import junit.framework.TestCase;

public class ProductTest extends TestCase {

	public void test_calculateTotalCost() {
		Category categoryA = new Category("A", 10);
		Product product = new Product("Bat", 100.00, 2, categoryA);

		double expected = 200.00;
		double actual = product.calculateTotalCost();
		assertEquals("adding 3 and 4", expected, actual);
	}
}
