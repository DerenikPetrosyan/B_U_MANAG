package com.iunetworks.service.validators;

import com.iunetworks.entities.address.Address;
import com.iunetworks.exception.ResourceNotFoundException;
import com.iunetworks.repositories.AddressRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddressValidator {
  private final AddressRepository addressRepository;

  public AddressValidator(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  public void isValidAddress(Address address) {
  }

  public void existsAddress(UUID id) {
    if (!addressRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Resource with id : {%s} not found", id.toString()));
    }
  }

}
