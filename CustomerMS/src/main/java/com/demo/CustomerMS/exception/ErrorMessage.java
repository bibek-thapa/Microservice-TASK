package com.demo.CustomerMS.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class ErrorMessage {
	
	private String errorCode;
	private String message;
	int status;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yy-MM-dd hh:mm:ss")
	LocalDateTime timestamp;

	public ErrorMessage(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	
	

}
