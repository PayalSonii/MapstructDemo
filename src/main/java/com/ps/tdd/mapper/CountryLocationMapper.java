package com.ps.tdd.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.ps.tdd.entities.Country;
import com.ps.tdd.entities.Location;
import com.ps.tdd.entities.couchbase.CountryLocation;

@Mapper(componentModel ="spring")
public interface CountryLocationMapper{
	@Mappings({
	      @Mapping(target="city", source="location.city"),
	      @Mapping(target="state_province", source="location.state_province"),
	      @Mapping(target="name", source="country.name"),
		  @Mapping(target="regionId", source="country.regionId")
	      ,@Mapping(target="countryId", source="country.countryId"),
	      @Mapping(target="locID", source="location.locationId")
	    })

	CountryLocation  from(Location location, Country country);
	
	 @Mapping(target="locationId", source="location.locID")
	Location toLocation(CountryLocation location);
	
	Country toCountry(CountryLocation location);

	
}
