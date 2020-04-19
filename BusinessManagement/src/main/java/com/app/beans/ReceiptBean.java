package com.app.beans;

import com.app.entities.BankDetails;
import com.app.entities.BusinessUnit;
import com.app.entities.Ledger;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReceiptBean {
	private Long receiptId;
	private String year;
	private String month;
	private Ledger league;
	private String particular;
	private BusinessUnit businessUnit;
	private Integer amount;
	private String receiptMode;
	private String receiptModeDetails;
	private BankDetails bankDetails;
}
