package com.angeljava.springboot.di.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.angeljava.springboot.di.app.models.domain.Invoice;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private Invoice invoice;
	
	@GetMapping("/get")
	public String getInvoice(Model model) {
		model.addAttribute("title", "Show invoice with dependency injection");
		model.addAttribute("invoice", invoice);
		return "invoice/get";
	}
}
