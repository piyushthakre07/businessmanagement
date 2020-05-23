package com.app.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoanDetailsBean {

	private Long loanId;

	private String loanTitle;

	private LedgerBean loanFromLeadger;

	private BankDetailsBean loanReceiveIntoBank;

	private String loanAmount;

	private String tenure;

	private String installmentFrequency;

	private String rateOfInterest;

	private String totalInterestPaid;

	private String emiAmountPerMonth;

	private String paymentMode;

	private String emiStartDate;

	private String dueOn;

	private String description;

	private String active;

	private String remark;

}
