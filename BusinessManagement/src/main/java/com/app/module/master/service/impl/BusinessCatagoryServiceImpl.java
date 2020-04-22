package com.app.module.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.BusinessCatagoryBean;
import com.app.beans.OwnerBean;
import com.app.entities.BusinessCatagory;
import com.app.entities.Owner;
import com.app.module.master.dao.IBusinessCatagoryDao;
import com.app.module.master.service.IbusinessCatagoryService;

@Service
public class BusinessCatagoryServiceImpl implements IbusinessCatagoryService {
	
	@Autowired
	IBusinessCatagoryDao businessCatagoryDao;
	

	@Override
	public boolean insertBusinessCatagory(BusinessCatagoryBean businessCatagoryBean) {

		try {
			BusinessCatagory businessCatagory = new BusinessCatagory();
			Owner owner = new Owner();
			BeanUtils.copyProperties(businessCatagoryBean, businessCatagory);
			owner.setOwnerId(businessCatagoryBean.getOwner().getOwnerId());
			businessCatagory.setOwner(owner);
			businessCatagoryDao.save(businessCatagory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<BusinessCatagoryBean>displayAllBusinessCatagory() {
		try {
			
		List <BusinessCatagory> businessCoatagoryList=businessCatagoryDao.findAll();
	
		List<BusinessCatagoryBean> businessCatagorybeansList = new ArrayList<>();
		businessCoatagoryList.stream().forEach(businessCatagory->{
		OwnerBean ownerbean=new OwnerBean();
		BusinessCatagoryBean businessCatagoryBean = new BusinessCatagoryBean();
        BeanUtils.copyProperties(businessCatagory, businessCatagoryBean);
        BeanUtils.copyProperties(businessCatagory.getOwner(), ownerbean);
		businessCatagoryBean.setOwner(ownerbean);
		businessCatagorybeansList.add(businessCatagoryBean);
		});
		return businessCatagorybeansList;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;		
		}
		
}

}
