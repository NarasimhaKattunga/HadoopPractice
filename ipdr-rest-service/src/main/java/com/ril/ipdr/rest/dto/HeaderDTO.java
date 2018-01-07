package com.ril.ipdr.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ril.ipdr.rest.enums.ResponseCodes;

public class HeaderDTO implements Serializable {

	private static final long serialVersionUID = 7425369417333570103L;

	ResponseCodes status;

	boolean isSuccess;

	@JsonInclude(value = Include.NON_DEFAULT)
	long totalRecords;

	@JsonInclude(value = Include.NON_NULL)
	String message;

	public ResponseCodes getStatus() {
		return status;
	}

	public void setStatus(ResponseCodes status) {
		this.status = status;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}