package com.angeljava.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

	@GetMapping("/") 
	public String index(Model model) {
		model.addAttribute("title", "Enviar parámetros de la ruta (@PathVariable)");
		return "variables/index";
	}
	@GetMapping("/string/{texto}")
	public String getTexto(@PathVariable String texto, Model model) {
		model.addAttribute("title", "Recibir parámetros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto);
		return "variables/ver";
	}
	
	@GetMapping("/string/{nombre}/{edad}") 
	public String getTexto(@PathVariable String nombre, @PathVariable Integer edad, Model model) {
		model.addAttribute("title", "Recibir dos parámetros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "Nombre: '" + nombre + "'. Edad: '" + edad + "'.");
		return "variables/ver";
	}
}
