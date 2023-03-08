package com.angeljava.springboot.form.app.services;

import java.util.List;

import com.angeljava.springboot.form.app.models.domain.Country;

public interface CountryService {

	List<Country> getCountryList();

	Country getCountryById(Integer id);
}
