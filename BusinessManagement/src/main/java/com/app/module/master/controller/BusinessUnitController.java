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

import com.app.beans.BusinessUnitBean;
import com.app.beans.ResponseBean;
import com.app.module.master.service.IBusinessUnitService;
import com.app.util.GenericConstant;

@RestController
@RequestMapping(value="/master/businessUnit")
public class BusinessUnitController {
	@Autowired
	IBusinessUnitService businessUnitService;
	
	@GetMapping(value = "/showBusinessUnit", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showBusinessUnit() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/businessUnit");
		return mv;
	}
	
	
	@PostMapping(value = "/insertBusinessUnit",produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>addBusinessUnit(@RequestBody BusinessUnitBean businessUnitBean){
		return businessUnitService.insertBusinessUnit(businessUnitBean)
				? new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.SUCCESS).status(true)
						.messageDescription(GenericConstant.INSERT_SUCCESS).build(), HttpStatus.CREATED)
				: new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(false).build(),
						HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	@GetMapping(value="/displayAllBusinessUnits", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> displayAllBusinessUnit(){
		/*
		 * try { return new
		 * ResponseEntity<Object>(ResponseBean.builder().data(businessUnitService.
		 * displayAllBusinessUnits()).message(GenericConstant.SUCCESS).status(true).
		 * build(),HttpStatus.ACCEPTED); } catch (Exception e) { e.printStackTrace();
		 * return new
		 * ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).
		 * status(true),HttpStatus.INTERNAL_SERVER_ERROR); }
		 */
			
		try {
			return new ResponseEntity<>(businessUnitService.displayAllBusinessUnits(), HttpStatus.OK);
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