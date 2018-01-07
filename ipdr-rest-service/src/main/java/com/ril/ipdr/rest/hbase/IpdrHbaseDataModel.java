package com.ril.ipdr.rest.hbase;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ril.ipdr.rest.exceptions.IpdrRestException;
import com.ril.ipdr.rest.hbase.domain.IpdrAaaCgNatDO;
import com.ril.ipdr.rest.hbase.domain.IpdrCrmDtlsDO;
import com.ril.ipdr.rest.hbase.domain.IpdrPgwCgNatDO;
import com.ril.ipdr.rest.utils.IpdrRestUtils;

public class IpdrHbaseDataModel {
	private final static Logger logger = LoggerFactory.getLogger(IpdrHbaseDataModel.class);

	public static IpdrCrmDtlsDO crmDtlsDataConverter(Result rs) throws IpdrRestException {
		logger.info("IpdrHbaseDataConverter::crmDtlsDataConverter:Start");
		IpdrCrmDtlsDO crmDO = null;
		try {
			crmDO = new IpdrCrmDtlsDO();
			byte[] altrContactNum = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_ACNT_QF);
			byte[] acctDate = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_ACTDT_QF);
			byte[] addrLine1 = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_ADL1_QF);
			byte[] addrLine2 = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_ADL2_QF);
			byte[] addrLine3 = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_ADL3_QF);
			byte[] custName = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_CN_QF);
			byte[] contactNum = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_CNT_QF);
			byte[] circleId = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_CRC_QF);
			byte[] datCtDt = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_DACTDT_QF);
			byte[] email = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_EML_QF);
			byte[] k2 = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_K2_QF);
			byte[] macAddr = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_MAC_QF);
			byte[] servedMmsisdn = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_MSIS_QF);
			byte[] recEffFromDt = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_REFDT_QF);
			byte[] recEffToDt = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_RETDT_QF);
			byte[] regNo = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_RN_QF);
			byte[] userId = rs.getValue(HBaseConstants.CRM_DTLS_CF, HBaseConstants.CRM_DTLS_UID_QF);

			crmDO.setAltrContactNum(altrContactNum != null ? Bytes.toString(altrContactNum) : "");
			crmDO.setAccountToDate(acctDate != null ? IpdrRestUtils.getDate(Bytes.toString(acctDate)) : null);
			crmDO.setAddressLine1(addrLine1 != null ? Bytes.toString(addrLine1) : "");
			crmDO.setAddressLine2(addrLine2 != null ? Bytes.toString(addrLine2) : "");
			crmDO.setAddressLine3(addrLine3 != null ? Bytes.toString(addrLine3) : "");
			crmDO.setCustomerName(custName != null ? Bytes.toString(custName) : "");
			crmDO.setContactNumber(contactNum != null ? Bytes.toString(contactNum) : "");
			crmDO.setCircle(circleId != null ? Bytes.toString(circleId) : "");
			crmDO.setDacCtDt(datCtDt != null ? IpdrRestUtils.getDate(Bytes.toString(datCtDt)) : null);
			crmDO.setEmail(email != null ? Bytes.toString(email) : "");
			crmDO.setK2(k2 != null ? Bytes.toString(k2) : "");
			crmDO.setMacAddr(macAddr != null ? Bytes.toString(macAddr) : "");
			crmDO.setServedMmsisdn(servedMmsisdn != null ? Bytes.toString(servedMmsisdn) : "");
			crmDO.setRecEffFromDt(recEffFromDt != null ? IpdrRestUtils.getDate(Bytes.toString(recEffFromDt)) : null);
			crmDO.setRecEffToDt(recEffToDt != null ? IpdrRestUtils.getDate(Bytes.toString(recEffToDt)) : null);
			crmDO.setRegistorNum(regNo != null ? Bytes.toString(regNo) : "");
			crmDO.setUserId(userId != null ? Bytes.toString(userId) : "");
		} catch (Exception e) {
			logger.error("Error occurred::crmDtlsDataConverter:" + e.getMessage());
			throw new IpdrRestException(
					"IpdrHbaseDataModel :: crmDtlsDataConverter:: HBase Exception::" + e.getMessage());
		}
		logger.info("IpdrHbaseDataConverter::crmDtlsDataConverter:End");
		return crmDO;
	}

	public static IpdrPgwCgNatDO pgwCgNatDataConverter(Result rs) throws IpdrRestException {

		// rowKey;// HBase Column :served_msisdn+session_start
		logger.info("IpdrHbaseDataConverter::pgwCgNatDataConverter");
		IpdrPgwCgNatDO pgwCgNatDO = null;
		try {
			pgwCgNatDO = new IpdrPgwCgNatDO();

			byte[] cgiId = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_CGIID_QF);
			byte[] firstCellId = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_CID_QF);
			byte[] destIpv4Addr = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_DIP_QF);
			byte[] destPort = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_DPRT_QF);
			byte[] duration = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_DR_QF);
			byte[] ingressvrfId = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_IID_QF);
			byte[] imei = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_IMI_QF);
			byte[] servedImsi = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_IMSI_QF);
			byte[] servedIpv4Addr = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_IP4_QF);
			byte[] servedIpv6Addr = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_IP6_QF);
			byte[] servedMsisdn = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_MSDN_QF);
			byte[] pgwAddr = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_PGA_QF);
			byte[] sessionEnd = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_SESEND_QF);
			byte[] sessionStart = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_SESSTRT_QF);
			byte[] sourcePort = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_SPRT_QF);
			byte[] transedIpv4Addr = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_TIP_QF);
			byte[] unixSecs = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_TM_QF);
			byte[] translatedPort = rs.getValue(HBaseConstants.PGW_CGNAT_CF, HBaseConstants.PGW_CGNAT_TPRT_QF);

			pgwCgNatDO.setCgiId(cgiId != null ? Bytes.toString(cgiId) : "");
			pgwCgNatDO.setFirstCellId(firstCellId != null ? Bytes.toString(firstCellId) : "");
			pgwCgNatDO.setDestIpv4Addr(destIpv4Addr != null ? Bytes.toString(destIpv4Addr) : "");
			pgwCgNatDO.setDestPort(destPort != null ? Bytes.toString(destPort) : "");
			pgwCgNatDO.setDuration(duration != null ? Bytes.toString(duration) : "");
			pgwCgNatDO.setIngressvrfId(ingressvrfId != null ? Bytes.toString(ingressvrfId) : "");
			pgwCgNatDO.setImei(imei != null ? Bytes.toString(imei) : "");
			pgwCgNatDO.setServedImsi(servedImsi != null ? Bytes.toString(servedImsi) : "");
			pgwCgNatDO.setServedIpv4Addr(servedIpv4Addr != null ? Bytes.toString(servedIpv4Addr) : "");
			pgwCgNatDO.setServedIpv6Addr(servedIpv6Addr != null ? Bytes.toString(servedIpv6Addr) : "");
			pgwCgNatDO.setServedMsisdn(servedMsisdn != null ? Bytes.toString(servedMsisdn) : "");
			pgwCgNatDO.setPgwAddr(pgwAddr != null ? Bytes.toString(pgwAddr) : "");
			pgwCgNatDO.setSessionEnd(sessionEnd != null ? IpdrRestUtils.getDate(Bytes.toString(sessionEnd)) : null);
			pgwCgNatDO
					.setSessionStart(sessionStart != null ? IpdrRestUtils.getDate(Bytes.toString(sessionStart)) : null);
			pgwCgNatDO.setSourcePort(sourcePort != null ? Bytes.toString(sourcePort) : "");
			pgwCgNatDO.setTransedIpv4Addr(transedIpv4Addr != null ? Bytes.toString(transedIpv4Addr) : "");
			pgwCgNatDO.setUnixSecs(unixSecs != null ? IpdrRestUtils.getDate(Bytes.toString(unixSecs)) : null);
			pgwCgNatDO.setTranslatedPort(translatedPort != null ? Bytes.toString(translatedPort) : "");
		} catch (Exception e) {
			logger.error("Error occurred::pgwCgNatDataConverter:End:" + e.getMessage());
			throw new IpdrRestException(
					"IpdrHbaseDataModel :: pgwCgNatDataConverter:End:: HBase Exception::" + e.getMessage());
		}
		logger.info("IpdrHbaseDataConverter::pgwCgNatDataConverter:End");
		return pgwCgNatDO;
	}

	public static IpdrAaaCgNatDO aaaCgNatDataConverter(Result rs) throws IpdrRestException {
		// rowKey;// HBase columns: Framed_ip_address+unixsecs
		logger.info("IpdrHbaseDataConverter::aaaCgNatDataConverter: Start");
		IpdrAaaCgNatDO aaaCgNatDO = null;
		try {
			aaaCgNatDO = new IpdrAaaCgNatDO();

			byte[] acctSsessionId = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_CGIID_QF);
			byte[] destIpv4Addr = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_DIP_QF);
			byte[] destPort = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_DPRT_QF);
			byte[] eventDt = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_EDT_QF);
			byte[] framedIpAddr = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_FIP_QF);
			byte[] ingressvrfId = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_INGR_QF);
			byte[] sessionEnd = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_SEEND_QF);
			byte[] sourceIp4Addr = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_SIP_QF);
			byte[] sprt = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_SPRT_QF);
			byte[] services = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_SRV_QF);
			byte[] ssn = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_SSN_QF);
			byte[] sessionStart = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_STRT_QF);
			byte[] translatedIpv4Addr = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_TIP_QF);
			byte[] translatedPort = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_TPRT_QF);
			byte[] userId = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_UID_QF);
			byte[] unixSecs = rs.getValue(HBaseConstants.AAA_CGNAT_CF, HBaseConstants.AAA_CGNAT_USEC_QF);

			aaaCgNatDO.setAcctSsessionId(acctSsessionId != null ? Bytes.toString(acctSsessionId) : "");
			aaaCgNatDO.setDestIpv4Addr(destIpv4Addr != null ? Bytes.toString(destIpv4Addr) : "");
			aaaCgNatDO.setDestPort(destPort != null ? Bytes.toString(destPort) : "");
			aaaCgNatDO.setEventDt(eventDt != null ? Bytes.toString(eventDt) : "");
			aaaCgNatDO.setFramedIpAddr(framedIpAddr != null ? Bytes.toString(framedIpAddr) : "");
			aaaCgNatDO.setIngressvrfId(ingressvrfId != null ? Bytes.toString(ingressvrfId) : "");
			aaaCgNatDO.setSessionEnd(sessionEnd != null ? Bytes.toString(sessionEnd) : "");
			aaaCgNatDO.setSourceIp4Addr(sourceIp4Addr != null ? Bytes.toString(sourceIp4Addr) : "");
			aaaCgNatDO.setSprt(sprt != null ? Bytes.toString(sprt) : "");
			aaaCgNatDO.setServices(services != null ? Bytes.toString(services) : "");
			aaaCgNatDO.setSsn(ssn != null ? Bytes.toString(ssn) : "");
			aaaCgNatDO.setSessionStart(sessionStart != null ? Bytes.toString(sessionStart) : "");
			aaaCgNatDO.setTranslatedIpv4Addr(translatedIpv4Addr != null ? Bytes.toString(translatedIpv4Addr) : "");
			aaaCgNatDO.setTranslatedPort(translatedPort != null ? Bytes.toString(translatedPort) : "");
			aaaCgNatDO.setUserId(userId != null ? Bytes.toString(userId) : "");
			aaaCgNatDO.setUnixSecs(unixSecs != null ? IpdrRestUtils.getDate(Bytes.toString(unixSecs)) : null);
		} catch (Exception e) {
			logger.error("Error occurred::aaaCgNatDataConverter:" + e.getMessage());
			throw new IpdrRestException(
					"IpdrHbaseDataModel :: aaaCgNatDataConverter:: HBase Exception::" + e.getMessage());
		}
		logger.info("IpdrHbaseDataConverter::aaaCgNatDataConverter");
		return aaaCgNatDO;
	}
}
