package com.app.beans;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseBean {
	private String message;
	private String satusCode;
	private boolean status;
	private String errorCode;

}
