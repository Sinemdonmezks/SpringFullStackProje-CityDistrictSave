package com.sinem.repository;

import com.sinem.repository.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICityRepository extends JpaRepository<City,Long> {
    Optional<City> findOptionalByCityAndDistrictAndRegion(String city,String district,String region);
    Optional<City> findOptionalById(Long id);
}
