package com.miller.raptcha.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.miller.raptcha.domain.VerificationObject;

@RestController
@RequestMapping("/images/")
public interface VerificationController {

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/", method = RequestMethod.GET)
	public HttpEntity<VerificationObject> getVerificationObject();
	
	
}
