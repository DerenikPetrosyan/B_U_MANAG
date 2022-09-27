package com.iunetworks.service.address;

import com.iunetworks.entities.address.Address;

import java.util.List;
import java.util.UUID;

public interface AddressService {

  void crateAddress(Address address);

  Address getById(UUID id);

  List<Address> getByAll();

  void update(Address address);

  void delete(UUID id);
}
