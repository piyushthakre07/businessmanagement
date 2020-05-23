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
import com.app.beans.PaymentBean;
import com.app.entities.BankDetails;
import com.app.entities.BusinessUnit;
import com.app.entities.Ledger;
import com.app.entities.Payment;
import com.app.module.master.dao.IPaymentDao;
import com.app.module.master.service.IPaymentService;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	IPaymentDao paymentServiceDao;

	@Override
	public boolean insertPayment(PaymentBean paymentBean) {
		try {
			Payment payment = new Payment();
			BeanUtils.copyProperties(paymentBean, payment);
			BusinessUnit businessUnit = new BusinessUnit();
			if(paymentBean.getBusinessUnit().getBusinessUnitID()!=null)
			businessUnit.setBusinessUnitID(paymentBean.getBusinessUnit().getBusinessUnitID());
			payment.setBusinessUnit(businessUnit);
			BankDetails bankdetails = new BankDetails();
			if(paymentBean.getBankDetails().getBankId()!=null)
			bankdetails.setBankId(paymentBean.getBankDetails().getBankId());
			payment.setBankDetails(bankdetails);
			Ledger ledger = new Ledger();
			ledger.setLedgerId(paymentBean.getLedger().getLedgerId());
			payment.setLedger(ledger);
			paymentServiceDao.save(payment);
			return true;
		} catch (BeansException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<PaymentBean> displayPayments() {
		List<PaymentBean> PaymentBeanList = new ArrayList<PaymentBean>();
		List<Payment> paymentList = paymentServiceDao.findAll();

		try {
			paymentList.stream().forEach(payment->{
				PaymentBean paymentBean = new PaymentBean();
				BeanUtils.copyProperties(payment, paymentBean);
				BusinessUnitBean businessUnitBean = new BusinessUnitBean();
				if(payment.getBusinessUnit()!=null)
				BeanUtils.copyProperties(payment.getBusinessUnit(), businessUnitBean);
				paymentBean.setBusinessUnit(businessUnitBean);
				LedgerBean ledgerBean  = new LedgerBean();
				if(payment.getLedger()!=null)
				BeanUtils.copyProperties(payment.getLedger(), ledgerBean);
				paymentBean.setLedger(ledgerBean);
				BankDetailsBean bankDetailsBean = new BankDetailsBean();
				if(payment.getBankDetails()!=null)
				BeanUtils.copyProperties(payment.getBankDetails(),bankDetailsBean);
				paymentBean.setBankDetails(bankDetailsBean);
				PaymentBeanList.add(paymentBean);
			});
			return PaymentBeanList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
