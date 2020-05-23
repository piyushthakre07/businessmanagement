package com.app.module.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.BankDetailsBean;
import com.app.beans.BusinessCatagoryBean;
import com.app.beans.BusinessUnitBean;
import com.app.entities.BankDetails;
import com.app.entities.BusinessCatagory;
import com.app.entities.BusinessUnit;
import com.app.module.master.dao.IBusinessUnitDAO;
import com.app.module.master.service.IBusinessUnitService;

@Service
public class BusinessUnitServiceImpl implements IBusinessUnitService{

	@Autowired
	IBusinessUnitDAO businessUnitDAO;
	
	
	@Override
	public boolean insertBusinessUnit(BusinessUnitBean businessUnitBean) {
		try {
		BusinessUnit businessUnit= new BusinessUnit();
		BusinessCatagory businessCatagory = new BusinessCatagory();
		BeanUtils.copyProperties(businessUnitBean, businessUnit);
		if(businessUnitBean.getBusinessCatagory().getBusinessCatagoryId()!=null)
		businessCatagory.setBusinessCatagoryId(businessUnitBean.getBusinessCatagory().getBusinessCatagoryId());
		businessUnit.setBusinessCatagory(businessCatagory);
		BankDetails bankDetails= new BankDetails();
		if(businessUnitBean.getBankDetails().getBankId()!=null)
		bankDetails.setBankId(businessUnitBean.getBankDetails().getBankId());
		businessUnit.setBankDetails(bankDetails);
		businessUnitDAO.save(businessUnit);	
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;	
		}	
	}


	@Override
	public List<BusinessUnitBean> displayAllBusinessUnits() {
		
		try {

			BankDetailsBean bankDetailsBean = new BankDetailsBean();
			List<BusinessUnit> businessUnitList = businessUnitDAO.findAll();
			List<BusinessUnitBean> businessUnitBeanList = new ArrayList<BusinessUnitBean>();
			businessUnitList.stream().forEach(businessUnit -> {
				BusinessCatagoryBean businessCatagoryBean = new BusinessCatagoryBean();
				BusinessUnitBean businessUnitbean = new BusinessUnitBean();
				BeanUtils.copyProperties(businessUnit, businessUnitbean);
				if (businessUnit.getBusinessCatagory() != null)
					BeanUtils.copyProperties(businessUnit.getBusinessCatagory(), businessCatagoryBean);
				businessUnitbean.setBusinessCatagory(businessCatagoryBean);
				if (businessUnit.getBankDetails()!= null)
					BeanUtils.copyProperties(businessUnit.getBankDetails(), bankDetailsBean);
				businessUnitbean.setBankDetails(bankDetailsBean);
				businessUnitBeanList.add(businessUnitbean);
			});
			return businessUnitBeanList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	

	
}
