package com.iunetworks.service.validators;

import com.iunetworks.entities.address.State;
import com.iunetworks.exception.BadRequestException;
import com.iunetworks.exception.DuplicateException;
import com.iunetworks.exception.ResourceNotFoundException;
import com.iunetworks.repositories.StateRepository;
import com.iunetworks.service.address.CountryService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StateValidator {

  private final StateRepository stateRepository;

  private final CountryService countryService;

  public StateValidator(StateRepository stateRepository, CountryService countryService) {
    this.stateRepository = stateRepository;
    this.countryService = countryService;
  }

  public void isValidState(State state) {
    if (stateRepository.existsByState(state.getState())) {
      throw new DuplicateException("This state is already registered , try a new state");
    } else if (countryService.getById(state.getCountry().getId()) == null) {
      throw new ResourceNotFoundException("The country in the state is invalid, enter correctly");
    } else if (state.getState().charAt(0) > 64 && state.getState().charAt(0) < 91) {
      throw new BadRequestException("The state name must begin with an English capital letter");
    }

  }

  public void existsState(UUID id) {
    if (!stateRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Resource with id : {%s} not found", id.toString()));
    }
  }


}
