package com.OnlineAyurvedicMedicineOrder.demo.exception;

public class UpdateNotFoundException extends Exception{
	String msg;

	public UpdateNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public UpdateNotFoundException() {
		super();
	}
	

}
