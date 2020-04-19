package com.app.beans;


import com.app.entities.BankDetails;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class LeagueBean {
	private Long leagueId;
	private String leagueName;
	private Integer leagueType;
    private String contactNumber;
    private String address;
	private BankDetails bankDetails;
	private String active;
}
