package com.eglobal.ti.devoluciones.jar.exceptions;

public class AcquirerException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	private String errorMessage;
	
	public AcquirerException(String errorMessage){
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public AcquirerException(String errorCode, String errorMessage){
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
