package com.app.beans;

import com.app.entities.BankDetails;
import com.app.entities.BusinessUnit;
import com.app.entities.Ledger;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentBean {
	private Long paymentId;
	private String year;
	private String month;
	private Ledger league;
	private String particular;
	private BusinessUnit businessUnit;
	private Integer amount;
	private String paymentMode;
	private String paymentModeDetails;
	private BankDetails bankDetails;
}
