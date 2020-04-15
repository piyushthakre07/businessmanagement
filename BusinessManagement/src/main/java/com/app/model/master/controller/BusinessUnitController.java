package com.app.model.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.beans.BusinessUnitBean;
import com.app.beans.ResponseBean;
import com.app.model.master.service.IBusinessUnitService;
import com.app.util.GenericConstant;

@RestController
@RequestMapping(value="/master/businessUnit")
public class BusinessUnitController {
	@Autowired
	IBusinessUnitService businessUnitService;
	
	@PostMapping(value = "/addBusinessUnit",produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>addBusinessUnit(@RequestBody BusinessUnitBean businessUnitBean){
		return businessUnitService.addBusinessUnit(businessUnitBean)
				? new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.SUCCESS).status(true)
						.messageDescription(GenericConstant.INSERT_SUCCESS).build(), HttpStatus.CREATED)
				: new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(false).build(),
						HttpStatus.INTERNAL_SERVER_ERROR);	
	}

}
