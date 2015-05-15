package com.miller.raptcha.controller.impl;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.miller.raptcha.controller.VerificationController;
import com.miller.raptcha.domain.VerificationObject;
import com.miller.raptcha.imaging.ImageService;


@Component
public class VerificationControllerImpl implements VerificationController {

	@Autowired
	private ImageService imageService;
	
	@Override
	public HttpEntity<VerificationObject> getVerificationObject() {
		VerificationObject verificationObject = new VerificationObject();
		verificationObject.add(linkTo(methodOn(VerificationController.class)));
		return new ResponseEntity<VerificationObject>(logEvent, HttpStatus.OK);
	}

}
