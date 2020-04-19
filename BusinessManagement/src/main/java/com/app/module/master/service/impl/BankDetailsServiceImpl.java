package com.app.module.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.beans.BankDetailsBean;
import com.app.entities.BankDetails;
import com.app.module.master.dao.IBankDetailsDao;
import com.app.module.master.service.IBankDetailsService;

@Service
public class BankDetailsServiceImpl implements IBankDetailsService {
	@Autowired
	IBankDetailsDao bankDetailsDao;

	@Override
	public boolean insertBankDetails(BankDetailsBean bankDetailsBean) {
		try {
			BankDetails bankDetails= new BankDetails();
			BeanUtils.copyProperties(bankDetailsBean, bankDetails);
			bankDetailsDao.save(bankDetails);
			return true;
		} catch (BeansException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<BankDetailsBean> displayAllBankDetails() {
		List<BankDetailsBean> bankDetailsBeanList;
		try {
			List<BankDetails> bankDetailsList = bankDetailsDao.findAll();
			 bankDetailsBeanList = new ArrayList<BankDetailsBean>();
			 bankDetailsList.stream().forEach(bankDetails->{
				BankDetailsBean bankDetailsBean= new BankDetailsBean();
				BeanUtils.copyProperties(bankDetailsBean, bankDetails);	
				bankDetailsBeanList.add(bankDetailsBean);
				});
			 return bankDetailsBeanList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
		
	}

}
