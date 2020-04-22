package com.app.beans;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PartnerDetailsBean {
	private BusinessUnitBean businessUnit;
	private String partnerName;
	private String partnerContactNumber;
	private String partnerAddress;
	private Integer partnerAmountInvest;
	private Integer partnerPercentage;
	private String duration;
	private String description;
	private LedgerBean ledger;
	private String active;
}
