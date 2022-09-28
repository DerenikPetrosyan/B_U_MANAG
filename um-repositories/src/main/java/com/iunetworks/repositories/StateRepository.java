package com.iunetworks.repositories;

import com.iunetworks.entities.address.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StateRepository extends JpaRepository<State,UUID> {

  State getById(UUID id);

  boolean existsByState(String state);

  @Modifying
  @Query(nativeQuery = true,
    value = "update db_bank_management_um.t_state set state = ?2 where id = ?1")
  void updateName(UUID id, String stateName);

  @Modifying
  @Query(nativeQuery = true,
    value = "delete from db_bank_management_um.t_state where id = ?1")
  void delete(UUID id);
}
