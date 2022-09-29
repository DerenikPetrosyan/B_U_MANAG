package com.iunetworks.endpoints.address;

import com.iunetworks.entities.address.State;
import com.iunetworks.service.address.StateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/state")
public class StateEndpoint {

  private final StateService stateService;

  public StateEndpoint(StateService stateService) {
    this.stateService = stateService;
  }

  @PostMapping
  public ResponseEntity<Void> crateState(@RequestBody State state){
    stateService.crateState(state);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public State getById(@PathVariable UUID id) {
    return stateService.getById(id);
  }

  @GetMapping
  public List<State> getByAll(){
    return stateService.getByAll();
  }



  @PatchMapping("/update-state")
  public ResponseEntity<Void> update(@RequestBody State state) {
    stateService.update(state);
    return ResponseEntity.ok().build();
  }


  @DeleteMapping
  public ResponseEntity<Void> delete(@RequestParam UUID id) {
    stateService.delete(id);
    return ResponseEntity.ok().build();
  }
//  @GetMapping("/country/{countryid}")
//  public ResponseEntity<List<State>> getByCountryId(@PathVariable UUID countryid){
//    return ResponseEntity.ok(stateService.getByCountryId(countryid));
//  }

}
