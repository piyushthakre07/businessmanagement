package com.app.module.master.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.BankDetailsBean;
import com.app.beans.BusinessUnitBean;
import com.app.beans.LedgerBean;
import com.app.beans.ReceiptBean;
import com.app.entities.BankDetails;
import com.app.entities.BusinessUnit;
import com.app.entities.Ledger;
import com.app.entities.Receipt;
import com.app.module.master.dao.IReceiptDao;
import com.app.module.master.service.IReceiptService;

@Service
public class ReceiptServiceImpl implements IReceiptService {
	
	@Autowired
	IReceiptDao receiptDao;

	@Override
	public boolean insertReceipt(ReceiptBean receiptBean) {
		
		try {
			Receipt receipt = new Receipt();
			BeanUtils.copyProperties(receiptBean, receipt);
			BusinessUnit businessUnit = new BusinessUnit();
			if(receiptBean.getBusinessUnit().getBusinessUnitID()!=null)
			businessUnit.setBusinessUnitID(receiptBean.getBusinessUnit().getBusinessUnitID());
			receipt.setBusinessUnit(businessUnit);
			BankDetails bankdetails = new BankDetails();
			if(receiptBean.getBankDetails().getBankId()!=null)
			bankdetails.setBankId(receiptBean.getBankDetails().getBankId());
			receipt.setBankDetails(bankdetails);
			Ledger ledger = new Ledger();
			ledger.setLedgerId(receiptBean.getLedger().getLedgerId());
			receipt.setLedger(ledger);
			receiptDao.save(receipt);
			return true;
		} catch (BeansException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ReceiptBean> DisplayAllReceipts() {
		List<ReceiptBean> receiptBeanList = new ArrayList<ReceiptBean>();
		List<Receipt> receiptList = receiptDao.findAll();
		try {
			receiptList.stream().forEach(receipt->{
				ReceiptBean receiptBean = new ReceiptBean();
				BeanUtils.copyProperties(receipt, receiptBean);
				BusinessUnitBean businessUnitBean = new BusinessUnitBean();
				if(receipt.getBusinessUnit()!=null)
				BeanUtils.copyProperties(receipt.getBusinessUnit(), businessUnitBean);
				receiptBean.setBusinessUnit(businessUnitBean);
				BankDetailsBean bankDetailsBean = new BankDetailsBean();
				if(receipt.getBankDetails()!=null)
				BeanUtils.copyProperties(receipt.getBankDetails(),bankDetailsBean);
				receiptBean.setBankDetails(bankDetailsBean);
				LedgerBean ledgerBean  = new LedgerBean();
				if(receipt.getLedger()!=null)
				BeanUtils.copyProperties(receipt.getLedger(), ledgerBean);
				receiptBean.setLedger(ledgerBean);
				receiptBeanList.add(receiptBean);
			});
			return receiptBeanList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	

}
