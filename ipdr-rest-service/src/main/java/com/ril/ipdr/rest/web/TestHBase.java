package com.ril.ipdr.rest.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import com.ril.ipdr.rest.exceptions.IpdrRestException;
import com.ril.ipdr.rest.hbase.IpdrHbaseServiceImpl;
import com.ril.ipdr.rest.hbase.domain.IpdrCrmDtlsDO;
import com.ril.ipdr.rest.hbase.domain.IpdrPgwCgNatDO;
import com.ril.ipdr.rest.service.IpdrRestConcurrentDataModel;

public class TestHBase {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.setProperty("socksProxyHost", "127.0.0.1");
		System.setProperty("socksProxyPort", "3993");
		System.setProperty("hadoop.home.dir", "C:/winutils");

		IpdrHbaseServiceImpl service = new IpdrHbaseServiceImpl();
		try {
			IpdrCrmDtlsDO crmDO = service.getCrmDtls("1437004");
			IpdrPgwCgNatDO pgwCgNatDO = service.getPgwCgNatDtls("917000016001145519327135160");
			System.out.println(crmDO.getCircle());
			System.out.println(pgwCgNatDO.getCgiId());

			// FIlter TEst
			Set<IpdrCrmDtlsDO> crmDOs = (Set<IpdrCrmDtlsDO>) service.getCrmDtlsByFilter("1437");
			for (IpdrCrmDtlsDO crmDO11 : crmDOs) {
				System.out.println(crmDO11.getK2());
			}

			IpdrRestConcurrentDataModel model = new IpdrRestConcurrentDataModel();
			List<String> rowKeys = new ArrayList<String>();
			rowKeys.add("0359170000248501457148140");
			rowKeys.add("0359170000248501457148391");
			rowKeys.add("0359170000248501457148504");
			rowKeys.add("0359170001069301457252857");
			rowKeys.add("0359170001069301457252952");
			rowKeys.add("0359170001069301457253852");
			rowKeys.add("0359170001069301457254691");
			rowKeys.add("0359170001069301457255043");
			rowKeys.add("0359170001069301457263966");
			rowKeys.add("0359170001069301457264223");
			Set<IpdrPgwCgNatDO> result = model.patellerProcessDataModelPgwCgNat(rowKeys, rowKeys.size(), service);
			System.out.println(result.size());

		} catch (IpdrRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
