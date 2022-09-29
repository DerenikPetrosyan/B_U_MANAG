package com.iunetworks.service.Impl.address;

import com.iunetworks.entities.address.Country;
import com.iunetworks.exception.ResourceNotFoundException;
import com.iunetworks.repositories.CountryRepository;
import com.iunetworks.service.address.CountryService;
import com.iunetworks.service.validators.CountryValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CountryServiceImpl implements CountryService {

  private final CountryRepository countryRepository;

  private final CountryValidator countryValidator;


  public CountryServiceImpl(CountryRepository countryRepository, CountryValidator countryValidator) {
    this.countryRepository = countryRepository;
    this.countryValidator = countryValidator;
  }


  @Override
  public void crateCountry(String country) {
    countryValidator.isValidCountry(new Country(country));
    countryRepository.save(new Country(country));
  }

  @Override
  public Country getById(UUID id) {
    countryValidator.existsCountry(id);
    return countryRepository.findById(id).get();
  }

  @Override
  public List<Country> getByAll() {
    return countryRepository.findAll();
  }


  @Override
  public void update(Country  country) {
    countryValidator.existsCountry(country.getId());
    countryRepository.save(country);
  }

  @Override
  public void delete(UUID id) {
    countryValidator.existsCountry(id);
    countryRepository.deleteById(id);
  }

}
