package com.ril.ipdr.rest.web;

/**
 * @author Narasimha Rao Kattunga
 *
 */
import com.ril.ipdr.rest.dto.JSONResponse;
import com.ril.ipdr.rest.enums.ResponseCodes;
import com.ril.ipdr.rest.utils.IpdrServiceResponse;
import com.ril.ipdr.rest.utils.RestResponseWrapper;

public class BaseRestController {
	protected JSONResponse createJsonResponseFromService(IpdrServiceResponse response) {
		RestResponseWrapper responseWrapper = new RestResponseWrapper();
		return responseWrapper.getResponseWrapper(ResponseCodes.OK, response);

	}

	protected JSONResponse setFailureJsonResponse(String msg, String data) {
		RestResponseWrapper responseWrapper = new RestResponseWrapper();
		return responseWrapper.getFailureResponseWrapper(ResponseCodes.NOT_FOUND_OR_IN_VALID, msg, data);

	}

}
