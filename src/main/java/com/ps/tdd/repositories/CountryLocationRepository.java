package com.ps.tdd.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ps.tdd.entities.couchbase.CountryLocation;

public interface CountryLocationRepository extends CrudRepository<CountryLocation, String>{

}
