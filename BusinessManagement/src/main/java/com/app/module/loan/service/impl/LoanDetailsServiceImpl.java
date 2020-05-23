package com.app.module.loan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.BankDetailsBean;
import com.app.beans.LedgerBean;
import com.app.beans.LoanDetailsBean;
import com.app.entities.BankDetails;
import com.app.entities.Ledger;
import com.app.entities.LoanDetails;
import com.app.module.loan.dao.ILoanDetailsDao;
import com.app.module.loan.service.ILoanDetailsService;

@Service
public class LoanDetailsServiceImpl implements ILoanDetailsService {
	@Autowired
	ILoanDetailsDao loanDetailsDao;

	@Override
	public boolean insertLoanDetails(LoanDetailsBean loanDetailsBean) {
		try {
			LoanDetails loanDetails = new LoanDetails();
			BeanUtils.copyProperties(loanDetailsBean, loanDetails);
			if (loanDetailsBean.getLoanFromLeadger() != null
					&& loanDetailsBean.getLoanFromLeadger().getLedgerId() != null) {
				Ledger ledger = new Ledger();
				ledger.setLedgerId(loanDetailsBean.getLoanFromLeadger().getLedgerId());
				loanDetails.setLoanFromLeadger(ledger);
			}
			if (loanDetailsBean.getLoanReceiveIntoBank() != null
					&& loanDetailsBean.getLoanReceiveIntoBank().getBankId() != null) {
				BankDetails bankDetails = new BankDetails();
				bankDetails.setBankId(loanDetailsBean.getLoanReceiveIntoBank().getBankId());
				loanDetails.setLoanReceiveIntoBank(bankDetails);
			}
			loanDetailsDao.save(loanDetails);
			return true;
		} catch (BeansException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<LoanDetailsBean> displayAllLoanDetails() {
		try {
			List<LoanDetails> loanDetailsList = loanDetailsDao.findAll();
			List<LoanDetailsBean> loanDetailsBeanList = new ArrayList<>();
			loanDetailsList.stream().forEach(loanDetail -> {
				LoanDetailsBean loanDetailsBean = new LoanDetailsBean();
				BeanUtils.copyProperties(loanDetail, loanDetailsBean);
				if (loanDetail.getLoanFromLeadger() != null) {
					LedgerBean loanFromLeadgerBean = new LedgerBean();
					BeanUtils.copyProperties(loanDetail.getLoanFromLeadger(), loanFromLeadgerBean);
					loanDetailsBean.setLoanFromLeadger(loanFromLeadgerBean);
				}
				if (loanDetail.getLoanReceiveIntoBank() != null) {
					BankDetailsBean loanReceiveIntoBankBean = new BankDetailsBean();
					BeanUtils.copyProperties(loanDetail.getLoanReceiveIntoBank(), loanReceiveIntoBankBean);
					loanDetailsBean.setLoanReceiveIntoBank(loanReceiveIntoBankBean);
				}
				loanDetailsBeanList.add(loanDetailsBean);
			});
			return loanDetailsBeanList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
