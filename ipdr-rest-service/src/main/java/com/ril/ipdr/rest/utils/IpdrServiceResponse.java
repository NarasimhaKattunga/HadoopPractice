package com.ril.ipdr.rest.utils;

import java.io.Serializable;

public class IpdrServiceResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1422032532075919096L;
	private Object data;
	private long totalRecords;
	private String message;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
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
