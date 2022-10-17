package com.OnlineAyurvedicMedicineOrder.demo.exception;

public class IdNotFoundToDelete extends Exception{
	String msg;

	public IdNotFoundToDelete(String msg) {
		super();
		this.msg = msg;
	}

	public IdNotFoundToDelete() {
		super();
	}
	

}
