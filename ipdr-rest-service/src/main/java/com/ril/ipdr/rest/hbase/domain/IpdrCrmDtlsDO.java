package com.ril.ipdr.rest.hbase.domain;

import java.io.Serializable;
import java.util.Date;

public class IpdrCrmDtlsDO implements Serializable {


	private static final long serialVersionUID = 2195853257468874447L;
	private String altrContactNum; // HBase Column Name : ACNT
	private Date accountToDate;// HBase Column Name :ACTDT
	private String AddressLine1; // HBase Column Name :ADL1
	private String AddressLine2; // HBase Column Name :ADL2
	private String AddressLine3; // HBase Column Name :ADL3
	private String customerName; // HBase Column Name :CN
	private String contactNumber; // HBase Column Name :CNT
	private String circle;// HBase Column Name :CRC
	private Date dacCtDt;// HBase Column Name :DACTDT
	private String email;// HBase Column Name :EML
	private String k2;// HBase Column Name :K2
	private String macAddr;// HBase Column Name :MAC
	private String servedMmsisdn; // HBase Column Name :MSIS
	private Date recEffFromDt;// HBase Column Name :REFDT
	private Date recEffToDt;// HBase Column Name :RETDT
	private String registorNum; // HBase Column Name :RN
	private String userId;// HBase Column Name :UID

	public String getAltrContactNum() {
		return altrContactNum;
	}

	public void setAltrContactNum(String altrContactNum) {
		this.altrContactNum = altrContactNum;
	}

	public Date getAccountToDate() {
		return accountToDate;
	}

	public void setAccountToDate(Date accountToDate) {
		this.accountToDate = accountToDate;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return AddressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		AddressLine3 = addressLine3;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public Date getDacCtDt() {
		return dacCtDt;
	}

	public void setDacCtDt(Date dacCtDt) {
		this.dacCtDt = dacCtDt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getK2() {
		return k2;
	}

	public void setK2(String k2) {
		this.k2 = k2;
	}

	public String getMacAddr() {
		return macAddr;
	}

	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}

	public String getServedMmsisdn() {
		return servedMmsisdn;
	}

	public void setServedMmsisdn(String servedMmsisdn) {
		this.servedMmsisdn = servedMmsisdn;
	}

	public Date getRecEffFromDt() {
		return recEffFromDt;
	}

	public void setRecEffFromDt(Date recEffFromDt) {
		this.recEffFromDt = recEffFromDt;
	}

	public Date getRecEffToDt() {
		return recEffToDt;
	}

	public void setRecEffToDt(Date recEffToDt) {
		this.recEffToDt = recEffToDt;
	}

	public String getRegistorNum() {
		return registorNum;
	}

	public void setRegistorNum(String registorNum) {
		this.registorNum = registorNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
