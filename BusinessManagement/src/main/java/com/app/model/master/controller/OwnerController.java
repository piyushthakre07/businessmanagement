package com.app.model.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.beans.OwnerBean;
import com.app.beans.ResponseBean;
import com.app.model.master.service.IOwnerService;

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
	public ResponseEntity insertOwner(@RequestBody OwnerBean ownerRequestBean) {
		ResponseBean responseBean = new ResponseBean();

		boolean status = ownerService.insertOrUpdateOwner(ownerRequestBean);
		if (status) {
			responseBean.setStatus(true);
			responseBean.setMessage("Success!");
			return new ResponseEntity<>(responseBean, HttpStatus.CREATED);
		} else {
			responseBean.setStatus(false);
			responseBean.setMessage("Fail!");
			return new ResponseEntity<>(responseBean, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PutMapping(value = "/updateOwner", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateOwner(@RequestBody OwnerBean ownerRequestBean) {
		ResponseBean responseBean = new ResponseBean();

		boolean status = ownerService.insertOrUpdateOwner(ownerRequestBean);
		if (status) {
			responseBean.setStatus(true);
			responseBean.setMessage("Success!");
			return new ResponseEntity<>(responseBean, HttpStatus.OK);
		} else {
			responseBean.setStatus(false);
			responseBean.setMessage("Fail!");
			return new ResponseEntity<>(responseBean, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
