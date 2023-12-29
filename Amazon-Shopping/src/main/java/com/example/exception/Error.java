package com.example.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Error {

	private String field;
	private String location;
	private String reason;
}
