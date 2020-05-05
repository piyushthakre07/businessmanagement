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

import com.app.beans.LedgerBean;
import com.app.beans.ResponseBean;
import com.app.module.master.service.ILedgerService;
import com.app.util.GenericConstant;

@RestController
@RequestMapping(value = "/master/ledger")
public class LedgerController {
	@Autowired
	ILedgerService ledgerService;
	
	@GetMapping(value = "/showLedger", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showLedger() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/LedgerMaster");
		return mv;
	}

	@PostMapping(value = "/insertLedger", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertLedger(@RequestBody LedgerBean ledgerBean) {
		return ledgerService.insertLeadger(ledgerBean)
				? new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.SUCCESS).status(true)
						.messageDescription(GenericConstant.INSERT_SUCCESS).build(), HttpStatus.CREATED)
				: new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(false),
						HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/displayAllLedgers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> displayAllLedgers() {
		try {
			return new ResponseEntity<Object>(ResponseBean.builder().data(ledgerService.displayAllLedger())
					.message(GenericConstant.SUCCESS).status(true).build(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					ResponseBean.builder().message(GenericConstant.FAIL).status(false).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
