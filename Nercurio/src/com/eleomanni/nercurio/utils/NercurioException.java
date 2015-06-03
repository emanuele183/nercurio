package com.eleomanni.nercurio.utils;

public class NercurioException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3282789735287111708L;
	private String code = null;
	private String description = null;
	
	public NercurioException(String code, String description){
		this.setCode(code);
		this.setDescription(description);
	}
	
	public NercurioException(String code, String description, Exception e){
		this.setCode(code);
		//TODO truncate error descr
		//TODO check if cause or message is null
		this.setDescription(description + " - Error Message: " + e.getMessage() + " - Cause: " + e.getCause());
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
