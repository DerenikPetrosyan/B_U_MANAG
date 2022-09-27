package com.iunetworks.service.validators;

import com.iunetworks.entities.address.City;
import com.iunetworks.entities.address.State;
import com.iunetworks.exception.ResourceNotFoundException;
import com.iunetworks.repositories.CityRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CityValidator {

  private final CityRepository cityRepository;

  public CityValidator(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  public void isValidCity(City city) {

  }
  public void existsCity(UUID id) {
    if (!cityRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Resource with id : {%s} not found", id.toString()));
    }
  }
}
