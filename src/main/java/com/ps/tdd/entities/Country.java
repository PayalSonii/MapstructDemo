package com.ps.tdd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "countries",schema = "hr")
@Data
public final class Country {

	@Id
	@Column(name = "country_id", unique = true)
	private String countryId;
	@Column(name = "country_name", nullable = false)
	private String name;
	@Column(name = "region_id", nullable = false)
	private int regionId;
	
	/*
	 * @OneToOne(mappedBy="country") private Location location;
	 */

}
