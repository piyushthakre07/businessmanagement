package com.app.beans;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class BankDetailsBean {

	private Long bankId;

	private String payeeName;

	private String bankName;

	private Integer accountNumber;
	
	private String ifscCode;
	
	private String accountType;
	
	private String bankAddress;
	
	private String active;

}
