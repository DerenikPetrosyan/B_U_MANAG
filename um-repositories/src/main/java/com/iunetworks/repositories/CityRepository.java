package com.iunetworks.repositories;

import com.iunetworks.entities.address.City;
import com.iunetworks.entities.address.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<City,UUID > {

  City getById(UUID id);

  @Modifying
  @Query(nativeQuery = true,
    value = "update db_bank_management_um.t_city set city = ?2 where id = ?1")
  void updateName(UUID id, String cityName);

  @Modifying
  @Query(nativeQuery = true,
    value = "delete from db_bank_management_um.t_city where id = ?1")
  void delete(UUID id);
}
