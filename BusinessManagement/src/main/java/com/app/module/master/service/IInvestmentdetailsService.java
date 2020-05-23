package com.app.module.master.service;

import java.util.List;

import com.app.beans.InvestmentDetailsBean;

public interface IInvestmentdetailsService {
	public boolean insertInvestmentdetails(InvestmentDetailsBean investmentdetailsBean);
	public List<InvestmentDetailsBean> displayAllInvestmentDetails();
	

}
