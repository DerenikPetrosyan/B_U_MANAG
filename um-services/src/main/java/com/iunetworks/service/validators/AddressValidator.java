package com.iunetworks.service.validators;

import com.iunetworks.entities.address.Address;
import com.iunetworks.exception.BadRequestException;
import com.iunetworks.exception.ResourceNotFoundException;
import com.iunetworks.repositories.AddressRepository;
import com.iunetworks.service.address.CityService;
import com.iunetworks.service.address.CountryService;
import com.iunetworks.service.address.StateService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddressValidator {
  private final AddressRepository addressRepository;
  private final CityService cityService;
  private final StateService stateService;
  private final CountryService countryService;

  public AddressValidator(AddressRepository addressRepository, CityService cityService, StateService stateService, CountryService countryService) {
    this.addressRepository = addressRepository;
    this.cityService = cityService;
    this.stateService = stateService;
    this.countryService = countryService;
  }

  public void isValidAddress(Address address) {
    if (address.getAddress().charAt(0) < 65 && address.getAddress().charAt(0) > 90 ||  address.getAddress().charAt(0) < 97 && address.getAddress().charAt(0) > 122 ){
      throw new BadRequestException("The address fild must begin with an uppercase or lowercase English letter");
    }else if (cityService.getById(address.getCity().getId()) == null) {
      throw new ResourceNotFoundException("The city the city is invalid, enter correctly");
    }else if (stateService.getById(address.getState().getId()) == null) {
      throw new ResourceNotFoundException("The state in the city is invalid, enter correctly");
    } else if (countryService.getById(address.getCountry().getId()) == null) {
      throw new ResourceNotFoundException("The country in the city is invalid, enter correctly");
    } else if (!address.getCountry().equals(address.getState().getCountry())){
      throw new BadRequestException("the state is not located in the specified country");
    }else if (!address.getState().equals(address.getCity().getState())){
      throw new BadRequestException("the city is not located in the specified state");
    }

  }

  public void existsAddress(UUID id) {
    if (!addressRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Resource with id : {%s} not found", id.toString()));
    }
  }

}
