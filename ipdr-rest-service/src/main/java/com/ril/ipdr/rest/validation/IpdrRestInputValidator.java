package com.ril.ipdr.rest.validation;

import org.jivesoftware.smack.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ril.ipdr.rest.enums.CircleID;
import com.ril.ipdr.rest.enums.IpdrCommonCodes;
import com.ril.ipdr.rest.exceptions.IpdrRestException;
import com.ril.ipdr.rest.utils.IpdrRestRequest;

public class IpdrRestInputValidator extends IpdrRestBaseValidator {
	private final static Logger LOG = LoggerFactory.getLogger(IpdrRestInputValidator.class);

	public static boolean validateReqInputs(IpdrRestRequest inputs) throws IpdrRestException {
		boolean isValid = Boolean.TRUE;
		if (StringUtils.isNullOrEmpty(inputs.getCircleId()) && StringUtils.isNullOrEmpty(inputs.getStartDate())
				&& StringUtils.isNullOrEmpty(inputs.getEndDate())) {
			LOG.error("Invalid Inputs. Circle ID, Start Date and End Date is mandatory!!!");
			throw new IpdrRestException("Invalid Inputs. Circle ID, Start Date and End Date are mandatory.");
		}
		// Validation - CircleID
		if (!validateCircleId(inputs.getCircleId())) {
			LOG.error("Invalid Circle ID");
			throw new IpdrRestException("Invalid Circle ID.");
		}

		// Date Validations - Start Date & EndDate
		if (!validateDate(inputs.getStartDate())) {
			LOG.error("Invalid Date format. Param  : Start Date");
			throw new IpdrRestException("Invalid Start Date.");
		}
		if (!validateDate(inputs.getEndDate())) {
			LOG.error("Invalid Date format. Param  : Start Date");
			throw new IpdrRestException("Invalid End Date.");
		}
		if (!validateParamType(inputs.getParamType())) {
			LOG.error("Invalid Param Type. The Param type should be MSISDN / IMEI / IMSI / PUBLIC_IP.");
			throw new IpdrRestException(
					"Invalid Param Type. The Param type should be MSISDN / IMEI / IMSI / PUBLIC_IP.");
		}
		return isValid;
	}

	private static boolean validateParamType(String paramType) {
		return (IpdrCommonCodes.IPDR_MSISDN.getValue().equalsIgnoreCase(paramType))
				|| (IpdrCommonCodes.IPDR_IMEI.getValue().equalsIgnoreCase(paramType))
				|| (IpdrCommonCodes.IPDR_IMSI.getValue().equalsIgnoreCase(paramType))
				|| (IpdrCommonCodes.IPDR_PUBLIC_IP.getValue().equalsIgnoreCase(paramType))
				|| (IpdrCommonCodes.IPDR_USER_ID.getValue().equalsIgnoreCase(paramType)) ? true : false;
	}

	private static boolean validateCircleId(String circleId) {
		return (!StringUtils.isNullOrEmpty(CircleID.getCircleId(circleId))) ? true : false;
	}

}
