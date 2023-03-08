package com.angeljava.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.angeljava.springboot.form.app.models.domain.Country;

@Service
public class CountryServiceImp implements CountryService {

	private List<Country> countryList;

	public CountryServiceImp() {
		countryList = Arrays.asList(new Country(1, "MX", "México"), new Country(2, "ES", "Spain"),
				new Country(3, "US", "United States"), new Country(4, "UK", "United Kingdom"),
				new Country(5, "CA", "Canada"));
	}

	@Override
	public List<Country> getCountryList() {
		return countryList;
	}

	/*
	 * @Override public Country getCountryById(Integer id) { Country result = null;
	 * for(Country country: countryList) { if(id == country.getId()) { result=
	 * country; break; } } return result; }
	 */

	@Override
	public Country getCountryById(Integer id) {
		return countryList.stream().filter(country -> id.equals(country.getId())).findFirst().orElse(null);
	}

}
