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

	private Long loanAmount;

	private Integer tenure;

	private String installmentFrequency;

	private Integer rateOfInterest;

	private Long totalInterestPaid;

	private Long emiAmountPerMonth;

	private String paymentMode;

	private String emiStartDate;

	private Integer dueOn;

	private String description;

	private String active;

	private String remark;

}
