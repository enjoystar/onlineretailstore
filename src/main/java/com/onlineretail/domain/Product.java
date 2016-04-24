package com.onlineretail.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity

@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double price;
	private int quantity;
	private Category category;

	public Product() {
	}

	public Product(String name, double price, int quantity, Category category) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CATEGORY_ID")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return String.format("Product [id=%d, name='%s', price='%.2f', category='%s' ]", id, name, price,
				category.getName());
	}

	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double calculateTotalCost() {
		return price * quantity;
	}

}