package com.iunetworks.service.address;

import com.iunetworks.entities.address.City;

import java.util.List;
import java.util.UUID;

public interface CityService {

  void crateCity(City city);

  City getById(UUID id);

  List<City> getByAll();

  void update(City city);

  void delete(UUID id);

}
