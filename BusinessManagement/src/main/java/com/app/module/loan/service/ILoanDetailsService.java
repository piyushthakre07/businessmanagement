package com.app.module.loan.service;

import java.util.List;

import com.app.beans.LoanDetailsBean;

public interface ILoanDetailsService {
	public boolean insertLoanDetails(LoanDetailsBean investmentdetailsBean);
	public List<LoanDetailsBean> displayAllLoanDetails();
	

}
