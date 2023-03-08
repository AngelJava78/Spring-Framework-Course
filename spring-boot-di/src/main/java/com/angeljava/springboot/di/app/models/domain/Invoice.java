package com.angeljava.springboot.di.app.models.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
public class Invoice {

	@Value("${invoice.description}")
	private String description;

	@Autowired
	private Client client;

	@Autowired
	private List<InvoiceItem> items;

	@PostConstruct
	public void initialize() {
		client.setName(client.getName().concat(" Java"));
		description = description.concat(" for customer: ").concat(client.getName());
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Invoice destroyed: ".concat(description));
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<InvoiceItem> getItems() {
		return items;
	}

	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}

}
