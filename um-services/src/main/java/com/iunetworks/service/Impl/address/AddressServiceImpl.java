package com.iunetworks.service.Impl.address;

import com.iunetworks.entities.address.Address;
import com.iunetworks.repositories.AddressRepository;
import com.iunetworks.service.address.AddressService;

import com.iunetworks.service.validators.AddressValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class AddressServiceImpl implements AddressService {


  private final AddressRepository addressRepository;
  private final AddressValidator addressValidator;


  public AddressServiceImpl(AddressRepository addressRepository, AddressValidator addressValidator) {
    this.addressRepository = addressRepository;
    this.addressValidator = addressValidator;
  }

  @Override
  public void crateAddress(Address address) {
    addressValidator.isValidAddress(address);
    addressRepository.save(address);

  }

  @Override
  public Address getById(UUID id) {
    return addressRepository.findById(id).get();
  }

  @Override
  public List<Address> getByAll() {
    return addressRepository.findAll();
  }

  @Override
  public void update(Address address) {
  addressValidator.existsAddress(address.getId());


  addressRepository.save(address);
  }

  @Override
  public void delete(UUID id) {
    addressValidator.existsAddress(id);
    addressRepository.deleteById(id);

  }
}
