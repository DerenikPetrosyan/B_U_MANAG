package com.iunetworks.service.address;


import com.iunetworks.entities.address.State;

import java.util.List;
import java.util.UUID;

public interface StateService {

    void crateState(State state);

    State getById(UUID id);

    List<State> getByAll();

//    List<State> getByCountryId(UUID countryId);

  void update(UUID id, String stateName);

  void delete(UUID id);
//
//  List<State>> getByCountryId(UUID countryid);
}
