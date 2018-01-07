package com.ril.ipdr.rest.enums;

public enum IpdrCommonCodes {
	IPDR_MSISDN("MSISDN"), IPDR_IMEI("IMEI"), IPDR_IMSI("IMSI"), IPDR_PUBLIC_IP("PUBLIC_IP"), IPDR_HBASE_TABLE_CRM(
			"CRM_DTLS"), IPDR_HBASE_TABLE_PGW_CGNAT(
					"PGW_CGNAT"), IPDR_HBASE_TABLE_PGW_CGNAT_TEMP("PGW_CGNAT_TEMP"), IPDR_HBASE_TABLE_AAA_CGNAT(
							"AAA_CGNAT"), IPDR_HBASE_TABLE_CRM_1("CRM_DTLS1"), IPDR_HBASE_TABLE_PGW_CGNAT_1(
									"PGW_CGNAT1"), IPDR_HBASE_TABLE_AAA_CGNAT_1("AAA_CGNAT1"), IPDR_USER_ID("UID"),;

	private String value;

	private IpdrCommonCodes(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
