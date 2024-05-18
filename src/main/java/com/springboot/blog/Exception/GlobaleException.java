package com.springboot.blog.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.blog.Payload.ErrorDetails;

@ControllerAdvice
public class GlobaleException extends ResponseEntityExceptionHandler{

	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(
//			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//
//		Map<String , String > error=new HashMap<>();
//		ex.getAllErrors().stream().forEach(e->{
//			String field=((FieldError)e).getField()	;
//			String erromsg =e.getDefaultMessage();
//			error.put(field, erromsg);});
//		
//		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);
//	}
//	
	
	@ExceptionHandler(UsernotFoundException.class)
	public ResponseEntity<ErrorDetails> handleUsernotfoundException(UsernotFoundException e,
			WebRequest webRequest) {
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),e.getFieldName(),webRequest.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);

	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
//			WebRequest webRequest) {
//		
//		Map<String , String > error=new HashMap<>();
//		ex.getAllErrors().stream().forEach(e->{
//			String field=((FieldError)e).getField()	;
//			String erromsg =e.getDefaultMessage();
//			error.put(field, erromsg);});
//		
//		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);
//
//	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorDetails> handleMethodArgs(UsernotFoundException e,
			WebRequest webRequest) {
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),e.getFieldName(),webRequest.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);

	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllotherException(Exception e,
			WebRequest webRequest) {
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),((UsernotFoundException) e).getFieldName(),webRequest.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
}
