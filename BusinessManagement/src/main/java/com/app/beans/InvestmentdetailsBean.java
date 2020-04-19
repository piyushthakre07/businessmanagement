package com.app.beans;

import com.app.entities.BusinessUnit;
import com.app.entities.Ledger;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InvestmentdetailsBean {
	private Long investmentId;
	private BusinessUnit businessUnit;
	private Integer totalInvestAmount;
	private Integer amountInvest;
	private Integer percentage;
	private String duration;
	private Ledger payTo;
	private String description;
	private String active;
}
