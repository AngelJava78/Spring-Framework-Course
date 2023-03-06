package com.angeljava.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.angeljava.springboot.di.app.models.domain.InvoiceItem;
import com.angeljava.springboot.di.app.models.domain.Product;
import com.angeljava.springboot.di.app.models.service.IService;
import com.angeljava.springboot.di.app.models.service.MyComplexService;
import com.angeljava.springboot.di.app.models.service.MySimpleService;

@Configuration

public class AppConfig {

	@Bean("MySimpleService")
	@Primary
	public IService registerMySimpleService() {
		return new MySimpleService();
	}
	
	@Bean("MyComplexService") 

	public IService registerMyComplexService() {
		return new MyComplexService();
	}
	
	@Bean("InvoiceItems")
	@Primary
	public List<InvoiceItem> registerInvoiceItems() {
		Product product1 = new Product("Cámara Sony", 100);
		Product product2 = new Product("Bicicleta Bianchi aro 26", 200);
		InvoiceItem line1 = new InvoiceItem(product1, 2);
		InvoiceItem line2 = new InvoiceItem(product2, 4);
		
		return Arrays.asList(line1, line2);
	}
	
	@Bean("OfficeInvoiceItems")

	public List<InvoiceItem> registerOfficeInvoiceItems() {
		Product product1 = new Product("Monitor LG LCD 24", 250);
		Product product2 = new Product("Notebook Asus", 500);
		Product product3 = new Product("Impresora HP Multifuncional", 80);
		Product product4 = new Product("Escritorio Oficina", 300);
		InvoiceItem line1 = new InvoiceItem(product1, 2);
		InvoiceItem line2 = new InvoiceItem(product2, 4);
		InvoiceItem line3 = new InvoiceItem(product3, 1);
		InvoiceItem line4 = new InvoiceItem(product4, 3);
		
		
		return Arrays.asList(line1, line2, line3, line4);
	}
}
