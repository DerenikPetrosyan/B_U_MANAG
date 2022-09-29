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
  private final StateValidator stateValidator;

  public StateServiceImpl(StateRepository stateRepository, StateValidator stateValidator) {
    this.stateRepository = stateRepository;
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
    return stateRepository.findById(id).get();
  }

  @Override
  public List<State> getByAll(){

    return stateRepository.findAll();
  }

  @Override
  public void update(State state) {
    stateValidator.existsState(state.getId());
    stateRepository.save(state);
  }

  @Override
  public void delete(UUID id) {

    stateValidator.existsState(id);
    stateRepository.deleteById(id);
  }

}
