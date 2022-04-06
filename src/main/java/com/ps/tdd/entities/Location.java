package com.ps.tdd.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;

@Entity
@Table(name = "locations")
@Data
public class Location {

	@Id
	@Column(name = "location_id")
	Long locationId;

	@Column(name="street_address")
	String streetAddress;

	@Column(name="postal_code")
	String postalCode;
	String city;

	String state_province;
	/*
	 * @JoinColumn(name = "country_id")
	 * 
	 * @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) Country
	 * country;
	 */
	
	@Column(name="country_id")
	String countryId;

}
