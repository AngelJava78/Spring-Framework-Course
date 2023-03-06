package com.angeljava.springboot.di.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.angeljava.springboot.di.app.models.service.IService;


@Controller
public class IndexController {
	
	@Autowired
	@Qualifier("MySimpleService")
	private IService myService;
	
	@GetMapping({"/index", "", "/"})
	public String index(Model model) {
		model.addAttribute("objeto", myService.operation());
		return "index";
	}
}
