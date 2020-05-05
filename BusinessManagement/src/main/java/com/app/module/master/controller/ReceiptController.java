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

import com.app.beans.ReceiptBean;
import com.app.beans.ResponseBean;
import com.app.module.master.service.IReceiptService;
import com.app.util.GenericConstant;

@RestController
@RequestMapping(value="/master/receiptController")
public class ReceiptController {
	@Autowired
	IReceiptService receiptService;
	
	@GetMapping(value = "/showReceipt", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showReceipt() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/ReceiptMaster");
		return mv;
	}
	

	@PostMapping(value ="/insertReceipt", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertReceipt(@RequestBody ReceiptBean receiptBean) {
		return receiptService.insertReceipt(receiptBean)
				? new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.SUCCESS).status(true)
						.messageDescription(GenericConstant.INSERT_SUCCESS).build(), HttpStatus.CREATED)
				: new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(false),
						HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/displayAllReceipts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> displayAllReceipts() {
		try {
			return new ResponseEntity<Object>(ResponseBean.builder().data(receiptService.DisplayAllReceipts())
					.message(GenericConstant.SUCCESS).status(true).build(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					ResponseBean.builder().message(GenericConstant.FAIL).status(false).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
