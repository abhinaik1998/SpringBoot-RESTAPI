package com.springboot.blog.Payload;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ErrorDetails {

	private LocalDateTime date;
	private String message;
	private String details;
	private String description;
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ErrorDetails(LocalDateTime date, String message, String details, String description) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
		this.description = description;
	}
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
