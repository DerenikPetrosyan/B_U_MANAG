package com.iunetworks.endpoints;


import com.iunetworks.entities.dto.request.BankUserRequestDto;
import com.iunetworks.entities.dto.request.CustomerUserRequestDto;
import com.iunetworks.entities.dto.request.SignInDto;
import com.iunetworks.entities.dto.response.BankUserResponseDto;
import com.iunetworks.service.BankUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/bank_user")
public class BankUserEndpoint {

  private final BankUserService bankUserService;

  public BankUserEndpoint(BankUserService bankUserService) {
    this.bankUserService = bankUserService;
  }

  @PostMapping
  public ResponseEntity<Void> crateBankUser(@RequestBody BankUserRequestDto dto) {
    bankUserService.createBankUser(dto);

    return ResponseEntity.ok().build();
  }

  @PostMapping("/crate_customer")
  public ResponseEntity<Void> crateCustomer(@RequestBody CustomerUserRequestDto dto) {
    bankUserService.createCustomer(dto);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<BankUserResponseDto> getById(@PathVariable UUID id) {
    return ResponseEntity.ok(bankUserService.getByBankUserId(id));
  }

  @GetMapping
  public ResponseEntity<List<BankUserResponseDto>> getAll() {
    return ResponseEntity.ok(bankUserService.getAll());
  }

  @PatchMapping("update-bank_user")
  public ResponseEntity<Void> update(@RequestBody BankUserRequestDto dto) {
    bankUserService.update(dto);
    return ResponseEntity.ok().build();
  }


  @DeleteMapping
  public ResponseEntity<Void> delete(@RequestParam UUID id) {
    bankUserService.delete(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/sign_in_user")
  public ResponseEntity<?> signIn(@RequestBody SignInDto dto){
    return ResponseEntity.ok(bankUserService.signIn(dto));
  }


}
