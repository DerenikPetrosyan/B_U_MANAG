package com.iunetworks.service.Impl.address;

import com.iunetworks.entities.address.State;
import com.iunetworks.repositories.StateRepository;
import com.iunetworks.service.address.CountryService;
import com.iunetworks.service.address.StateService;
import com.iunetworks.service.validators.StateValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class StateServiceImpl implements StateService {

  private final StateRepository stateRepository;
  private final CountryService countryService;
  private final StateValidator stateValidator;

  public StateServiceImpl(StateRepository stateRepository, CountryService countryService, StateValidator stateValidator) {
    this.stateRepository = stateRepository;
    this.countryService = countryService;
    this.stateValidator = stateValidator;
  }


  @Override
  public void crateState(State state) {
    stateValidator.isValidState(state);
    stateRepository.save(state);
  }

  @Override
  public State getById(UUID id) {
    stateValidator.existsState(id);
    return stateRepository.getById(id);
  }

  @Override
  public List<State> getByAll(){

    return stateRepository.findAll();
  }

  @Override
  public void update(UUID id, String stateName) {
    stateValidator.existsState(id);
    stateRepository.updateName(id,stateName);
  }

  @Override
  public void delete(UUID id) {

    stateValidator.existsState(id);
    stateRepository.delete(id);
  }

}
