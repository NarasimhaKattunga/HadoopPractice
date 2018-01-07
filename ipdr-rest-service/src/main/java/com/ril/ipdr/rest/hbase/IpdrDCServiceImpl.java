package com.ril.ipdr.rest.hbase;

import org.springframework.stereotype.Service;

import com.ril.ipdr.rest.exceptions.IpdrRestException;
import com.ril.ipdr.rest.utils.IpdrRestRequest;

@Service("ipdrDCService")
public class IpdrDCServiceImpl implements IpdrDCService {

	@Override
	public String getRowKeyForAaaCgNat(IpdrRestRequest inputs) throws IpdrRestException {
		// TODO Auto-generated method stub
		return "100.112.128.101455508885";
	}

	@Override
	public String getRowKeyForPgwCgNat(IpdrRestRequest inputs) throws IpdrRestException {
		// TODO Auto-generated method stub
		return "917000016001145519327135160";
	}

	@Override
	public String getRowKeyForCrmDtls(IpdrRestRequest inputs) throws IpdrRestException {
		// TODO Auto-generated method stub
		return "1437004";
	}
	@Override
	public Integer rowCount(IpdrRestRequest inputs) throws IpdrRestException {
		return 100;
	}

}
