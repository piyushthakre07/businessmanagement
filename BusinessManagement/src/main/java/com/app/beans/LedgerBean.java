package com.app.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LedgerBean {

	private Long ledgerId;
	private String ledgerName;
	private BusinessCatagoryBean businessCatagory;
	private String ledgerType;
	private String contactNumber;
	private String address;
	private BankDetailsBean bankDetails;
	private String remark;
	private String active;
}
