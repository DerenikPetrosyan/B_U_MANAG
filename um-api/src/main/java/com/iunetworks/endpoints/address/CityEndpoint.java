package com.iunetworks.endpoints.address;

import com.iunetworks.entities.address.City;
import com.iunetworks.entities.address.State;
import com.iunetworks.service.address.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/city")
public class CityEndpoint {

  private final CityService cityService;

  public CityEndpoint(CityService cityService) {
    this.cityService = cityService;
  }

  @PostMapping
  public ResponseEntity<Void> crateCity(@RequestBody City city) {
    cityService.crateCity(city);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public City getById(@PathVariable UUID id) {
    return cityService.getById(id);
  }

  @GetMapping
  public List<City> getByAll() {
    return cityService.getByAll();
  }


  @PatchMapping("/update-city")
  public ResponseEntity<Void> update(@RequestParam UUID id,@RequestParam String cityName) {
    cityService.update(id, cityName);
    return ResponseEntity.ok().build();
  }


  @DeleteMapping
  public ResponseEntity<Void> delete(@RequestParam UUID id) {
    cityService.delete(id);
    return ResponseEntity.ok().build();
  }

  //get Cities where
//  @GetMapping("/state/{countryid}")
//  public ResponseEntity<List<City>> getByCountryId(@PathVariable UUID countryid){
//    return ResponseEntity.ok(cityService.getByCountryId(countryid));
//  }
}
