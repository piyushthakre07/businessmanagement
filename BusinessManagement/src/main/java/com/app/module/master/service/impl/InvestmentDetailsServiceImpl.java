package com.app.module.master.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.app.beans.InvestmentdetailsBean;
import com.app.entities.BusinessUnit;
import com.app.entities.InvestmentDetails;
import com.app.module.master.service.IInvestmentdetailsService;

@Service
public class InvestmentDetailsServiceImpl implements IInvestmentdetailsService {

	@Override
	public boolean insertInvestmentdetails(InvestmentdetailsBean investmentdetailsBean) {
		InvestmentDetails investmentDetails = new InvestmentDetails();
		BeanUtils.copyProperties(investmentdetailsBean, investmentDetails);
		BusinessUnit businessUnit= new BusinessUnit();
		if(investmentDetails.getBusinessUnit().getBusinessUnitID()!=null)
			businessUnit.setBusinessUnitID(investmentDetails.getBusinessUnit().getBusinessUnitID());
		
		
		return false;
	}

	@Override
	public List<InvestmentdetailsBean> displayAllInvestmentDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
