package com.iunetworks.service.validators;

import com.iunetworks.entities.address.Country;
import com.iunetworks.exception.BadRequestException;
import com.iunetworks.exception.DuplicateException;
import com.iunetworks.exception.ResourceNotFoundException;
import com.iunetworks.repositories.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CountryValidator {

  private final CountryRepository countryRepository;

  public CountryValidator(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  public void isValidCountry(Country country) {
    if (countryRepository.existsByCountry(country.getCountry())) {
      throw new DuplicateException("This country is already registered , try a new country");
    } else if (country.getCountry().charAt(0) > 64 && country.getCountry().charAt(0) < 91) {
      throw new BadRequestException("The country name must begin with an English capital letter");
    }
  }

  public void existsCountry(UUID id) {
    if (!countryRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Resource with id : {%s} not found", id.toString()));
    }
  }
}
