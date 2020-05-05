package com.app.module.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.beans.BusinessUnitBean;
import com.app.beans.InvestmentDetailsBean;
import com.app.beans.ResponseBean;
import com.app.module.master.service.IBusinessUnitService;
import com.app.module.master.service.IInvestmentdetailsService;
import com.app.util.GenericConstant;

@RestController
@RequestMapping(value="/investment/investmentdetails")
public class InvestmentDetailsController {
	
	@Autowired
	IInvestmentdetailsService investmentdetailsService;
	
	@Autowired
	IBusinessUnitService businessUnitService;
	
	@GetMapping(value = "/addInvestmentDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showInvestmentDetails() {
		ModelAndView mv = new ModelAndView();
		List<BusinessUnitBean> businessUnitList = businessUnitService.displayAllBusinessUnits();
		mv.addObject("businessUnits", businessUnitList);
		mv.setViewName("/addInvestmentDetails");
		return mv;
	}
	
	@GetMapping(value = "/showInvestmentDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView viewPurchaseItem() {
		ModelAndView mv=new ModelAndView();
        mv.setViewName("/showInvestment");
		return mv;
	}
	
	@PostMapping(value="/insertInvestmentDetails",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertInvestmentDetails(@RequestBody InvestmentDetailsBean investmentDetailsBean){
		return investmentdetailsService.insertInvestmentdetails(investmentDetailsBean)? new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.SUCCESS).status(true)
				.messageDescription(GenericConstant.INSERT_SUCCESS).build(), HttpStatus.CREATED)
		: new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(false).build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/displayAllInvestmentDetails",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>displayAllInvestmentDetails(){
		try {
			return new ResponseEntity<Object>(ResponseBean.builder().data(investmentdetailsService.displayAllInvestmentDetails()).status(true)
					.message(GenericConstant.SUCCESS).build(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			  return new ResponseEntity<Object>(ResponseBean.builder().status(false) .message(GenericConstant.FAIL).build(),
			  HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
