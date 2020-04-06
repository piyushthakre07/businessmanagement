package com.app.model.master.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.OwnerBean;
import com.app.entities.Owner;
import com.app.model.master.dao.IOwnerDao;
import com.app.model.master.service.IOwnerService;

@Service
public class OwnerServiceImpl implements IOwnerService {

	@Autowired
	IOwnerDao ownerDao;

	@Override
	public boolean insertOrUpdateOwner(OwnerBean ownerBean) {
		try {
			Owner owner = new Owner();
			owner.setOwnerName(ownerBean.getOwnerName());
			ownerDao.save(owner);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
