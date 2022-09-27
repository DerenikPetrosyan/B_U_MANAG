package com.iunetworks.service.validators;

import com.iunetworks.entities.address.Country;
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

  }

  public void existsCountry(UUID id) {
    if (!countryRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Resource with id : {%s} not found", id.toString()));
    }
  }
}
