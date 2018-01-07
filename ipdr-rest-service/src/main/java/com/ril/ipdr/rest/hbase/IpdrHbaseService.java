package com.ril.ipdr.rest.hbase;

import java.util.List;
import java.util.Set;

import com.ril.ipdr.rest.exceptions.IpdrRestException;
import com.ril.ipdr.rest.hbase.domain.IpdrAaaCgNatDO;
import com.ril.ipdr.rest.hbase.domain.IpdrCrmDtlsDO;
import com.ril.ipdr.rest.hbase.domain.IpdrPgwCgNatDO;

public interface IpdrHbaseService {

	public IpdrCrmDtlsDO getCrmDtls(String rowKey) throws IpdrRestException;

	public IpdrPgwCgNatDO getPgwCgNatDtls(String rowKey) throws IpdrRestException;

	public IpdrAaaCgNatDO getAaaCgNatDtls(String rowKey) throws IpdrRestException;

	public Set<IpdrCrmDtlsDO> getCrmDtlsByFilter(String rowKey) throws IpdrRestException;

	public Set<IpdrPgwCgNatDO> getPgwCgNatDtlsFilter(String rowKey) throws IpdrRestException;

	public Set<IpdrAaaCgNatDO> getAaaCgNatDtlsFilter(String rowKey) throws IpdrRestException;

	public Set<IpdrPgwCgNatDO> getPgwCgNatDtlsMultiGets(List<String> rowKeys) throws IpdrRestException;

	public Set<IpdrAaaCgNatDO> getAaaCgNatDtlsMultiGets(List<String> rowKeys) throws IpdrRestException;
}
