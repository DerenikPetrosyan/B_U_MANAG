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

  boolean existsByCity(String city);
}
