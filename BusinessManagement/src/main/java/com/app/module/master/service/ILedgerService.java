package com.app.module.master.service;

import java.util.List;

import com.app.beans.LedgerBean;

public interface ILedgerService {
	public boolean insertLeadger(LedgerBean ledgerBean);
	public List<LedgerBean> displayAllLedger();
}
