package com.iunetworks.service.address;

import com.iunetworks.entities.address.Country;

import java.util.List;
import java.util.UUID;

public interface CountryService {

  void crateCountry(String country);

  Country getById(UUID id);

  List<Country> getByAll();

  void update(Country country);

  void delete(UUID id);

}
