package com.ril.ipdr.rest.enums;

public enum IpdrHbaseColumns {

	IPDR_CRM_DTLS_ALTR_CONTACT_NUM("ACNT"), IPDR_CRM_DTLS_ACC_TO_DATE("ACTDT"), IPDR_CRM_DTLS_ADDRLINE1(
			"ADL1"), IPDR_CRM_DTLS_ADDRLINE2("ADL2"), IPDR_CRM_DTLS_ADDRLINE3(
			"ADL3"), IPDR_CRM_DTLS_CUST_NAME("CN"), IPDR_CRM_DTLS_CONTACT_NUM(
			"CNT"), IPDR_CRM_DTLS_CIRCLE_ID("CRC"), IPDR_CRM_DTLS_DACTDT(
			"DACTDT"), IPDR_CRM_DTLS_EMAIL("EML"), IPDR_CRM_DTLS_K2("K2"), IPDR_CRM_DTLS_MAC_ADDR(
			"MAC"), IPDR_CRM_DTLS_SERVED_MMSISDN("MSIS"), IPDR_CRM_DTLS_REC_EFF_FROM_DATE(
			"REFDT"), IPDR_CRM_DTLS_REC_EFF_TO_DATE("RETDT"), IPDR_CRM_DTLS_REG_NUM(
			"RN"), IPDR_CRM_DTLS_USER_ID("UID")

	;

	private String column;

	private IpdrHbaseColumns(String column) {
		this.column = column;
	}

	public String getValue() {
		return this.column;
	}
}
