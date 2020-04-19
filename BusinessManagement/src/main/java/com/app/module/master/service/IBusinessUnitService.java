package com.app.module.master.service;

import java.util.List;

import com.app.beans.BusinessUnitBean;

public interface IBusinessUnitService {
	public boolean insertBusinessUnit(BusinessUnitBean businessUnitBean);
	public List<BusinessUnitBean> displayAllBusinessUnits();
}
