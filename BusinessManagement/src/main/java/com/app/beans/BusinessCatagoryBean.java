package com.app.beans;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class BusinessCatagoryBean {
	private Long businessCatagoryId;
	private String businessCatagoryName;
	private String businessCatagoryDescription;
	private String active; 
	private OwnerBean owner;

}
