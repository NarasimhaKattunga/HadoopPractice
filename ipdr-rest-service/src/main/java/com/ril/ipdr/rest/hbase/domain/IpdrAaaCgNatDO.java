package com.ril.ipdr.rest.hbase.domain;

import java.io.Serializable;
import java.util.Date;

public class IpdrAaaCgNatDO implements Serializable {


	private static final long serialVersionUID = 2188565942489386518L;
	//private String rowKey;// HBase columns: Framed_ip_address+unixsecs
	private String acctSsessionId;// HBase column:acst
	private String destIpv4Addr;// HBase column:dip
	private String destPort;// HBase column:dprt
	private String eventDt;// HBase column:edt
	private String framedIpAddr;// HBase column:fip
	private String ingressvrfId;// HBase column:ingr
	private String sessionEnd;// HBase column:seend
	private String sourceIp4Addr;// HBase column:sip
	private String sprt;// HBase column:sprt
	private String services;// HBase column:srv
	private String ssn;// HBase column:ssn
	private String sessionStart;// HBase column:strt
	private String translatedIpv4Addr;// HBase column:tip
	private String translatedPort;// HBase column:tprt
	private String userId;// HBase column:uid
	private Date unixSecs;// HBase column:usec
	/*public String getRowKey() {
		return rowKey;
	}
	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}*/
	public String getAcctSsessionId() {
		return acctSsessionId;
	}
	public void setAcctSsessionId(String acctSsessionId) {
		this.acctSsessionId = acctSsessionId;
	}
	public String getDestIpv4Addr() {
		return destIpv4Addr;
	}
	public void setDestIpv4Addr(String destIpv4Addr) {
		this.destIpv4Addr = destIpv4Addr;
	}
	public String getDestPort() {
		return destPort;
	}
	public void setDestPort(String destPort) {
		this.destPort = destPort;
	}
	public String getEventDt() {
		return eventDt;
	}
	public void setEventDt(String eventDt) {
		this.eventDt = eventDt;
	}
	public String getFramedIpAddr() {
		return framedIpAddr;
	}
	public void setFramedIpAddr(String framedIpAddr) {
		this.framedIpAddr = framedIpAddr;
	}
	public String getIngressvrfId() {
		return ingressvrfId;
	}
	public void setIngressvrfId(String ingressvrfId) {
		this.ingressvrfId = ingressvrfId;
	}
	public String getSessionEnd() {
		return sessionEnd;
	}
	public void setSessionEnd(String sessionEnd) {
		this.sessionEnd = sessionEnd;
	}
	public String getSourceIp4Addr() {
		return sourceIp4Addr;
	}
	public void setSourceIp4Addr(String sourceIp4Addr) {
		this.sourceIp4Addr = sourceIp4Addr;
	}
	public String getSprt() {
		return sprt;
	}
	public void setSprt(String sprt) {
		this.sprt = sprt;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSessionStart() {
		return sessionStart;
	}
	public void setSessionStart(String sessionStart) {
		this.sessionStart = sessionStart;
	}
	public String getTranslatedIpv4Addr() {
		return translatedIpv4Addr;
	}
	public void setTranslatedIpv4Addr(String translatedIpv4Addr) {
		this.translatedIpv4Addr = translatedIpv4Addr;
	}
	public String getTranslatedPort() {
		return translatedPort;
	}
	public void setTranslatedPort(String translatedPort) {
		this.translatedPort = translatedPort;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getUnixSecs() {
		return unixSecs;
	}
	public void setUnixSecs(Date unixSecs) {
		this.unixSecs = unixSecs;
	}

	

}