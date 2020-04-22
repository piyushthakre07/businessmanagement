package com.app.module.master.service;

import java.util.List;

import com.app.beans.PartnerDetailsBean;

public interface IPartnerDetailsService {
	public boolean insertPartnerDetails(PartnerDetailsBean partnerDetailsBean);
	public List<PartnerDetailsBean> displayAllPartners();

}
