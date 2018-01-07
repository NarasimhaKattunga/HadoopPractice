package com.ril.ipdr.rest.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ril.ipdr.rest.enums.IpdrCommonCodes;
import com.ril.ipdr.rest.exceptions.IpdrRestException;
import com.ril.ipdr.rest.hbase.IpdrDCServiceImpl;
import com.ril.ipdr.rest.hbase.IpdrHbaseServiceImpl;
import com.ril.ipdr.rest.hbase.domain.IpdrAaaCgNatDO;
import com.ril.ipdr.rest.hbase.domain.IpdrCrmDtlsDO;
import com.ril.ipdr.rest.hbase.domain.IpdrPgwCgNatDO;
import com.ril.ipdr.rest.hbase.domain.IpdrRestDO;
import com.ril.ipdr.rest.utils.IpdrRestRequest;
import com.ril.ipdr.rest.utils.IpdrServiceResponse;

@Service("ipdrRestService")
public class IpdrRestServiceImpl implements IpdrRestService {
	private final Logger logger = LoggerFactory.getLogger(IpdrRestServiceImpl.class);

	@Autowired
	IpdrDCServiceImpl ipdrDCService;
	@Autowired
	IpdrHbaseServiceImpl ipdrHbaseService;

	// @Cacheable(value="getIpdrDtls", key="#reqInputs")
	public IpdrServiceResponse getIpdrDtls(IpdrRestRequest reqInputs) throws IpdrRestException {
		IpdrServiceResponse response = null;
		try {
			// Single row key data model
			//response = getIpdrDataByRowKey(reqInputs);
			// Filters Data Model
			response = getIpdrDataByRowFilter(reqInputs);
			// For Concurrent Data Model - Future Enhancements 
			//response = parellerProcessDataModel(reqInputs);
		} catch (Exception e) {
			logger.error("Error occurred: IpdrRestServiceImpl:: getIpdrDtls::" + e.getMessage());
			throw new IpdrRestException(e.getMessage());
		}
		return response;
	}

	private IpdrServiceResponse getIpdrDataByRowKey(IpdrRestRequest reqInputs) throws IpdrRestException {
		IpdrServiceResponse response = new IpdrServiceResponse();
		String rowKeyAaaCgNat = ipdrDCService.getRowKeyForAaaCgNat(reqInputs);
		String rowKeyPgwCgNat = ipdrDCService.getRowKeyForPgwCgNat(reqInputs);
		String rowKeyCrmDtls = ipdrDCService.getRowKeyForCrmDtls(reqInputs);
		IpdrPgwCgNatDO cgNatDtls = ipdrHbaseService.getPgwCgNatDtls(rowKeyPgwCgNat);
		IpdrCrmDtlsDO crmDtls = ipdrHbaseService.getCrmDtls(rowKeyCrmDtls);
		IpdrAaaCgNatDO aaaCgNat = ipdrHbaseService.getAaaCgNatDtls(rowKeyAaaCgNat);
		Set<IpdrPgwCgNatDO> pgwCgNatDtls = new HashSet<IpdrPgwCgNatDO>();
		pgwCgNatDtls.add(cgNatDtls);
		Set<IpdrCrmDtlsDO> crmDtlsSet = new HashSet<IpdrCrmDtlsDO>();
		crmDtlsSet.add(crmDtls);
		Set<IpdrAaaCgNatDO> aaaCgNatDtls = new HashSet<IpdrAaaCgNatDO>();
		aaaCgNatDtls.add(aaaCgNat);

		IpdrRestDO ipdrRestDO = new IpdrRestDO();
		ipdrRestDO.setAaaCgNatDtls(aaaCgNatDtls);
		ipdrRestDO.setCrmDtls(crmDtlsSet);
		ipdrRestDO.setPgwCgNatDtls(pgwCgNatDtls);
		response.setData(ipdrRestDO);
		return response;
	}

	private IpdrServiceResponse getIpdrDataByRowFilter(IpdrRestRequest reqInputs) throws IpdrRestException {
		IpdrServiceResponse response = new IpdrServiceResponse();
		IpdrRestDO ipdrRestDO = new IpdrRestDO();
		Set<IpdrPgwCgNatDO> pgwCgNatDtls = null;
		Set<IpdrAaaCgNatDO> aaaCgNatDtls = null;
		Set<IpdrCrmDtlsDO> crmDtlsList = null;
		String baseRowKey = reqInputs.getCircleId();
		// MSISDN / IMEI / IMSI / PUBLIC_IP / user_id
		if (IpdrCommonCodes.IPDR_IMEI.getValue().equalsIgnoreCase(reqInputs.getParamType())) {
			// baseRowKey = baseRowKey + reqInputs.getStartDateEpoc();
			pgwCgNatDtls = ipdrHbaseService.getPgwCgNatDtlsFilter(baseRowKey);
			ipdrRestDO.setPgwCgNatDtls(pgwCgNatDtls);
		} else if (IpdrCommonCodes.IPDR_IMSI.getValue().equalsIgnoreCase(reqInputs.getParamType())) {
			// baseRowKey = baseRowKey + reqInputs.getStartDateEpoc();
			pgwCgNatDtls = ipdrHbaseService.getPgwCgNatDtlsFilter(baseRowKey);
			ipdrRestDO.setPgwCgNatDtls(pgwCgNatDtls);
		} else if (IpdrCommonCodes.IPDR_PUBLIC_IP.getValue().equalsIgnoreCase(reqInputs.getParamType())) {
			// baseRowKey = baseRowKey + reqInputs.getStartDateEpoc();
			pgwCgNatDtls = ipdrHbaseService.getPgwCgNatDtlsFilter(baseRowKey);
			aaaCgNatDtls = ipdrHbaseService.getAaaCgNatDtlsFilter(baseRowKey);
			ipdrRestDO.setPgwCgNatDtls(pgwCgNatDtls);
			ipdrRestDO.setAaaCgNatDtls(aaaCgNatDtls);
		} else if (IpdrCommonCodes.IPDR_MSISDN.getValue().equalsIgnoreCase(reqInputs.getParamType())) {
			pgwCgNatDtls = ipdrHbaseService.getPgwCgNatDtlsFilter(baseRowKey);
			ipdrRestDO.setPgwCgNatDtls(pgwCgNatDtls);
		} else if (IpdrCommonCodes.IPDR_USER_ID.getValue().equalsIgnoreCase(reqInputs.getParamType())) {
			// baseRowKey = baseRowKey + reqInputs.getStartDateEpoc() +
			// reqInputs.getParamValue();
			aaaCgNatDtls = ipdrHbaseService.getAaaCgNatDtlsFilter(baseRowKey);
			ipdrRestDO.setAaaCgNatDtls(aaaCgNatDtls);
		}
		// crmDtlsList =
		// ipdrHbaseService.getCrmDtlsByFilter(reqInputs.getCircleId());
		// ipdrRestDO.setCrmDtls(crmDtlsList);
		response.setData(ipdrRestDO);
		return response;
	}

	private IpdrServiceResponse parellerProcessDataModel(IpdrRestRequest reqInputs)
			throws IpdrRestException, InterruptedException, ExecutionException {
		IpdrServiceResponse response = new IpdrServiceResponse();
		IpdrRestConcurrentDataModel parellelDataProcess = new IpdrRestConcurrentDataModel();
		IpdrRestDO ipdrRestDO = new IpdrRestDO();
		Set<IpdrPgwCgNatDO> pgwCgNatDtls = null;
		Set<IpdrAaaCgNatDO> aaaCgNatDtls = null;
		// MSISDN / IMEI / IMSI / PUBLIC_IP / user_id
		if (IpdrCommonCodes.IPDR_IMEI.getValue().equalsIgnoreCase(reqInputs.getParamType())) {
			List<String> rowKeys = new ArrayList<String>(); // Proposed solution - to get it from indexing engine
			pgwCgNatDtls = parellelDataProcess.patellerProcessDataModelPgwCgNat(rowKeys, rowKeys.size(),ipdrHbaseService);
			ipdrRestDO.setPgwCgNatDtls(pgwCgNatDtls);
		} else if (IpdrCommonCodes.IPDR_IMSI.getValue().equalsIgnoreCase(reqInputs.getParamType())) {
			List<String> rowKeys = new ArrayList<String>(); // Proposed solution - to get it from indexing engine
			pgwCgNatDtls = parellelDataProcess.patellerProcessDataModelPgwCgNat(rowKeys, rowKeys.size(),ipdrHbaseService);
			ipdrRestDO.setPgwCgNatDtls(pgwCgNatDtls);
		} else if (IpdrCommonCodes.IPDR_PUBLIC_IP.getValue().equalsIgnoreCase(reqInputs.getParamType())) {
			List<String> rowKeysPgwCgNat = new ArrayList<String>(); // Proposed solution - to get it from indexing engine
			List<String> rowKeysAaaCgNat = new ArrayList<String>(); // Proposed solution - to get it from indexing engine
			pgwCgNatDtls = parellelDataProcess.patellerProcessDataModelPgwCgNat(rowKeysPgwCgNat, rowKeysPgwCgNat.size(),ipdrHbaseService);
			aaaCgNatDtls = parellelDataProcess.patellerProcessDataModelAaaCgNat(rowKeysAaaCgNat, rowKeysAaaCgNat.size(),ipdrHbaseService);
			ipdrRestDO.setPgwCgNatDtls(pgwCgNatDtls);
			ipdrRestDO.setAaaCgNatDtls(aaaCgNatDtls);
		} else if (IpdrCommonCodes.IPDR_MSISDN.getValue().equalsIgnoreCase(reqInputs.getParamType())) {
			List<String> rowKeys = new ArrayList<String>(); // Proposed solution - to get it from indexing engine
			pgwCgNatDtls = parellelDataProcess.patellerProcessDataModelPgwCgNat(rowKeys, rowKeys.size(), ipdrHbaseService);
			ipdrRestDO.setPgwCgNatDtls(pgwCgNatDtls);
		} else if (IpdrCommonCodes.IPDR_USER_ID.getValue().equalsIgnoreCase(reqInputs.getParamType())) {
			List<String> rowKeysAaaCgNat = new ArrayList<String>(); // Proposed solution - to get it from indexing engine
			aaaCgNatDtls = parellelDataProcess.patellerProcessDataModelAaaCgNat(rowKeysAaaCgNat, rowKeysAaaCgNat.size(),ipdrHbaseService);
			ipdrRestDO.setAaaCgNatDtls(aaaCgNatDtls);
		}
		response.setData(ipdrRestDO);
		return response;
	}

}
