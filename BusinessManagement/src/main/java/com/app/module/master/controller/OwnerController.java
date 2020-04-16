package com.app.module.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.beans.OwnerBean;
import com.app.beans.ResponseBean;
import com.app.module.master.service.IOwnerService;
import com.app.util.GenericConstant;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/master/owner")
public class OwnerController {

	@Autowired
	IOwnerService ownerService;

	 @ApiOperation(value = "Insert Owner Details", response = ResponseBean.class)
		@ApiResponses(value = {
		    @ApiResponse(code = 201, message = "Success"),
		    @ApiResponse(code = 500, message = "Internal Server error")
		})
	@PostMapping(value = "/insertOwner", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertOwner(@RequestBody OwnerBean ownerRequestBean) {
		return ownerService.insertOrUpdateOwner(ownerRequestBean)
				? new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.SUCCESS).status(true).messageDescription(GenericConstant.INSERT_SUCCESS).build(),
						HttpStatus.CREATED)
				: new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(false),
						HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value = "/updateOwner", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateOwner(@RequestBody OwnerBean ownerRequestBean) {
	return ownerService.insertOrUpdateOwner(ownerRequestBean)
				? new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.SUCCESS).status(true).messageDescription(GenericConstant.UPDATE_SUCCESS),
						HttpStatus.CREATED)
				: new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(false).build(),
						HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/displayAllOwners")
	public ResponseEntity <Object>DisplayAllOwners(){
		try {
		return new ResponseEntity<Object>(ResponseBean.builder().data(ownerService.displayAllOwners()).status(true).message(GenericConstant.SUCCESS).build(),HttpStatus.ACCEPTED);	
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(ResponseBean.builder().data(ownerService.displayAllOwners()).status(false).message(GenericConstant.FAIL).build(),HttpStatus.INTERNAL_SERVER_ERROR);		
		}	
	}
}
