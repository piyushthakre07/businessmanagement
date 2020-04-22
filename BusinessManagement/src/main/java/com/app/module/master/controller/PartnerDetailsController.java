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
import com.app.beans.PartnerDetailsBean;
import com.app.beans.ResponseBean;
import com.app.module.master.service.IPartnerDetailsService;
import com.app.util.GenericConstant;

@RestController
@RequestMapping("/master/partnerDetailsController")
public class PartnerDetailsController {

	@Autowired
	IPartnerDetailsService partnerDetailsService;

	@PostMapping(value = "/insertPartnerDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertLedger(@RequestBody PartnerDetailsBean partnerDetailsBean) {
		return partnerDetailsService.insertPartnerDetails(partnerDetailsBean)
				? new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.SUCCESS).status(true)
						.messageDescription(GenericConstant.INSERT_SUCCESS).build(), HttpStatus.CREATED)
				: new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(false),
						HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/displayAllPartners", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> displayAllPartners() {
		try {
			return new ResponseEntity<Object>(ResponseBean.builder().data(partnerDetailsService.displayAllPartners())
					.message(GenericConstant.SUCCESS).status(true).build(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					ResponseBean.builder().message(GenericConstant.FAIL).status(false).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
