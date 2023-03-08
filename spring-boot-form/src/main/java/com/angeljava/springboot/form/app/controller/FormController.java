package com.angeljava.springboot.form.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.angeljava.springboot.form.app.editors.CountryPropertyEditor;
import com.angeljava.springboot.form.app.editors.RolePropertyEditor;
import com.angeljava.springboot.form.app.editors.UppercaseEditor;
import com.angeljava.springboot.form.app.models.domain.Country;
import com.angeljava.springboot.form.app.models.domain.Role;
import com.angeljava.springboot.form.app.models.domain.User;
import com.angeljava.springboot.form.app.services.CountryService;
import com.angeljava.springboot.form.app.services.RoleService;
import com.angeljava.springboot.form.app.utils.SecretKeyGenerator;
import com.angeljava.springboot.form.app.validation.UserValidator;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/form")
@SessionAttributes("user")
public class FormController {

	@Autowired
	private UserValidator validator;

	@Autowired
	private CountryService countryService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private CountryPropertyEditor countryPropertyEditor;

	@Autowired
	private RolePropertyEditor rolePropertyEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// binder.setValidators(validator);
		binder.addValidators(validator);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "birthdate", new CustomDateEditor(dateFormat, false));

		binder.registerCustomEditor(String.class, "firstName", new UppercaseEditor());
		binder.registerCustomEditor(String.class, "lastName", new UppercaseEditor());
		binder.registerCustomEditor(Country.class, "country", countryPropertyEditor);
		binder.registerCustomEditor(Role.class, "roles", rolePropertyEditor);
	}

	@GetMapping({ "", "/", "/form" })
	public String get(Model model) throws ParseException {
		model.addAttribute("title", "Introduce data for user");
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setFirstName("Angel");
		user.setLastName("Javier");
		user.setEmail("angel@correo.com");
		user.setAge(44);
		String dateString = "05-11-1978";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = dateFormat.parse(dateString);
		user.setBirthdate(date);
		user.setEnabled(true);
		user.setCountry(new Country(1, "MX", "México"));
		user.setRoles(Arrays.asList(new Role(2, "User", "ROLE_USER"), new Role(3, "Moderator", "ROLE_MODERATOR")));
		user.setSecretKey(SecretKeyGenerator.generateSecretKey());
		// user.setGender(dateString)
		model.addAttribute("user", user);
		return "form/form";
	}

	@ModelAttribute("countryList")
	private List<String> getCountryList() {
		return Arrays.asList("México", "Spain", "US", "UK", "Canada");
	}

	@ModelAttribute("countryMap")
	private Map<String, String> getCountryMap() {
		Map<String, String> countryMap = new HashMap<String, String>();
		countryMap.put("MX", "México");
		countryMap.put("ES", "Spain");
		countryMap.put("US", "United Status");
		countryMap.put("UK", "United Kingdom");
		countryMap.put("CA", "CANADA");
		return countryMap;
	}

	@ModelAttribute("genderList")
	private List<String> getGenderList() {
		return Arrays.asList("Female", "Male");
	}

	/*
	 * @ModelAttribute("countries") private List<Country> getCountries() { return
	 * Arrays.asList(new Country(1, "MX", "México"), new Country(2, "ES", "Spain"),
	 * new Country(3, "US", "United States"), new Country(4, "UK",
	 * "United Kingdom"), new Country(5, "CA", "Canada")); }
	 */

	@ModelAttribute("countries")
	private List<Country> getCountries() {
		return countryService.getCountryList();
	}

	@ModelAttribute("roleList")
	private List<String> getRoleList() {
		List<String> roles = Arrays.asList("ROLE_ADMIN", "ROLE_USER", "ROLE_MODERATOR");
		return roles;
	}

	@ModelAttribute("roleMap")
	private Map<String, String> getRoleMap() {
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN", "Administrator");
		roles.put("ROLE_USER", "User");
		roles.put("ROLE_MODERATOR", "Moderator");
		return roles;
	}

	@ModelAttribute("roles")
	private List<Role> getRoles() {
		return roleService.getRoleList();
	}

	@PostMapping("/form")
	public String post(@Valid User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("title", "Result for user");
			return "/form/form";
		}

		return "redirect:/form/show";
	}

	@GetMapping("/show")
	public String show(@SessionAttribute(name = "user", required = false) User user, Model model,
			SessionStatus status) {
		if(user == null) {
			return "redirect:/form/form";
		}
		model.addAttribute("title", "Result for user");

		status.setComplete();
		return "/form/result";
	}
}
