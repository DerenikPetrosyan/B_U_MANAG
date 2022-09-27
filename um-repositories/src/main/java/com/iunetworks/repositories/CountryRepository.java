package com.iunetworks.repositories;

import com.iunetworks.entities.address.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CountryRepository extends JpaRepository<Country, UUID> {

  Country getById(UUID id);

  @Modifying
  @Query(nativeQuery = true,
    value = "update db_bank_management_um.t_country set country = ?2 where id = ?1")
  void updateName(UUID id, String countryName);

  @Modifying
  @Query(nativeQuery = true,
    value = "delete from db_bank_management_um.t_country where id = ?1")
  void delete(UUID id);
}
