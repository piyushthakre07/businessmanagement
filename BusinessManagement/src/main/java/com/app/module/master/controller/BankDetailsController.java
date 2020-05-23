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
import org.springframework.web.servlet.ModelAndView;

import com.app.beans.BankDetailsBean;
import com.app.beans.ResponseBean;
import com.app.module.master.service.impl.BankDetailsServiceImpl;
import com.app.util.GenericConstant;

@RestController
@RequestMapping("/master/bankDetails")
public class BankDetailsController {
	
	@GetMapping(value = "/showBankDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showMaterialCategory() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/BankDetails");
		return mv;
	}
	
	@Autowired
	BankDetailsServiceImpl bankDetailsService;

	@PostMapping(value = "/insertBankDetails",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertBankDetails(@RequestBody BankDetailsBean bankDetailsBean) {
		return bankDetailsService.insertBankDetails(bankDetailsBean)
				? new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.INSERT_SUCCESS).status(true).build(),
						HttpStatus.CREATED)
				: new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(true).build(),
						HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/displayAllBankDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> DisplayAllBankDetails() {
		/*
		 * try { return new
		 * ResponseEntity<Object>(ResponseBean.builder().data(bankDetailsService.
		 * displayAllBankDetails()).message(GenericConstant.SUCCESS).status(true).build(
		 * ), HttpStatus.ACCEPTED); }catch(Exception e) { return new
		 * ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).
		 * status(true).build(), HttpStatus.INTERNAL_SERVER_ERROR); }
	
		 *
		 */
		
		try {
			return new ResponseEntity<>(bankDetailsService.displayAllBankDetails(), HttpStatus.OK);
			/*
			 * return new ResponseEntity<Object>(ResponseBean.builder().data(ownerService.
			 * displayAllOwners()).status(true) .message(GenericConstant.SUCCESS).build(),
			 * HttpStatus.ACCEPTED);
			 */
		} catch (Exception e) {
			/*
			 * return new ResponseEntity<Object>(ResponseBean.builder().data(ownerService.
			 * displayAllOwners()).status(false) .message(GenericConstant.FAIL).build(),
			 * HttpStatus.INTERNAL_SERVER_ERROR);
			 * 
			 */
			return new ResponseEntity<>("Fail", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
