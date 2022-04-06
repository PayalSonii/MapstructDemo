package com.ps.tdd.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.ps.tdd.entities.Country;
import com.ps.tdd.entities.Location;

@RepositoryRestResource(path ="location")
public interface LocationsRepository extends CrudRepository<Location, Long> {
	
	@RestResource(path="locationId")
	Location findByLocationId(Long id);

	@Query(value= "select cou from Location  loc  join Country  cou on loc.countryId = cou.countryId where loc.locationId= ?1")
	Country findCountryByLocationId(Long id);
	
	Location save(Location loc);
	Location saveAndFlush(Location loc);
}
