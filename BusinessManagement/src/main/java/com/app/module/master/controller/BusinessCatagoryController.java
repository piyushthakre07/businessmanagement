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

import com.app.beans.BusinessCatagoryBean;
import com.app.beans.ResponseBean;
import com.app.module.master.service.impl.BusinessCatagoryServiceImpl;
import com.app.util.GenericConstant;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/master/businessCatagory")
public class BusinessCatagoryController {
	@Autowired
	BusinessCatagoryServiceImpl businessCatagoryService;

	/**
	 * @param businessCatagoryBean
	 * @return
	 */
	@ApiOperation(value = "Insert Business Catagory Api", response = ResponseBean.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	@PostMapping(value = "/insertBusinessCatagory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertBusinessCatagory(@RequestBody BusinessCatagoryBean businessCatagoryBean) {
		return businessCatagoryService.insertBusinessCatagory(businessCatagoryBean)
				? new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.SUCCESS).status(true)
						.messageDescription(GenericConstant.INSERT_SUCCESS).build(), HttpStatus.CREATED)
				: new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(false).build(),
						HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * @return
	 */
	@ApiOperation(value = "Api to display All BusinessCatagory", response = ResponseBean.class)
	@ApiResponses(value = { @ApiResponse(code = 202, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	@GetMapping(value = "/displayAllBusinessCatagory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> displayAllBusinessCatagory() {
		try {
			return new ResponseEntity<Object>(
					ResponseBean.builder().data(businessCatagoryService.displayAllBusinessCatagory())
							.message(GenericConstant.SUCCESS).status(true).build(),
					HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(false).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
