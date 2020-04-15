package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="business_unit")
@Setter @Getter
public class BusinessUnit {
	
	@Id
	@Column(name = "businessUnit_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long businessUnitID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "businessCatagory_id")
	private BusinessCatagory businessCatagory;
	
	@Column(name="unitName")
	private String unitName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="description")
	private String description;
	
	@Column(name="active")
	private String active;
}
