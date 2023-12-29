package com.example.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class InternalServerException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final HttpStatus statusCode;
	private final String error;
}

