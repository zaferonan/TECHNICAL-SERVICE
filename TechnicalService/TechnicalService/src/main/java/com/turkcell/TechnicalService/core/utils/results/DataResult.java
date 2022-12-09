package com.turkcell.TechnicalService.core.utils.results;

public class DataResult<T>  {

	
	private boolean success;
	private String message;
	private T data;

	public DataResult(T data, boolean success, String message) {		
		this.success=success;
		this.message= message;
		this.data = data;
	}

	public DataResult(T data, boolean success) {
		
		this.success=success;
		this.data = data;
	}

	public T getData() {
		
		return this.data;
	}
	
	public boolean isSuccess() {

		return this.success;
	}

	public String getMessage() {

		return this.message;
	}
}
