package com.springboot.blog.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsernotFoundException extends RuntimeException {

	private Long id;
	private String resourceName;

	private String fieldName;
	private String fieldValue;
	
	public UsernotFoundException(Long id,String resourceName, String fieldName) {
		super(String.format("%s id=%d   not found with %s ", resourceName,id,fieldName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
}
