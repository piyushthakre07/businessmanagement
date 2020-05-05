package com.app.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InvestmentDetailsBean {
	private Long investmentId;
	private BusinessUnitBean businessUnit;
	private Integer totalInvestAmount;
	private Integer amountInvest;
	private Integer percentage;
	private String duration;
	private LedgerBean payTo;
	private String description;
	private String active;
	private String remark;
}
