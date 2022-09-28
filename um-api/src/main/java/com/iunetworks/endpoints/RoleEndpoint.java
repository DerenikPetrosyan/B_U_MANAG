package com.iunetworks.endpoints;

import com.iunetworks.entities.Role;
import com.iunetworks.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleEndpoint {

  private final RoleService roleService;


  public RoleEndpoint(RoleService roleService) {
    this.roleService = roleService;
  }


  @PostMapping
  public ResponseEntity<Void> crateRole(@RequestBody Role role) {
    roleService.createRole(role);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Role> getRoleId(@PathVariable UUID id) {
    return ResponseEntity.ok(roleService.getRoleId(id));
  }

  @GetMapping
  public ResponseEntity<List<Role>> getRoles() {
    return ResponseEntity.ok(roleService.getRoles());
  }

  @PatchMapping("update-role")
  public ResponseEntity<Void> updateRoleName(@RequestParam UUID id,@RequestParam String roleName) {
    roleService.updateRoleName(id,roleName);
    return ResponseEntity.ok().build();
  }


  @DeleteMapping
  public ResponseEntity<Void> delete(@RequestParam UUID id) {
    roleService.delete(id);
    return ResponseEntity.ok().build();
  }

}
