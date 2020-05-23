package com.app.module.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.BusinessUnitBean;
import com.app.beans.LedgerBean;
import com.app.beans.PartnerDetailsBean;
import com.app.entities.BusinessUnit;
import com.app.entities.Ledger;
import com.app.entities.PartnerDetails;
import com.app.module.master.dao.IPartnerDetailsDao;
import com.app.module.master.service.IPartnerDetailsService;

@Service
public class PartnerDetailsServiceImpl implements IPartnerDetailsService {
	@Autowired
	IPartnerDetailsDao partnerDetailsDao;
	@Override
	public boolean insertPartnerDetails(PartnerDetailsBean partnerDetailsBean) {
		try {
			PartnerDetails partnerDetails= new PartnerDetails();
			BeanUtils.copyProperties(partnerDetailsBean, partnerDetails);
			BusinessUnit businessUnit= new BusinessUnit();
			businessUnit.setBusinessUnitID(partnerDetailsBean.getBusinessUnit().getBusinessUnitID());
			partnerDetails.setBusinessUnit(businessUnit);
			Ledger ledger = new Ledger();
			ledger.setLedgerId(partnerDetailsBean.getLedger().getLedgerId());
			partnerDetails.setLedger(ledger);
			partnerDetailsDao.save(partnerDetails);
			return true;
		} catch (BeansException e) {
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public List<PartnerDetailsBean> displayAllPartners() {
		List <PartnerDetailsBean> partnerDetailsBeanList= new ArrayList<PartnerDetailsBean>();
		List<PartnerDetails> partnerDetailsList = partnerDetailsDao.findAll();
		
		try {
			partnerDetailsList.stream().forEach(partnerDetails->{
				PartnerDetailsBean partnerDetailsBean= new PartnerDetailsBean();
				BeanUtils.copyProperties(partnerDetails, partnerDetailsBean);
				BusinessUnitBean businessUnitBean= new BusinessUnitBean();
				BeanUtils.copyProperties(partnerDetails.getBusinessUnit(),businessUnitBean);
				partnerDetailsBean.setBusinessUnit(businessUnitBean);
				BeanUtils.copyProperties(partnerDetails.getBusinessUnit(),businessUnitBean);
				LedgerBean ledgerBean= new LedgerBean();
				BeanUtils.copyProperties(partnerDetails.getLedger(),ledgerBean);
				partnerDetailsBean.setLedger(ledgerBean);
				partnerDetailsBeanList.add(partnerDetailsBean);	
			});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return partnerDetailsBeanList;
	}

	
}
