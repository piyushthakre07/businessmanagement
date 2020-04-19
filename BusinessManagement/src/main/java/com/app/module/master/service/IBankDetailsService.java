package com.app.module.master.service;

import java.util.List;

import com.app.beans.BankDetailsBean;

public interface IBankDetailsService {
	public boolean insertBankDetails(BankDetailsBean bankDetailsBean);
	public List<BankDetailsBean> displayAllBankDetails();
}
