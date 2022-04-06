package com.ps.tdd.entities.couchbase;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;

import lombok.Data;

@Document
@Data
@Scope("CreditPackage")
@Collection("customer")
public class CountryLocation {
	@Id
	@Field
	private String countryId;
	@Field
	private String name;
	@Field
	private int regionId;
	@Field
	private int locID;
	@Field
	private String city;
	@Field
	private String state_province;

}
