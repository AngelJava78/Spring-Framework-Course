package com.angeljava.springboot.web.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.angeljava.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${texto.indexcontroller.index.title}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.title}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.title}")
	private String textoListar;

	@GetMapping({ "/index", "/", "", "/home" })
	public String index(Model model) {
		model.addAttribute("title", textoIndex);
		model.addAttribute("authorname", "Angel");
		return "index";
	}

	@GetMapping({ "/home2" })
	public String home2(Model model) {
		model.addAttribute("title", "Home 2");
		model.addAttribute("authorname", "Zulidany");
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Angel");
		usuario.setApellido("Javier");
		// usuario.setEmail("angel_java@hotmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("title", textoPerfil);
		return "perfil";

	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("title", textoListar);
//		List<Usuario> usuarios = new ArrayList<>();
//		usuarios.add(new Usuario("Zulidany", "Hernández", "hzulidany@gmail.com"));
//		usuarios.add(new Usuario("Angel", "Javier", "angel_java@hotmail.com"));
//		usuarios.add(new Usuario("Rubi", "Javier", "rubi_jahe.hotmail.com"));		
//		model.addAttribute("usuarios", usuarios);
		// model.addAttribute(poblarUsuarios());
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Zulidany", "Hernández", "hzulidany@gmail.com"),
				new Usuario("Angel", "Javier", "angel_java@hotmail.com"),
				new Usuario("Rubi", "Javier", "rubi_jahe.hotmail.com"),
				new Usuario("Perla", "Javier", "perla_jahe@hotmail.com"));
		return usuarios;
	}
}
