package com.app.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentBean {
	private Long paymentId;
	private String year;
	private String month;
	private LedgerBean ledger;
	private String particular;
	private BusinessUnitBean businessUnit;
	private Integer amount;
	private String paymentMode;
	private String paymentModeDetails;
	private BankDetailsBean bankDetails;
}
