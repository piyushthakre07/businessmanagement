package com.app.module.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.beans.InvestmentDetailsBean;
import com.app.beans.ResponseBean;
import com.app.module.master.service.IInvestmentdetailsService;
import com.app.util.GenericConstant;

@RestController
@RequestMapping(value="/master/investmentdetails")
public class InvestmentDetailsController {
	
	@Autowired
	IInvestmentdetailsService investmentdetailsService;
	
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
			return new ResponseEntity<Object>(ResponseBean.builder().data(investmentdetailsService.displayAllInvestmentDetails()).message(GenericConstant.SUCCESS).status(true).build(),
								HttpStatus.ACCEPTED);
			 }catch(Exception e) {
				return new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(true).build(),
								HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}

}
