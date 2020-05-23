package com.app.module.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.BankDetailsBean;
import com.app.beans.LedgerBean;
import com.app.entities.BankDetails;
import com.app.entities.Ledger;
import com.app.module.master.dao.ILedgerDao;
import com.app.module.master.service.ILedgerService;

@Service
public class LedgerServiceImpl implements ILedgerService {

	@Autowired
	ILedgerDao ledgerDaO;

	@Override
	public boolean insertLeadger(LedgerBean ledgerBean) {
		try {
			Ledger ledger = new Ledger();
			BeanUtils.copyProperties(ledgerBean, ledger);
			BankDetails bankDetails = new BankDetails();
			if(ledgerBean.getBankDetails().getBankId()!=null)
			bankDetails.setBankId(ledgerBean.getBankDetails().getBankId());
			ledger.setBankDetails(bankDetails);
			ledgerDaO.save(ledger);
			return true;
		} catch (BeansException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<LedgerBean> displayAllLedger() {
		
			List <Ledger> leadgerList=ledgerDaO.findAll();
			List<LedgerBean> ledgerBeanList = new ArrayList<LedgerBean>();
			try {
			leadgerList.stream().forEach(leadger->{
				LedgerBean ledgerBean= new LedgerBean();
				BeanUtils.copyProperties(leadger, ledgerBean);
				BankDetailsBean bankDetailsBean = new BankDetailsBean();
				if(leadger.getBankDetails()!=null)
				BeanUtils.copyProperties(leadger.getBankDetails(),bankDetailsBean);
				ledgerBean.setBankDetails(bankDetailsBean);
				ledgerBeanList.add(ledgerBean);	
			});
			return ledgerBeanList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
			
			}

}
