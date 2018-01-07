package com.ril.ipdr.rest.service;

import com.ril.ipdr.rest.exceptions.IpdrRestException;
import com.ril.ipdr.rest.utils.IpdrRestRequest;
import com.ril.ipdr.rest.utils.IpdrServiceResponse;

public interface IpdrRestService {
	public IpdrServiceResponse getIpdrDtls(IpdrRestRequest reqInputs) throws IpdrRestException;
}
