package com.ril.ipdr.rest.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.security.UserGroupInformation;
import org.springframework.stereotype.Service;

import com.ril.ipdr.rest.enums.IpdrCommonCodes;
import com.ril.ipdr.rest.exceptions.IpdrRestException;
import com.ril.ipdr.rest.hbase.connection.IpdrHbaseConnectionManager;
import com.ril.ipdr.rest.hbase.domain.IpdrAaaCgNatDO;
import com.ril.ipdr.rest.hbase.domain.IpdrCrmDtlsDO;
import com.ril.ipdr.rest.hbase.domain.IpdrPgwCgNatDO;

@Service("ipdrHbaseService")
public class IpdrHbaseServiceImpl implements IpdrHbaseService {

	static Configuration conf = null;
	static {
		conf = IpdrHbaseConnectionManager.getConnection("dev");
		UserGroupInformation.setConfiguration(conf);
		try {
			UserGroupInformation.loginUserFromKeytab("scf314@TCAD.TELIA.SE","/home/scf314/scf314.keytab");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public IpdrCrmDtlsDO getCrmDtls(String rowKey) throws IpdrRestException {
		IpdrCrmDtlsDO crmDO = null;
		Result rs = null;
		HTable ipdrCrmTable = null;
		try {
			ipdrCrmTable = IpdrHbaseConnectionManager.createHtableInstance(conf,
					IpdrCommonCodes.IPDR_HBASE_TABLE_CRM.getValue());
			Get get = new Get(rowKey.getBytes());
			rs = ipdrCrmTable.get(get);
			if (rs != null) {
				crmDO = IpdrHbaseDataModel.crmDtlsDataConverter(rs);
			}
		} catch (IpdrRestException e) {
			throw new IpdrRestException("IpdrHbaseServiceImpl :: getCrmDtls:: HBase Exception::" + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ipdrCrmTable.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return crmDO;
	}

	@Override
	public IpdrPgwCgNatDO getPgwCgNatDtls(String rowKey) throws IpdrRestException {
		IpdrPgwCgNatDO pgwCgNat = null;
		Result rs = null;
		HTable ipdrCrmTable = null;
		try {
			ipdrCrmTable = IpdrHbaseConnectionManager.createHtableInstance(conf,
					IpdrCommonCodes.IPDR_HBASE_TABLE_PGW_CGNAT.getValue());
			Get get = new Get(rowKey.getBytes());
			rs = ipdrCrmTable.get(get);
			if (rs != null) {
				pgwCgNat = IpdrHbaseDataModel.pgwCgNatDataConverter(rs);
			}
		} catch (IpdrRestException e) {
			throw new IpdrRestException("IpdrHbaseServiceImpl :: getPgwCgNatDtls:: HBase Exception::" + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ipdrCrmTable.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pgwCgNat;
	}

	@Override
	public IpdrAaaCgNatDO getAaaCgNatDtls(String rowKey) throws IpdrRestException {
		IpdrAaaCgNatDO aaaCgNat = null;
		Result rs = null;
		HTable ipdrCrmTable = null;
		try {
			ipdrCrmTable = IpdrHbaseConnectionManager.createHtableInstance(conf,
					IpdrCommonCodes.IPDR_HBASE_TABLE_AAA_CGNAT.getValue());
			Get get = new Get(rowKey.getBytes());
			rs = ipdrCrmTable.get(get);
			if (rs != null) {
				aaaCgNat = IpdrHbaseDataModel.aaaCgNatDataConverter(rs);
			}
		} catch (IpdrRestException e) {
			throw new IpdrRestException("IpdrHbaseServiceImpl :: getAaaCgNatDtls:: HBase Exception::" + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ipdrCrmTable.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return aaaCgNat;
	}

	@Override
	public Set<IpdrCrmDtlsDO> getCrmDtlsByFilter(String rowKey) throws IpdrRestException {
		HTable crmTable = null;
		Set<IpdrCrmDtlsDO> crmDtlsList = null;
		ResultScanner resultScanner = null;
		try {
			crmTable = IpdrHbaseConnectionManager.createHtableInstance(conf,
					IpdrCommonCodes.IPDR_HBASE_TABLE_CRM.getValue());
			// RegexStringComparator keyRegEx = new
			// RegexStringComparator(rowKey+".");
			RowFilter rowFilter = new RowFilter(CompareFilter.CompareOp.EQUAL, new SubstringComparator(rowKey));
			Scan rowScan = new Scan();
			rowScan.setFilter(rowFilter);
			resultScanner = crmTable.getScanner(rowScan);
			Iterator<Result> results = resultScanner.iterator();
			crmDtlsList = new HashSet<IpdrCrmDtlsDO>();
			while (results.hasNext()) {
				Result result = results.next();
				if (result != null) {
					crmDtlsList.add(IpdrHbaseDataModel.crmDtlsDataConverter(result));
				}
			}
		} catch (IOException e) {
			throw new IpdrRestException(
					"IpdrHbaseServiceImpl :: getCrmDtlsByFilter:: HBase Exception::" + e.getMessage());
		} finally {
			try {
				crmTable.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return crmDtlsList;
	}

	@Override
	public Set<IpdrPgwCgNatDO> getPgwCgNatDtlsFilter(String rowKey) throws IpdrRestException {
		HTable pgwCgNatable = null;
		Set<IpdrPgwCgNatDO> cgwCgNatDtls = null;
		ResultScanner resultScanner = null;
		try {
			pgwCgNatable = IpdrHbaseConnectionManager.createHtableInstance(conf,
					IpdrCommonCodes.IPDR_HBASE_TABLE_PGW_CGNAT.getValue());
			// Setting prefix filter
			// Filter prefixFilter = new
			// PrefixFilter(Bytes.toBytes(reqInputs.getHbaseRowKey()));
			// RegexStringComparator keyRegEx = new
			// RegexStringComparator("84091700120067.");
			// RowFilter rowFilter = new
			// RowFilter(CompareFilter.CompareOp.EQUAL, new
			// SubstringComparator(reqInputs.getHbaseRowKey()));
			// RowFilter rowFilter = new
			// RowFilter(CompareFilter.CompareOp.EQUAL, keyRegEx);
			// Setting column filter
			/*
			 * SingleColumnValueFilter colFilter1 = new
			 * SingleColumnValueFilter(HBaseConstants.PGW_CGNAT_CF,
			 * HBaseConstants.PGW_CGNAT_IMI_QF, CompareOp.EQUAL,
			 * Bytes.toBytes(reqInputs.getParamValue()));
			 * SingleColumnValueFilter colFilter2 = new
			 * SingleColumnValueFilter(HBaseConstants.PGW_CGNAT_CF,
			 * HBaseConstants.PGW_CGNAT_SESSTRT_QF, CompareOp.GREATER_OR_EQUAL,
			 * Bytes.toBytes(reqInputs.getStartDate())); SingleColumnValueFilter
			 * colFilter3 = new
			 * SingleColumnValueFilter(HBaseConstants.PGW_CGNAT_CF,
			 * HBaseConstants.PGW_CGNAT_SESSTRT_QF, CompareOp.LESS_OR_EQUAL,
			 * Bytes.toBytes(reqInputs.getEndDate()));
			 */
			// FilterList filterList = new
			// FilterList(FilterList.Operator.MUST_PASS_ONE);
			// filterList.addFilter(rowFilter);
			// filterList.addFilter(colFilter1);
			// filterList.addFilter(colFilter2);
			// filterList.addFilter(colFilter3);
			// scan.setFilter(filter);
			// rowScan.setTimeRange(minStamp, maxStamp)
			// rowScan.setStartRow(Bytes.toBytes(reqInputs.getCircleId()+reqInputs.getStartDateEpoc()));
			// rowScan.setStopRow(Bytes.toBytes(reqInputs.getCircleId()+reqInputs.getEndDateEpoc()));
			Filter prefixFilter = new PrefixFilter(Bytes.toBytes(rowKey));
			Scan rowScan = new Scan();
			rowScan.setFilter(prefixFilter);
			resultScanner = pgwCgNatable.getScanner(rowScan);
			Iterator<Result> results = resultScanner.iterator();
			cgwCgNatDtls = new HashSet<IpdrPgwCgNatDO>();
			while (results.hasNext()) {
				Result result = results.next();
				if (result != null) {
					cgwCgNatDtls.add(IpdrHbaseDataModel.pgwCgNatDataConverter(result));
				}
			}
		} catch (IOException e) {
			throw new IpdrRestException(
					"IpdrHbaseServiceImpl :: getPgwCgNatDtlsFilter:: HBase Exception::" + e.getMessage());
		} finally {
			try {
				pgwCgNatable.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cgwCgNatDtls;
	}

	@Override
	public Set<IpdrAaaCgNatDO> getAaaCgNatDtlsFilter(String rowKey) throws IpdrRestException {
		HTable pgwCgNatable = null;
		Set<IpdrAaaCgNatDO> aaaCgNatDtls = null;
		ResultScanner resultScanner = null;
		try {
			pgwCgNatable = IpdrHbaseConnectionManager.createHtableInstance(conf,
					IpdrCommonCodes.IPDR_HBASE_TABLE_AAA_CGNAT.getValue());
			// RegexStringComparator keyRegEx = new
			// RegexStringComparator(rowKey);
			// RowFilter rowFilter = new
			// RowFilter(CompareFilter.CompareOp.EQUAL, keyRegEx);
			Filter prefixFilter = new PrefixFilter(Bytes.toBytes(rowKey));
			Scan rowScan = new Scan();
			rowScan.setFilter(prefixFilter);
			resultScanner = pgwCgNatable.getScanner(rowScan);
			Iterator<Result> results = resultScanner.iterator();
			aaaCgNatDtls = new HashSet<IpdrAaaCgNatDO>();
			while (results.hasNext()) {
				Result result = results.next();
				if (result != null) {
					aaaCgNatDtls.add(IpdrHbaseDataModel.aaaCgNatDataConverter(result));
				}
			}
		} catch (IOException e) {
			throw new IpdrRestException(
					"IpdrHbaseServiceImpl :: getAaaCgNatDtlsFilter:: HBase Exception::" + e.getMessage());
		} finally {
			try {
				pgwCgNatable.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return aaaCgNatDtls;
	}

	@Override
	public Set<IpdrPgwCgNatDO> getPgwCgNatDtlsMultiGets(List<String> rowKeys) throws IpdrRestException {
		HTable pgwCgNatable = null;
		Set<IpdrPgwCgNatDO> cgwCgNatDtls = null;
		try {
			pgwCgNatable = IpdrHbaseConnectionManager.createHtableInstance(conf,
					IpdrCommonCodes.IPDR_HBASE_TABLE_PGW_CGNAT.getValue());
			List<Get> queryRowList = new ArrayList<Get>();
			for (String rowKey : rowKeys) {
				queryRowList.add(new Get(rowKey.getBytes()));
			}
			Result[] results = pgwCgNatable.get(queryRowList);
			cgwCgNatDtls = new HashSet<IpdrPgwCgNatDO>();
			for (Result result : results) {
				cgwCgNatDtls.add(IpdrHbaseDataModel.pgwCgNatDataConverter(result));
			}
		} catch (IOException e) {
			throw new IpdrRestException(
					"IpdrHbaseServiceImpl :: getPgwCgNatDtlsMultiGets():: HBase Exception::" + e.getMessage());
		} finally {
			try {
				pgwCgNatable.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cgwCgNatDtls;
	}

	@Override
	public Set<IpdrAaaCgNatDO> getAaaCgNatDtlsMultiGets(List<String> rowKeys) throws IpdrRestException {
		HTable pgwCgNatable = null;
		Set<IpdrAaaCgNatDO> aaaCgNatDtls = null;
		try {
			pgwCgNatable = IpdrHbaseConnectionManager.createHtableInstance(conf,
					IpdrCommonCodes.IPDR_HBASE_TABLE_AAA_CGNAT.getValue());
			List<Get> queryRowList = new ArrayList<Get>();
			for (String rowKey : rowKeys) {
				queryRowList.add(new Get(rowKey.getBytes()));
			}
			Result[] results = pgwCgNatable.get(queryRowList);
			aaaCgNatDtls = new HashSet<IpdrAaaCgNatDO>();
			for (Result result : results) {
				aaaCgNatDtls.add(IpdrHbaseDataModel.aaaCgNatDataConverter(result));
			}
		} catch (IOException e) {
			throw new IpdrRestException(
					"IpdrHbaseServiceImpl :: getAaaCgNatDtlsMultiGets():: HBase Exception::" + e.getMessage());
		} finally {
			try {
				pgwCgNatable.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return aaaCgNatDtls;
	}

}
