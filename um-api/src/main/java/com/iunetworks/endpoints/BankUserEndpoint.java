package com.iunetworks.endpoints;

import com.iunetworks.entities.BankUser;
import com.iunetworks.entities.dto.request.BankUserRequestDto;
import com.iunetworks.entities.dto.response.BankUserResponseDto;
import com.iunetworks.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bank_user")
public class BankUserEndpoint {

  private final BankUserService bankUserService;

  public BankUserEndpoint(BankUserService bankUserService) {
    this.bankUserService = bankUserService;
  }

  @PostMapping
  public ResponseEntity<Void> crateBankUser(@Valid @RequestBody BankUserRequestDto dto) {
    bankUserService.createBankUser(dto);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<BankUserResponseDto> getById(@PathVariable UUID id) {
    return ResponseEntity.ok(bankUserService.getByBankUserId(id));
  }

  @GetMapping
  public ResponseEntity<List<BankUser>> getAll() {
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



  @PatchMapping("/edit_bamnk_user_name")
  public ResponseEntity<Void> changeName(@RequestParam String name,@RequestParam String email) {
    bankUserService.changeName(name,email);
    return ResponseEntity.ok().build();
  }

//  @PatchMapping("/verify")
//  public ResponseEntity<Void> verify(@RequestParam String email, @RequestParam String code){
//    bankUserService.verify(email,code);
//    return ResponseEntity.ok().build();
//  }

  @PatchMapping("/change-password")
  public ResponseEntity<Void> changePassword(@RequestParam String username,
                                             @RequestParam String oldPassword,@RequestParam String newPassword){
    bankUserService.changePassword(username,oldPassword,newPassword);
    return ResponseEntity.ok().build();
  }

  @PatchMapping("/forgot-password")
  public ResponseEntity<Void> forgotPassword(@RequestParam String email) {

    bankUserService.forgotPassword(email);

    return ResponseEntity.ok().build();
  }
}
