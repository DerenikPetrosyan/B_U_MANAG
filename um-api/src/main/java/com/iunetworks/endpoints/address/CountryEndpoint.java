package com.iunetworks.endpoints.address;

import com.iunetworks.entities.address.Country;
import com.iunetworks.service.address.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/country")
public class CountryEndpoint {


  @Autowired
  private CountryService countryService;

  //crate Country
  @PostMapping
  public ResponseEntity<Void> crateCountry(@RequestParam String country) {
    countryService.crateCountry(country);
    return ResponseEntity.ok().build();
  }

  //get Country by id
  @GetMapping("/{id}")
  public Country getById(@PathVariable UUID id){
    return countryService.getById(id);
  }

  //get all Countries
  @GetMapping
  public List<Country> getByAll(){
    return countryService.getByAll();
  }


  //edit Country
  @PatchMapping("update-country")
  public ResponseEntity<Void> update(@RequestBody Country country) {
    countryService.update(country);
    return ResponseEntity.ok().build();
  }

  //delete country

  @DeleteMapping
  public ResponseEntity<Void> delete(@RequestParam UUID id) {
    countryService.delete(id);
    return ResponseEntity.ok().build();
  }


}
