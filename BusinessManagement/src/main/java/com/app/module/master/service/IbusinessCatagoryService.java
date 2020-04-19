package com.app.module.master.service;

import java.util.List;

import com.app.beans.BusinessCatagoryBean;

public interface IbusinessCatagoryService {
public boolean insertBusinessCatagory(BusinessCatagoryBean businessCatagoryBean);
public List<BusinessCatagoryBean> displayAllBusinessCatagory();
}
