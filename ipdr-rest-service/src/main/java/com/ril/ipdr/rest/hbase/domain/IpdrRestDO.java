package com.ril.ipdr.rest.hbase.domain;

import java.util.Set;

public class IpdrRestDO {
	Set<IpdrPgwCgNatDO> pgwCgNatDtls = null;
	Set<IpdrCrmDtlsDO> crmDtls = null;
	Set<IpdrAaaCgNatDO> aaaCgNatDtls = null;

	public Set<IpdrPgwCgNatDO> getPgwCgNatDtls() {
		return pgwCgNatDtls;
	}

	public void setPgwCgNatDtls(Set<IpdrPgwCgNatDO> pgwCgNatDtls) {
		this.pgwCgNatDtls = pgwCgNatDtls;
	}

	public Set<IpdrCrmDtlsDO> getCrmDtls() {
		return crmDtls;
	}

	public void setCrmDtls(Set<IpdrCrmDtlsDO> crmDtls) {
		this.crmDtls = crmDtls;
	}

	public Set<IpdrAaaCgNatDO> getAaaCgNatDtls() {
		return aaaCgNatDtls;
	}

	public void setAaaCgNatDtls(Set<IpdrAaaCgNatDO> aaaCgNatDtls) {
		this.aaaCgNatDtls = aaaCgNatDtls;
	}
}
