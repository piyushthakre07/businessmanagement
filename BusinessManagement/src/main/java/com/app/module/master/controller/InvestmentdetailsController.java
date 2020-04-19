package com.app.module.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.beans.InvestmentdetailsBean;
import com.app.module.master.service.IInvestmentdetailsService;

@RestController
@RequestMapping(value="/master/investmentdetails")
public class InvestmentdetailsController {
	
	@Autowired
	IInvestmentdetailsService investmentdetailsService;
	
	@PostMapping(value="/insertInvestmentDetails",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertInvestmentDetails(@RequestBody InvestmentdetailsBean investmentDetailsBean){
		return null;
		
	}

}
