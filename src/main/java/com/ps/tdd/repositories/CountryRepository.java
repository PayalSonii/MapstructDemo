package com.ps.tdd.repositories;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.ps.tdd.entities.Country;

@RepositoryRestResource(path = "country", collectionResourceRel  = "country")
public interface CountryRepository extends Repository<Country, String> {

	 
	void delete(Country deleted);

	List<Country> findAll();
	@RestResource(path="countryId", rel = "countryId")
	Optional<Country> findByCountryId(@PathParam("countryId")String country_id);
	Country save(Country country);
	/*
	 * Country save(Country country);
	 * 
	 * Country saveAndFlush(Country country);
	 */
	@RestResource(exported = false)
	Optional<Country> findByRegionId(@Param("regionId")int region_id);
	

}
