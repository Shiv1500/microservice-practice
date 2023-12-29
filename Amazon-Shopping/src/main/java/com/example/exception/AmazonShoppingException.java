package com.example.exception;

import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class AmazonShoppingException {

	@ExceptionHandler(InternalServerException.class)
	public ResponseEntity<ErrorResponse> internalServerException(InternalServerException ise) {
		ErrorResponse errorResponse = new ErrorResponse();
		log.error("Amazon-Shopping Internal Server Exception handling statusCode:{} message:{} toString:{}",
				ise.getStatusCode(),ise.getError(),ise.toString());

		errorResponse.setCode("amazon-shopping.application.internalError");
		errorResponse.setMessage("Internal Server Error");
		errorResponse.setTrackingId(MDC.get("transactionId"));

		return new ResponseEntity<ErrorResponse>(errorResponse,ise.getStatusCode());

	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse>  badRequestException(BadRequestException bre){
		ErrorResponse errorResponse = new ErrorResponse();
		log.error("Amazon-Shopping BadRequest Exception handling statusCode:{} message:{} toString:{}",
				bre.getStatusCode(),bre.getError(),bre.toString());

		errorResponse.setCode("amazon-shopping.application.badrequestexception");
		errorResponse.setMessage("BadRequest Exception");
		errorResponse.setTrackingId(MDC.get("transactionId"));
		return new ResponseEntity<ErrorResponse>(errorResponse,bre.getStatusCode());
	}
}
