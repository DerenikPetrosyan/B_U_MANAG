package com.iunetworks.service.validators;

import com.iunetworks.entities.address.State;
import com.iunetworks.exception.ResourceNotFoundException;
import com.iunetworks.repositories.StateRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StateValidator {

  private final StateRepository stateRepository;

  public StateValidator(StateRepository stateRepository) {
    this.stateRepository = stateRepository;
  }

  public void isValidState(State state) {

  }
  public void existsState(UUID id) {
    if (!stateRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Resource with id : {%s} not found", id.toString()));
    }
  }


}
