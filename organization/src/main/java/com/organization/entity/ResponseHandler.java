package com.organization.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class ResponseHandler {
	
//	public ResponseEntity<Object> responseBuilder
//	(String message,HttpStatus httpStatus,Object responseObject)
//	{ 
//		Map<String,Object> response=new HashMap<>();
//		response.put("message",message);
//		response.put("status", httpStatus);
//		response.put("data",responseObject);
//		return new ResponseEntity<>(response, httpStatus);
//	}
	private Map<String,Object> response=new HashMap<>();
	private String message;
	private int statusCode;
	private int errorCode;

}
