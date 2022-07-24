package com.hw5.feedback.dao;

import com.hw5.feedback.entity.Shops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShopsRepository extends JpaRepository<Shops, Long> {

    @Query(value = "select establishment, response  from shops where establishment = :establishment", nativeQuery = true)
    Shops getResponseFromShops(@Param("establishment") String response);

    @Query(value = "select establishment, description  from shops where establishment = :establishment", nativeQuery = true)
    Shops getDescriptionFromShops(@Param("establishment") String description);

    @Query(value = "select establishment, rating  from shops where establishment = :establishment", nativeQuery = true)
    Shops getRatingFromShops(@Param("establishment") String rating);

}
