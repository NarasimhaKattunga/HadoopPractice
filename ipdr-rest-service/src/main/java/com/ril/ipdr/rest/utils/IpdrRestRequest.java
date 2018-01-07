package com.ril.ipdr.rest.utils;

import java.io.Serializable;

public class IpdrRestRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7236946894021967255L;
	private final String circleId;
	private final String startDate;
	private final String endDate;
	private final String paramType;
	private final String paramValue;
	private final String hbaseRowKey = "";
	private long startDateEpoc;
	private long endDateEpoc;

	public IpdrRestRequest(String circleId, String startDate, String endDate, String paramType, String paramValue) {
		this.circleId = circleId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.paramType = paramType;
		this.paramValue = paramValue;
	}

	public String getCircleId() {
		return circleId;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getParamType() {
		return paramType;
	}

	public String getParamValue() {
		return paramValue;
	}

	public String getHbaseRowKey() {
		return hbaseRowKey;
	}

	public long getStartDateEpoc() {
		return startDateEpoc;
	}

	public void setStartDateEpoc(long startDateEpoc) {
		this.startDateEpoc = startDateEpoc;
	}

	public long getEndDateEpoc() {
		return endDateEpoc;
	}

	public void setEndDateEpoc(long endDateEpoc) {
		this.endDateEpoc = endDateEpoc;
	}

}
