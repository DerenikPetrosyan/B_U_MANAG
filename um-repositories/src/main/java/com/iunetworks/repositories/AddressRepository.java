package com.iunetworks.repositories;

import com.iunetworks.entities.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address,UUID > {

  Address getById(UUID id);

  @Modifying
  @Query(nativeQuery = true,
    value = "delete from db_bank_management_um.t_address where id = ?1")
  void delete(UUID id);
}
