package com.OnlineAyurvedicMedicineOrder.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value= OrderAlreadyExistsException.class)
	public ResponseEntity<String> orderAlreadyExistsException(OrderAlreadyExistsException e){
		return new ResponseEntity<String>("Order already Exists in Database..",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value= OrderDoesNotExistsException.class)
	public ResponseEntity<String> orderDoesNotExistsException(OrderDoesNotExistsException e){
		return new ResponseEntity<String>("Order does not Exists in Database..",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value= CustomerAlreadyExistsException.class)
	public ResponseEntity<String> customerAlreadyExistsException(CustomerAlreadyExistsException e){
		return new ResponseEntity<String>("Customer already Exists in Database..",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value= CustomerDoesNotExistsException.class)
	public ResponseEntity<String> customerDoesNotExistsException(CustomerDoesNotExistsException e){
		return new ResponseEntity<String>("Customer does not Exists in Database..",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=MedicineIdNullException.class)
	public ResponseEntity<String> iMedicineIdNullException(MedicineIdNullException e){
		return new ResponseEntity<String>("Id for the medicine is null.",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=MedicineIllegalCostException.class)
	public ResponseEntity<String> iMedicineIllegalCostException(MedicineIllegalCostException e){
		return new ResponseEntity<String>("Cost of the medicine must be greater than 0.0",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=MedicineIllegalMfdDateException.class)
	public ResponseEntity<String> iMedicineIllegalMfdDateException(MedicineIllegalMfdDateException e){
		return new ResponseEntity<String>("The manufacturing date of medicine is invalid.",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=NullCategoryIdException.class)
	public ResponseEntity<String> nullCategoryIdException(NullCategoryIdException e){
		return new ResponseEntity<String>("Category id of medicine is null",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value=UserAlreadyExistException.class)
	public ResponseEntity<String> userAlreadyExistException(UserAlreadyExistException userAlreadyExistException){
		return new ResponseEntity<String>("User with this id already Exist in DB.Please try again.",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=IdNotFoundToDelete.class)
	public ResponseEntity<String> idNotFoundToDelete(IdNotFoundToDelete idNotFoundToDelete){
		return new ResponseEntity<String>("User with given id is not present so can't delete",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value=UpdateNotFoundException.class)
	public ResponseEntity<String> updateNotFoundException(UpdateNotFoundException updateNotFoundException){
		return new ResponseEntity<String>("User with this id is not present so we can't update",HttpStatus.CONFLICT);
	}
}
