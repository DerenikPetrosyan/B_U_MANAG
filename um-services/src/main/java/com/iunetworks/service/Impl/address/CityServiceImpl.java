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
    return cityRepository.getById(id);
  }

  @Override
  public List<City> getByAll() {
    return cityRepository.findAll();
  }

  @Override
  public void update(UUID id, String cityName) {
    cityValidator.existsCity(id);
    cityRepository.updateName(id,cityName);

  }

  @Override
  public void delete(UUID id) {
    cityValidator.existsCity(id);
    cityRepository.delete(id);
  }
}
