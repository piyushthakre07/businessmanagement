package com.app.module.loan.controller;

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

import com.app.beans.LoanDetailsBean;
import com.app.beans.ResponseBean;
import com.app.module.loan.service.ILoanDetailsService;
import com.app.module.master.service.IBankDetailsService;
import com.app.module.master.service.ILedgerService;
import com.app.util.GenericConstant;

@RestController
@RequestMapping("/loan/loanDetails")
public class LoanDetailsController {

	
	@Autowired
	ILoanDetailsService loanDetailsService;
	
	@Autowired
	ILedgerService ledgerService;
	
	@Autowired
	IBankDetailsService bankDetailsService;
	
	@GetMapping(value = "/addLoneDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showLoanDetails() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ledgers", ledgerService.displayAllLedger());
		mv.addObject("bankDetails", bankDetailsService.displayAllBankDetails());
		mv.setViewName("/addLoneDetails");
		return mv;
	}
	
	@GetMapping(value = "/showLoanDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView viewLoanDetails() {
		ModelAndView mv=new ModelAndView();
        mv.setViewName("/showInvestment");
		return mv;
	}
	
	@PostMapping(value="/insertLoanDetails",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertLoanDetails(@RequestBody LoanDetailsBean loanDetailsBean){
		return loanDetailsService.insertLoanDetails(loanDetailsBean)? new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.SUCCESS).status(true)
				.messageDescription(GenericConstant.INSERT_SUCCESS).build(), HttpStatus.CREATED)
		: new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(false).build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/displayAllLoanDetails",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>displayAllLoanDetails(){
		try {
			return new ResponseEntity<Object>(ResponseBean.builder().data(loanDetailsService.displayAllLoanDetails()).status(true)
					.message(GenericConstant.SUCCESS).build(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			  return new ResponseEntity<Object>(ResponseBean.builder().status(false) .message(GenericConstant.FAIL).build(),
			  HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
