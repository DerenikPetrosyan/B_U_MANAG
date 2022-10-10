package com.iunetworks.endpoints;

import com.iunetworks.entities.dto.request.CustomerUserRequestDto;
import com.iunetworks.entities.dto.request.SignInDto;
import com.iunetworks.entities.dto.response.CustomerUserResponseDto;
import com.iunetworks.service.CustomerUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer_user")
public class CustomerUserEndpoint {

  private final CustomerUserService customerUserService;

  public CustomerUserEndpoint(CustomerUserService customerUserService) {
    this.customerUserService = customerUserService;
  }


  @PostMapping
  public ResponseEntity<Void> crateCustomerUser(@RequestBody CustomerUserRequestDto dto) {
    customerUserService.createCustomerUser(dto);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerUserResponseDto> getById(@PathVariable UUID id) {
    return ResponseEntity.ok(customerUserService.getByCustomerUserId(id));
  }

  @GetMapping
  public ResponseEntity<List<CustomerUserResponseDto>> getAll() {
    return ResponseEntity.ok(customerUserService.getAll());
  }

  @PatchMapping("update-bank_user")
  public ResponseEntity<Void> update(@RequestBody CustomerUserRequestDto dto) {
    customerUserService.update(dto);
    return ResponseEntity.ok().build();
  }


  @DeleteMapping
  public ResponseEntity<Void> delete(@RequestParam UUID id) {
    customerUserService.delete(id);
    return ResponseEntity.ok().build();
  }


  @PostMapping("/sign_in_user")
  public ResponseEntity<?> signIn(@RequestBody SignInDto dto){

    return ResponseEntity.ok(customerUserService.signIn(dto));
  }



}
