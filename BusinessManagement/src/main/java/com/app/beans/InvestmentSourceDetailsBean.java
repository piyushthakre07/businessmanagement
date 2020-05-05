package com.app.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InvestmentSourceDetailsBean {
	
	private Long investmentSourceDetailsId;
	private BusinessUnitBean businessUnit;
	private String investmentType;
	private LoanDetailsBean loanDetails;
	private String description;
	private String remark;
	private String active;

}
