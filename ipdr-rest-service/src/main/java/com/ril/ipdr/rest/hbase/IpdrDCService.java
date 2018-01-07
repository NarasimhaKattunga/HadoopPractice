package com.ril.ipdr.rest.hbase;

import com.ril.ipdr.rest.exceptions.IpdrRestException;
import com.ril.ipdr.rest.utils.IpdrRestRequest;

public interface IpdrDCService {
	public String getRowKeyForAaaCgNat(IpdrRestRequest inputs) throws IpdrRestException;

	public String getRowKeyForPgwCgNat(IpdrRestRequest inputs) throws IpdrRestException;

	public String getRowKeyForCrmDtls(IpdrRestRequest inputs) throws IpdrRestException;

	public Integer rowCount(IpdrRestRequest inputs) throws IpdrRestException;
}
