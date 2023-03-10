package com.angeljava.springboot.di.app.models.domain;

public class InvoiceItem {

	private Product product;

	private Integer quantity;

	public InvoiceItem(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public float getTotalAmmount() {
		return quantity * product.getPrice();
	}

}
