package com.iunetworks.service.Impl.address;

import com.iunetworks.entities.address.City;
import com.iunetworks.repositories.CityRepository;
import com.iunetworks.service.address.CityService;

import com.iunetworks.service.validators.CityValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CityServiceImpl implements CityService {

  private final CityRepository cityRepository;
  private final CityValidator cityValidator;

  public CityServiceImpl(CityRepository cityRepository, CityValidator cityValidator) {
    this.cityRepository = cityRepository;
    this.cityValidator = cityValidator;
  }

  @Override
  public void crateCity(City city) {
    cityValidator.isValidCity(city);
    cityRepository.save(city);
  }

  @Override
  public City getById(UUID id) {
    cityValidator.existsCity(id);
    return cityRepository.findById(id).get();
  }

  @Override
  public List<City> getByAll() {
    return cityRepository.findAll();
  }

  @Override
  public void update(City city) {
    cityValidator.existsCity(city.getId());
    cityRepository.save(city);

  }

  @Override
  public void delete(UUID id) {
    cityValidator.existsCity(id);
    cityRepository.deleteById(id);
  }
}
