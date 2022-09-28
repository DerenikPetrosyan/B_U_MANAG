package com.iunetworks.service.validators;

import com.iunetworks.entities.address.City;
import com.iunetworks.exception.BadRequestException;
import com.iunetworks.exception.DuplicateException;
import com.iunetworks.exception.ResourceNotFoundException;
import com.iunetworks.repositories.CityRepository;
import com.iunetworks.service.address.CountryService;
import com.iunetworks.service.address.StateService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CityValidator {

  private final CityRepository cityRepository;
  private final StateService stateService;
  private final CountryService countryService;

  public CityValidator(CityRepository cityRepository, StateService stateService, CountryService countryService) {
    this.cityRepository = cityRepository;
    this.stateService = stateService;
    this.countryService = countryService;
  }

  public void isValidCity(City city) {
    if (cityRepository.existsByCity(city.getCity())) {
      throw new DuplicateException("This city is already registered , try a new city");
    } else if (stateService.getById(city.getState().getId()) == null) {
      throw new ResourceNotFoundException("The state in the city is invalid, enter correctly");
    } else if (countryService.getById(city.getCountry().getId()) == null) {
      throw new ResourceNotFoundException("The country in the city is invalid, enter correctly");
    } else if (city.getCity().charAt(0) > 64 && city.getCity().charAt(0) < 91) {
      throw new BadRequestException("The city name must begin with an English capital letter");
    }
  }
  public void existsCity(UUID id) {
    if (!cityRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Resource with id : {%s} not found", id.toString()));
    }
  }
}
