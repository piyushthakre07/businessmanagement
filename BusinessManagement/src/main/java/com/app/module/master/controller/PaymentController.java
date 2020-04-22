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
import com.app.beans.PaymentBean;
import com.app.beans.ResponseBean;
import com.app.module.master.service.IPaymentService;
import com.app.util.GenericConstant;

@RestController
@RequestMapping("/master/paymentController")
public class PaymentController {
	@Autowired
	IPaymentService PaymentService;

	@PostMapping(value = "/insertPayment", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertPayment(@RequestBody PaymentBean paymentBean) {
		return PaymentService.insertPayment(paymentBean)
				? new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.SUCCESS).status(true)
						.messageDescription(GenericConstant.INSERT_SUCCESS).build(), HttpStatus.CREATED)
				: new ResponseEntity<Object>(ResponseBean.builder().message(GenericConstant.FAIL).status(false),
						HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/displayAllPayments", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> displayAllPayments() {
		try {
			return new ResponseEntity<Object>(ResponseBean.builder().data(PaymentService.displayPayments())
					.message(GenericConstant.SUCCESS).status(true).build(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					ResponseBean.builder().message(GenericConstant.FAIL).status(false).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
