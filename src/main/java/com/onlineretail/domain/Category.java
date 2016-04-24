package com.onlineretail.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	
	private String name;
	
	private double tax;

	private Set<Product> products;

	protected Category() {
	}

	public Category(String name, double tax) {
		this.name = name;
		this.tax = tax;
	}

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return String.format("Product[id=%d,name='%s', tax='%f']", id, name, name, tax);
	}

	@Id
	@Column(name = "CATEGORY_ID")
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

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double calculateTax(double totalCost) {
		return totalCost + (totalCost * tax / 100);

	}
}