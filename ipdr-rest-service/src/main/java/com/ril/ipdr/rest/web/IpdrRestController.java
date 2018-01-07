

package com.ril.ipdr.rest.web;

/**
 * @author Narasimha Rao Kattunga
 * IpdrRestController : Main rest controller to handle all requests
 * Return : JSONResponse
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ril.ipdr.rest.dto.JSONResponse;
import com.ril.ipdr.rest.exceptions.IpdrRestException;
import com.ril.ipdr.rest.service.IpdrRestServiceImpl;
import com.ril.ipdr.rest.utils.IpdrRestRequest;
import com.ril.ipdr.rest.utils.IpdrRestUtils;
import com.ril.ipdr.rest.utils.IpdrServiceResponse;
import com.ril.ipdr.rest.validation.IpdrRestInputValidator;

@RestController
@RequestMapping("/rest/api/v1/ipdr")
public class IpdrRestController extends BaseRestController {
	private final Logger LOG = LoggerFactory.getLogger(IpdrRestController.class);
	@Autowired
	IpdrRestServiceImpl ipdrRestService;

	@RequestMapping(value = "/getIpdrDtls")
	public JSONResponse getIpdrDtls(@RequestParam(value = "circleId", required = true) String circleId,
			@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate,
			@RequestParam(value = "paramType", required = true) String paramType,
			@RequestParam(value = "paramValue", required = true) String paramValue) throws Exception {
		JSONResponse jsonResponse = null;
		IpdrServiceResponse data = null;
		try {
			IpdrRestRequest inputs = new IpdrRestRequest(circleId, startDate, endDate, paramType, paramValue);
			boolean isValidInputs = IpdrRestInputValidator.validateReqInputs(inputs);
			if (isValidInputs) {
				inputs.setStartDateEpoc(IpdrRestUtils.getEpocTime(startDate));
				inputs.setEndDateEpoc(IpdrRestUtils.getEpocTime(endDate));
				data = ipdrRestService.getIpdrDtls(inputs);
				jsonResponse = createJsonResponseFromService(data);
			}
		} catch (IpdrRestException e) {
			LOG.error("IpdrRestController ::getIpdrDtls:", e);
			jsonResponse = setFailureJsonResponse(e.getMessage(), null);
		} catch (Exception e) {
			LOG.error("IpdrRestController ::getIpdrDtls:", e);
			jsonResponse = setFailureJsonResponse(e.getMessage(), null);
		}
		return jsonResponse;
	}

}
