package com.ps.tdd.controllers;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.DeserializationFeature;
import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.ps.tdd.entities.Country;
import com.ps.tdd.entities.Location;
import com.ps.tdd.entities.couchbase.CountryLocation;
import com.ps.tdd.mapper.CountryLocationMapper;
import com.ps.tdd.repositories.CountryLocationRepository;
import com.ps.tdd.repositories.CountryRepository;
import com.ps.tdd.repositories.LocationsRepository;


@RestController
public class AggregatorController {
	
	@Autowired
	CountryLocationMapper mapper;
	@Autowired
	CountryRepository country;
	
	@Autowired
	LocationsRepository location;

	@Autowired
	CountryLocationRepository countryLocationRepository;
	
	@GetMapping("/locCountry/{id}")
	private CountryLocation getLocCountry(Long id) {
		
		Location loc = location.findByLocationId(id);
		
		Country count = location.findCountryByLocationId(id);
		
		return mapper.from(loc, count);

	}
	
	@GetMapping("test")
	private void test() {
		// TODO Auto-generated method stub
		Country cou = new Country();
		 cou.setCountryId("PS");
		 cou.setName("Pc");
		 cou.setRegionId(3);
		 this.country.save(cou);
	}
	
	
	@PostMapping("/locCountry")
	@Transactional
	private CountryLocation addLocCountry(@RequestBody CountryLocation id) {
		 ObjectMapper Obj = new ObjectMapper();
	        try {
	            Obj.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

	            String jsonStr = Obj.writeValueAsString(id);
	            
	            System.out.println(jsonStr);
	 
				
	            CountryLocation d = countryLocationRepository.save(id);
				/*
				 * CountryLocation d =
				 * cluster.bucket("Package").defaultCollection().get(id.getCountryId()).
				 * contentAs(CountryLocation.class);
				 */
				 Country cou = mapper.toCountry(d);
				 
				 this.country.save(cou);
	             Location loc = mapper.toLocation(d);
	             loc.setCountryId(id.getCountryId());
	             location.save(loc);
				 
	            System.out.println("returning");

	            return id;
	        }
	 
	        catch (IOException e) {
	            e.printStackTrace();
	        }
			return null;

	}
	
	

}
