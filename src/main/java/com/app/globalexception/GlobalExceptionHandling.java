package com.app.globalexception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandling {

	/**************************************************************************************
     * Handles NotFoundException and returns a ResponseEntity with a BAD_REQUEST status and the exception message.
     *
     * @param ex The NotFoundException to handle.
     * @return ResponseEntity with a BAD_REQUEST status and the exception message.
     **************************************************************************************/
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=NotFoundException.class)
	public ResponseEntity<String> handleIllegalArgumentException(NotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	/**************************************************************************************
     * Handles MethodArgumentNotValidException and returns a ResponseEntity with a BAD_REQUEST
     * status and a map containing field errors and their corresponding error messages.
     *
     * @param ex The MethodArgumentNotValidException to handle.
     * @return ResponseEntity with a BAD_REQUEST status and a map of field errors.
     **************************************************************************************/
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleInvalidException(MethodArgumentNotValidException ex)
	{
		Map<String, String> errormap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->
		{
			errormap.put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<>(errormap,HttpStatus.BAD_REQUEST);
	}
}
