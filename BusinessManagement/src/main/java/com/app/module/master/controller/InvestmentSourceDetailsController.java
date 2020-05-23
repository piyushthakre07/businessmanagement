package com.app.module.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.beans.BusinessUnitBean;
import com.app.module.master.service.IBusinessUnitService;

@RestController
@RequestMapping(value="/investment/investmentsourcedetails")
public class InvestmentSourceDetailsController {

	@Autowired
	IBusinessUnitService businessUnitService;
	
	@GetMapping(value = "/addInvestmentSource", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showInvestmentDetails() {
		ModelAndView mv = new ModelAndView();
		List<BusinessUnitBean> businessUnitList = businessUnitService.displayAllBusinessUnits();
		mv.addObject("businessUnits", businessUnitList);
		mv.setViewName("/addInvestmentSource");
		return mv;
	}
	
	
}
