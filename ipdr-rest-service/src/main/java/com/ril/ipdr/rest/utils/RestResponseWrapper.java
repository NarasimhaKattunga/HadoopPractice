package com.ril.ipdr.rest.utils;

import com.ril.ipdr.rest.dto.HeaderDTO;
import com.ril.ipdr.rest.dto.JSONResponse;
import com.ril.ipdr.rest.enums.ResponseCodes;

public class RestResponseWrapper {
	public JSONResponse getResponseWrapper(final ResponseCodes responseCode,
			final String msg, Object data) {
		HeaderDTO responseMetaData = new HeaderDTO();
		JSONResponse jsonResponse = new JSONResponse();
		responseMetaData.setStatus(responseCode);
		responseMetaData.setSuccess(true);
		jsonResponse.setResponseMetdata(responseMetaData);
		jsonResponse.setData(data);
		return jsonResponse;
	}
	
	public JSONResponse getResponseWrapper(final ResponseCodes responseCode,
			IpdrServiceResponse serviceResponse) {
		HeaderDTO responseMetaData = new HeaderDTO();
		JSONResponse jsonResponse = new JSONResponse();
		responseMetaData.setStatus(responseCode);
		responseMetaData.setSuccess(true);
		if (serviceResponse != null) {
			responseMetaData.setMessage(serviceResponse.getMessage());
			jsonResponse.setData(serviceResponse.getData());
			responseMetaData.setTotalRecords(serviceResponse.getTotalRecords());
		} else {
			jsonResponse.setData(null);
			responseMetaData.setTotalRecords(0);
		}
		jsonResponse.setResponseMetdata(responseMetaData);
		return jsonResponse;
	}
	public JSONResponse getFailureResponseWrapper(final ResponseCodes responseCode,
			final String msg, Object data) {
		HeaderDTO responseMetaData = new HeaderDTO();
		JSONResponse jsonResponse = new JSONResponse();
		responseMetaData.setStatus(responseCode);
		responseMetaData.setSuccess(false);
		responseMetaData.setMessage(msg);
		jsonResponse.setResponseMetdata(responseMetaData);
		jsonResponse.setData(data);
		return jsonResponse;
	}

}
