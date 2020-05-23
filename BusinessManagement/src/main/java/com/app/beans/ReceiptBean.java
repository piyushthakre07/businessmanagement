package com.app.beans;

import com.app.entities.Ledger;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReceiptBean {
	private Long receiptId;
	private String year;
	private String month;
	private LedgerBean ledger;
	private String particular;
	private BusinessUnitBean businessUnit;
	private Integer amount;
	private String receiptMode;
	private String receiptModeDetails;
	private BankDetailsBean bankDetails;
}
