package com.app.module.master.service;

import java.util.List;

import com.app.beans.PaymentBean;

public interface IPaymentService {
	public boolean insertPayment(PaymentBean paymentBean);
	public List<PaymentBean> displayPayments();

}
