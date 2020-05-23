package com.app.module.master.service;

import java.util.List;

import com.app.beans.ReceiptBean;

public interface IReceiptService {
	public boolean insertReceipt(ReceiptBean receiptBean);
	public List<ReceiptBean> DisplayAllReceipts();
}
