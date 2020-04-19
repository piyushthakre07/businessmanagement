package com.app.beans;

import com.app.entities.BankDetails;
import com.app.entities.BusinessUnit;
import com.app.entities.League;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentBean {
	private Long paymentId;
	private String year;
	private String month;
	private League league;
	private String particular;
	private BusinessUnit businessUnit;
	private Integer amount;
	private String paymentMode;
	private String paymentModeDetails;
	private BankDetails bankDetails;
}
