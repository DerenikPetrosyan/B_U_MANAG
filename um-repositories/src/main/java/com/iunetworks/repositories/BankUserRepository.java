package com.iunetworks.repositories;

import com.iunetworks.entities.BankUser;
import com.iunetworks.entities.dto.request.BankUserRequestDto;
import com.iunetworks.entities.dto.response.BankUserResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BankUserRepository extends JpaRepository<BankUser, UUID> {


  boolean existsByEmail(String email);

//  @Modifying
//  @Query(value = "select new com.iunetworks.entities.dto.response.BankUserResponseDto(b.id,b.name," +
//    "b.surname,b.email,b.gender,b.roles,b.status,b.created,b.updated) from BankUser b")
//  List<BankUserResponseDto> getAll();

//  @Modifying
//  @Query(nativeQuery = true,
//    value = "update db_bank_management_um.t_bank_user set name = ?1 where email = ?2")
//  void changeName(String name, String email);

//  @Modifying
//  @Query(value = "select new com.iunetworks.entities.dto.response.BankUserResponseDto(b.id,b.name," +
//    "b.surname,b.email,b.gender,b.roles,b.status,b.created,b.updated) from BankUser b")
//  BankUserResponseDto getByDtoId(UUID id);

//  void update(BankUserRequestDto dto);
}
