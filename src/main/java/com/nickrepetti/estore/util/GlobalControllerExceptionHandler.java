package com.nickrepetti.estore.util;

import com.nickrepetti.estore.util.Error;
import com.nickrepetti.estore.util.ProductNotFoundException;
import com.nickrepetti.estore.util.UserNotFoundException;

import org.springframework.beans.TypeMismatchException;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ControllerAdvice
public class GlobalControllerExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error userNotFound(UserNotFoundException e) {
		return Error.USER_NOT_FOUND;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error productNotFound(ProductNotFoundException e) {
		return Error.PRODUCT_NOT_FOUND;
	}
	
	@ExceptionHandler(EmptyCartException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error emptyCart(EmptyCartException e) {
		return Error.EMPTY_CART;
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error typeMismatchException(Exception e) {
		return Error.INVALID_PARAMETER;
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error missingParameterException(Exception e) {
		System.out.println(e);
		return Error.MISSING_PARAMETER;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error generalException(Exception e) {
		System.out.println(e);
		return Error.GENERAL;
	}
}
