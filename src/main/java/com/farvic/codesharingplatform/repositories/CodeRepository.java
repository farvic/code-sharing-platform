package com.farvic.codesharingplatform.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farvic.codesharingplatform.entities.Code;

public interface CodeRepository extends JpaRepository<Code, String> {

    // @Query("SELECT c FROM Code c WHERE c.id = ?1")
    @Override
    Optional<Code> findById(String id);

    // This function is the same as the query:
    // @Query("SELECT c FROM Code c WHERE c.timeRestricted = false AND
    // c.viewRestricted = false ORDER BY c.date DESC")
    List<Code> findFirst10ByTimeRestrictedIsFalseAndViewRestrictedIsFalseOrderByDateDesc();
}
