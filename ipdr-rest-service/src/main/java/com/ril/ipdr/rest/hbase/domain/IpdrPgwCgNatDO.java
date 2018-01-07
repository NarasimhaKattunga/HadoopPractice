package com.ril.ipdr.rest.hbase.domain;

import java.io.Serializable;
import java.util.Date;

public class IpdrPgwCgNatDO implements Serializable {


	private static final long serialVersionUID = -6503138439040358472L;
	// private String rowKey;// HBase Column :served_msisdn+session_start
	private String cgiId;// HBase Column :CGIID
	private String firstCellId;// HBase Column : CID
	private String destIpv4Addr;// HBase Column : DIP
	private String destPort;// HBase Column :DPRT
	private String duration;// HBase Column :DR
	private String ingressvrfId;// HBase Column : IID
	private String imei; // HBase Column : IMI
	private String servedImsi; // HBase Column :IMSI
	private String servedIpv4Addr; // HBase Column :IP4
	private String servedIpv6Addr;// HBase Column :IP6
	private String servedMsisdn;// HBase Column :MSDN
	private String pgwAddr;// HBase Column :PGA
	private Date sessionEnd;// HBase Column :SESEND
	private Date sessionStart;// HBase Column :SESSTRT
	private String sourcePort;// HBase Column :SPRT
	private String transedIpv4Addr;// HBase Column :TIP
	private Date unixSecs;// HBase Column :TM
	private String translatedPort;// HBase Column :TPRT
	/*
	 * public String getRowKey() { return rowKey; } public void setRowKey(String
	 * rowKey) { this.rowKey = rowKey; }
	 */

	public String getCgiId() {
		return cgiId;
	}

	public void setCgiId(String cgiId) {
		this.cgiId = cgiId;
	}

	public String getFirstCellId() {
		return firstCellId;
	}

	public void setFirstCellId(String firstCellId) {
		this.firstCellId = firstCellId;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getIngressvrfId() {
		return ingressvrfId;
	}

	public void setIngressvrfId(String ingressvrfId) {
		this.ingressvrfId = ingressvrfId;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getServedImsi() {
		return servedImsi;
	}

	public void setServedImsi(String servedImsi) {
		this.servedImsi = servedImsi;
	}

	public String getServedIpv4Addr() {
		return servedIpv4Addr;
	}

	public void setServedIpv4Addr(String servedIpv4Addr) {
		this.servedIpv4Addr = servedIpv4Addr;
	}

	public String getServedIpv6Addr() {
		return servedIpv6Addr;
	}

	public void setServedIpv6Addr(String servedIpv6Addr) {
		this.servedIpv6Addr = servedIpv6Addr;
	}

	public String getServedMsisdn() {
		return servedMsisdn;
	}

	public void setServedMsisdn(String servedMsisdn) {
		this.servedMsisdn = servedMsisdn;
	}

	public String getPgwAddr() {
		return pgwAddr;
	}

	public void setPgwAddr(String pgwAddr) {
		this.pgwAddr = pgwAddr;
	}

	public Date getSessionEnd() {
		return sessionEnd;
	}

	public void setSessionEnd(Date sessionEnd) {
		this.sessionEnd = sessionEnd;
	}

	public Date getSessionStart() {
		return sessionStart;
	}

	public void setSessionStart(Date sessionStart) {
		this.sessionStart = sessionStart;
	}

	public String getSourcePort() {
		return sourcePort;
	}

	public void setSourcePort(String sourcePort) {
		this.sourcePort = sourcePort;
	}

	public String getTransedIpv4Addr() {
		return transedIpv4Addr;
	}

	public void setTransedIpv4Addr(String transedIpv4Addr) {
		this.transedIpv4Addr = transedIpv4Addr;
	}

	public Date getUnixSecs() {
		return unixSecs;
	}

	public void setUnixSecs(Date unixSecs) {
		this.unixSecs = unixSecs;
	}

	public String getTranslatedPort() {
		return translatedPort;
	}

	public void setTranslatedPort(String translatedPort) {
		this.translatedPort = translatedPort;
	}

}
