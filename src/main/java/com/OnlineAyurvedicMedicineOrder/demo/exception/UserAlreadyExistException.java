package com.OnlineAyurvedicMedicineOrder.demo.exception;

public class UserAlreadyExistException extends Exception{
	String msg;

	public UserAlreadyExistException(String msg) {
		super();
		this.msg = msg;
	}

	public UserAlreadyExistException() {
		super();
	}
	

}
