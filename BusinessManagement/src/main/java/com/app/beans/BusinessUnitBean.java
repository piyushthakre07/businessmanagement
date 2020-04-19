package com.app.beans;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BusinessUnitBean {
	private Long businessUnitID;
	private BusinessCatagoryBean businessCatagory;
	private String unitName;
	private String address;
	private String description;
	private String active;
	private BankDetailsBean bankDetails;
}
