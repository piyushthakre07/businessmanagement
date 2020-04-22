package com.app.module.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.BusinessUnitBean;
import com.app.beans.InvestmentDetailsBean;
import com.app.beans.LedgerBean;
import com.app.entities.BusinessUnit;
import com.app.entities.InvestmentDetails;
import com.app.entities.Ledger;
import com.app.module.master.dao.IInvestmentDetailsDao;
import com.app.module.master.service.IInvestmentdetailsService;

@Service
public class InvestmentDetailsServiceImpl implements IInvestmentdetailsService {
	@Autowired
	IInvestmentDetailsDao investmentDetailsDao;

	@Override
	public boolean insertInvestmentdetails(InvestmentDetailsBean investmentDetailsBean) {
		try {
			InvestmentDetails investmentDetails = new InvestmentDetails();
			BeanUtils.copyProperties(investmentDetailsBean, investmentDetails);
			BusinessUnit businessUnit = new BusinessUnit();
			System.out.println(investmentDetailsBean.getBusinessUnit().getBusinessUnitID());
			if (investmentDetailsBean.getBusinessUnit().getBusinessUnitID()!= null)
				businessUnit.setBusinessUnitID(investmentDetailsBean.getBusinessUnit().getBusinessUnitID());
			investmentDetails.setBusinessUnit(businessUnit);
			Ledger ledger = new Ledger();
			if (investmentDetailsBean.getPayTo().getLedgerId() != null)
				ledger.setLedgerId(investmentDetailsBean.getPayTo().getLedgerId());
			investmentDetails.setPayTo(ledger);
			investmentDetailsDao.save(investmentDetails);
			return true;
		} catch (BeansException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<InvestmentDetailsBean> displayAllInvestmentDetails() {
		try {
			List<InvestmentDetails> investmentDetailsList = investmentDetailsDao.findAll();
			List<InvestmentDetailsBean> investmentdetailsBeanList = new ArrayList<>();
			investmentDetailsList.stream().forEach(investmentDetail -> {
				InvestmentDetailsBean investmenDetailsBean = new InvestmentDetailsBean();
				BeanUtils.copyProperties(investmentDetail, investmenDetailsBean);
				BusinessUnitBean businessUnitBean = new BusinessUnitBean();
				LedgerBean ledgerBean = new LedgerBean();
				if (investmentDetail.getBusinessUnit() != null)
					BeanUtils.copyProperties(investmentDetail.getBusinessUnit(), businessUnitBean);
				investmenDetailsBean.setBusinessUnit(businessUnitBean);
				if (investmentDetail.getPayTo() != null)
					BeanUtils.copyProperties(investmentDetail.getPayTo(), ledgerBean);
				investmenDetailsBean.setPayTo(ledgerBean);
				investmentdetailsBeanList.add(investmenDetailsBean);

			});
			return investmentdetailsBeanList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
