package com.app.beans;

import com.app.entities.BusinessUnit;
import com.app.entities.Ledger;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PartnerDetailsBean {
	private BusinessUnit businessUnit;
	private String partnerName;
	private String partnerContactNumber;
	private String partnerAddress;
	private Integer partnerAmountInvest;
	private Integer partnerPercentage;
	private String duration;
	private String description;
	private Ledger league;
	private String active;
}
