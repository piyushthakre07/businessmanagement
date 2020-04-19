package com.app.module.master.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			bankDetails.setBankId(ledgerBean.getBankDetails().getBankId());
			ledger.setBankDetails(bankDetails);
			ledgerDaO.save(ledger);
			return true;
		} catch (BeansException e) {
			e.printStackTrace();
			return false;
		}
	}

}
