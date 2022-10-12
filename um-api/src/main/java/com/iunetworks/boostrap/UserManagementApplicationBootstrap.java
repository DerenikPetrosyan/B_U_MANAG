//package com.iunetworks.boostrap;
//
//import com.iunetworks.entities.Privilege;
//import com.iunetworks.entities.Role;
//import com.iunetworks.repositories.PrivilegeRepository;
//import com.iunetworks.repositories.RoleRepository;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Set;
//
//@Component
//public class UserManagementApplicationBootstrap {
//
//  private static final String bank_user_role = "BANKUSER";
//  private static final String customer_role = "CUSTOMER";
//  private static final String admin_role = "ADMIN";
//  private static final String vip_customer_role = "VIPCUSTOMER";
//  private final RoleRepository repository;
//  private final PrivilegeRepository privilegeRepository;
//
//  public UserManagementApplicationBootstrap(final RoleRepository repository,
//                                            final PrivilegeRepository privilegeRepository) {
//    this.privilegeRepository = privilegeRepository;
//    this.repository = repository;
//  }
//
//  public void init() {
//
//    if (!this.repository.existsByNameAndDeletedIsNull(admin_role)) {
//      Role adminRole = new Role();
//      adminRole.setRoleName(admin_role);
//      adminRole.setPrivileges(this.adminPermissions());
//      this.repository.save(adminRole);
//    }
//
//    if (!this.repository.existsByNameAndDeletedIsNull(bank_user_role)) {
//      Role bankUserRole = new Role();
//      bankUserRole.setRoleName(bank_user_role);
//      bankUserRole.setPrivileges(this.bankUserPermissions());
//      this.repository.save(bankUserRole);
//    }
//
//    if (!this.repository.existsByNameAndDeletedIsNull(customer_role)) {
//      Role customerRole = new Role();
//      customerRole.setRoleName(customer_role);
//      customerRole.setPrivileges(this.customerPermissions());
//      this.repository.save(customerRole);
//    }
//
//    if (!this.repository.existsByNameAndDeletedIsNull(vip_customer_role)) {
//      Role vipCustomerRole = new Role();
//      vipCustomerRole.setRoleName(vip_customer_role);
//      vipCustomerRole.setPrivileges(this.customerPermissions());
//      this.repository.save(vipCustomerRole);
//    }
//
//  }
//
//  private Set<Privilege> bankUserPermissions() {
//    return this.privilegeRepository.findAllByNameInAndDeletedIsNull(
//      Set.of("can_update_bank_user", "can_delete_bank_user",
//        "can_view_bank_user", "can_create_customer", "can_update_customer",
//        "can_delete_customer", "can_view_customer"));
//  }
//
//  private Set<Privilege> adminPermissions() {
//    return this.privilegeRepository.findAllByNameInAndDeletedIsNull(
//      Set.of("can_create_admin", "can_delete_admin", "can_view_admin", "can_update_admin",
//        "can_create_bank_user", "can_update_bank_user", "can_delete_bank_user",
//        "can_view_bank_user", "can_create_customer", "can_update_customer",
//        "can_delete_customer", "can_view_customer"));
//
//  }
//
//  private Set<Privilege> customerPermissions() {
//    return this.privilegeRepository.findAllByNameInAndDeletedIsNull(
//      Set.of("can_create_customer", "can_update_customer","can_delete_customer"));
//  }
//
//  private Set<Privilege> vipCustomerPermissions() {
//    return this.privilegeRepository.findAllByNameInAndDeletedIsNull(
//      Set.of("can_create_customer", "can_update_customer","can_delete_customer"));
//  }
//
//}
//
