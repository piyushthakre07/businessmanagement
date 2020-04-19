package com.app.module.master.service;

import java.util.List;

import com.app.beans.InvestmentdetailsBean;

public interface IInvestmentdetailsService {
	public boolean insertInvestmentdetails(InvestmentdetailsBean investmentdetailsBean);
	public List<InvestmentdetailsBean> displayAllInvestmentDetails();
	

}
