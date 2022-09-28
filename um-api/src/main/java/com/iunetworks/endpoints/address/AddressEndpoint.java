package com.iunetworks.endpoints.address;

import com.iunetworks.entities.address.Address;
import com.iunetworks.service.address.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressEndpoint {

  private final AddressService addressService;

  public AddressEndpoint(AddressService addressService) {
    this.addressService = addressService;
  }

  //crate new Address
  @PostMapping
  public ResponseEntity<Void> crateAddress(@RequestBody Address address){
    addressService.crateAddress(address);
    return ResponseEntity.ok().build();
  }

  //get Address by id
  @GetMapping("/{id}")
  public Address getById(@PathVariable UUID id){
    return addressService.getById(id);
  }

  //get all Address
  @GetMapping
  public List<Address> getByAll() {
    return addressService.getByAll();
  }


  //update Address
  @PatchMapping("update-address")
  public ResponseEntity<Void> editAddress(@RequestBody Address address){
    addressService.update(address);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping
  public ResponseEntity<Void> delete(@RequestParam UUID id) {
    addressService.delete(id);
    return ResponseEntity.ok().build();
  }
}
