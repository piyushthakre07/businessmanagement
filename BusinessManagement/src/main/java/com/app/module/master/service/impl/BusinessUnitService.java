package com.app.module.master.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.BusinessUnitBean;
import com.app.entities.BusinessCatagory;
import com.app.entities.BusinessUnit;
import com.app.module.master.dao.IBusinessUnitDAO;
import com.app.module.master.service.IBusinessUnitService;

@Service
public class BusinessUnitService implements IBusinessUnitService{

	@Autowired
	IBusinessUnitDAO businessUnitDAO;
	
	
	@Override
	public boolean addBusinessUnit(BusinessUnitBean businessUnitBean) {
		try {
		BusinessUnit businessUnit= new BusinessUnit();
		BusinessCatagory businessCatagory = new BusinessCatagory();
		BeanUtils.copyProperties(businessUnitBean, businessUnit);
		BeanUtils.copyProperties(businessUnitBean.getBusinessCatagory(),businessCatagory );
		businessUnit.setBusinessCatagory(businessCatagory);
		businessUnitDAO.save(businessUnit);	
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;	
		}
		
		
		
	}

	

	
}
