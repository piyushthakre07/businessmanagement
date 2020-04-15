package com.app.model.master.service;

import java.util.List;

import com.app.beans.OwnerBean;

public interface IOwnerService {
	public boolean insertOrUpdateOwner(OwnerBean ownerBean);
	public List<OwnerBean> displayAllOwners();
}
