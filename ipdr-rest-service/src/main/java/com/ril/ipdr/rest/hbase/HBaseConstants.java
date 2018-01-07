package com.ril.ipdr.rest.hbase;

public interface HBaseConstants {

	byte[] CRM_DTLS_CF = "CRM".getBytes();
	byte[] PGW_CGNAT_CF = "V4".getBytes();
	byte[] AAA_CGNAT_CF = "AA".getBytes();

	// Qualifiers - CRM_DTLS Table
	byte[] CRM_DTLS_ACNT_QF = "ACNT".getBytes();
	byte[] CRM_DTLS_ACTDT_QF = "ACTDT".getBytes();
	byte[] CRM_DTLS_ADL1_QF = "ADL1".getBytes();
	byte[] CRM_DTLS_ADL2_QF = "ADL2".getBytes();
	byte[] CRM_DTLS_ADL3_QF = "ADL3".getBytes();
	byte[] CRM_DTLS_CN_QF = "CN".getBytes();
	byte[] CRM_DTLS_CNT_QF = "CNT".getBytes();
	byte[] CRM_DTLS_CRC_QF = "CRC".getBytes();
	byte[] CRM_DTLS_DACTDT_QF = "DACTDT".getBytes();
	byte[] CRM_DTLS_EML_QF = "EML".getBytes();
	byte[] CRM_DTLS_K2_QF = "K2".getBytes();
	byte[] CRM_DTLS_MAC_QF = "MAC".getBytes();
	byte[] CRM_DTLS_MSIS_QF = "MSIS".getBytes();
	byte[] CRM_DTLS_REFDT_QF = "REFDT".getBytes();
	byte[] CRM_DTLS_RETDT_QF = "RETDT".getBytes();
	byte[] CRM_DTLS_RN_QF = "RN".getBytes();
	byte[] CRM_DTLS_UID_QF = "UID".getBytes();

	// Qualifiers - PGW_CGNAT Table
	byte[] PGW_CGNAT_CGIID_QF = "CGIID".getBytes();
	byte[] PGW_CGNAT_CID_QF = "CID".getBytes();
	byte[] PGW_CGNAT_DIP_QF = "DIP".getBytes();
	byte[] PGW_CGNAT_DPRT_QF = "DPRT".getBytes();
	byte[] PGW_CGNAT_DR_QF = "DR".getBytes();
	byte[] PGW_CGNAT_IID_QF = "IID".getBytes();
	byte[] PGW_CGNAT_IMI_QF = "IMI".getBytes();
	byte[] PGW_CGNAT_IMSI_QF = "IMSI".getBytes();
	byte[] PGW_CGNAT_IP4_QF = "IP4".getBytes();
	byte[] PGW_CGNAT_IP6_QF = "IP6".getBytes();
	byte[] PGW_CGNAT_MSDN_QF = "MSDN".getBytes();
	byte[] PGW_CGNAT_PGA_QF = "PGA".getBytes();
	byte[] PGW_CGNAT_SESEND_QF = "SESEND".getBytes();
	byte[] PGW_CGNAT_SESSTRT_QF = "SESSTRT".getBytes();
	byte[] PGW_CGNAT_SPRT_QF = "SPRT".getBytes();
	byte[] PGW_CGNAT_TIP_QF = "TIP".getBytes();
	byte[] PGW_CGNAT_TM_QF = "TM".getBytes();
	byte[] PGW_CGNAT_TPRT_QF = "TPRT".getBytes();

	// Qualifiers - AAA_CGNAT Table
	byte[] AAA_CGNAT_CGIID_QF = "ACST".getBytes();
	byte[] AAA_CGNAT_DIP_QF = "DIP".getBytes();
	byte[] AAA_CGNAT_DPRT_QF = "DPRT".getBytes();
	byte[] AAA_CGNAT_EDT_QF = "EDT".getBytes();
	byte[] AAA_CGNAT_FIP_QF = "FIP".getBytes();
	byte[] AAA_CGNAT_INGR_QF = "INGR".getBytes();
	byte[] AAA_CGNAT_SEEND_QF = "SEEND".getBytes();
	byte[] AAA_CGNAT_SIP_QF = "SIP".getBytes();
	byte[] AAA_CGNAT_SPRT_QF = "SPRT".getBytes();
	byte[] AAA_CGNAT_SRV_QF = "SRV".getBytes();
	byte[] AAA_CGNAT_SSN_QF = "SSN".getBytes();
	byte[] AAA_CGNAT_STRT_QF = "STRT".getBytes();
	byte[] AAA_CGNAT_TIP_QF = "TIP".getBytes();
	byte[] AAA_CGNAT_TPRT_QF = "TPRT".getBytes();
	byte[] AAA_CGNAT_UID_QF = "UID".getBytes();
	byte[] AAA_CGNAT_USEC_QF = "USEC".getBytes();
	
	Integer HBAE_MIN_REC_TO_PROCESS = 10;
	Integer HBASE_MAX_REC_PER_WORKER = 50;

}
