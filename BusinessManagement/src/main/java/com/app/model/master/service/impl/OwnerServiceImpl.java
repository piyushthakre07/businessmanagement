package com.app.model.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
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

	@Override
	public List<OwnerBean> displayAllOwners() {
		try {
			List<Owner> OwnerList = ownerDao.findAll();
			List<OwnerBean> ownerBeanList = new ArrayList<OwnerBean>();
			OwnerList.stream().forEach(owner -> {
				OwnerBean owneryBean = new OwnerBean();
				BeanUtils.copyProperties(owner, owneryBean);
				ownerBeanList.add(owneryBean);
			});
			return ownerBeanList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
