package com.ril.ipdr.rest.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ril.ipdr.rest.exceptions.IpdrRestException;
import com.ril.ipdr.rest.hbase.HBaseConstants;
import com.ril.ipdr.rest.hbase.IpdrHbaseServiceImpl;
import com.ril.ipdr.rest.hbase.domain.IpdrAaaCgNatDO;
import com.ril.ipdr.rest.hbase.domain.IpdrPgwCgNatDO;

public class IpdrRestConcurrentDataModel {
	private final Logger log = LoggerFactory.getLogger(IpdrRestConcurrentDataModel.class);

	public Set<IpdrPgwCgNatDO> patellerProcessDataModelPgwCgNat(List<String> rowKeys, Integer totalRec,
			IpdrHbaseServiceImpl ipdrHbaseService) throws IpdrRestException, InterruptedException, ExecutionException {
		log.info("IpdrRestConcurrentDataModel : patellerProcessDataModelPgwCgNat: Start..");
		Set<IpdrPgwCgNatDO> pgwCgNat = new HashSet<IpdrPgwCgNatDO>();
		int n0OfWorkers = 0;
		if (totalRec > n0OfWorkers) {
			if (totalRec / HBaseConstants.HBASE_MAX_REC_PER_WORKER == 0) {
				n0OfWorkers = totalRec / HBaseConstants.HBASE_MAX_REC_PER_WORKER;
			} else {
				n0OfWorkers = totalRec / HBaseConstants.HBASE_MAX_REC_PER_WORKER + 1;
			}
		} else {
			n0OfWorkers = 1;
		}
		int startRowKeyNo = 0;
		ExecutorService threadPoolService = Executors.newFixedThreadPool(n0OfWorkers);
		for (int i = 1; i <= n0OfWorkers; i++) {
			List<String> rowKeysPerWorker = prepareRowKeys(n0OfWorkers, rowKeys, startRowKeyNo, i);
			IpdrRestPgwCgNatExecuter spExecuter = new IpdrRestPgwCgNatExecuter(rowKeysPerWorker, ipdrHbaseService);
			Future<Set<IpdrPgwCgNatDO>> pgwCgNAtListFeature = threadPoolService.submit(spExecuter);
			if (pgwCgNAtListFeature.get() != null) {
				pgwCgNat.addAll(pgwCgNAtListFeature.get());
			}
			startRowKeyNo = i * HBaseConstants.HBASE_MAX_REC_PER_WORKER;
		}
		threadPoolService.shutdown();
		log.info("IpdrRestConcurrentDataModel : patellerProcessDataModelPgwCgNat: End..");
		return pgwCgNat;
	}

	public Set<IpdrAaaCgNatDO> patellerProcessDataModelAaaCgNat(List<String> rowKeys, Integer totalRec,
			IpdrHbaseServiceImpl ipdrHbaseService) throws IpdrRestException, InterruptedException, ExecutionException {
		Set<IpdrAaaCgNatDO> aaaCgNat = new HashSet<IpdrAaaCgNatDO>();
		int n0OfWorkers = 0;
		if (totalRec > n0OfWorkers) {
			if (totalRec / HBaseConstants.HBASE_MAX_REC_PER_WORKER == 0) {
				n0OfWorkers = totalRec / HBaseConstants.HBASE_MAX_REC_PER_WORKER;
			} else {
				n0OfWorkers = totalRec / HBaseConstants.HBASE_MAX_REC_PER_WORKER + 1;
			}
		} else {
			n0OfWorkers = 1;
		}
		int startRowKeyNo = 0;
		ExecutorService threadPoolService = Executors.newFixedThreadPool(n0OfWorkers);
		for (int i = 1; i <= n0OfWorkers; i++) {
			List<String> rowKeysPerWorker = prepareRowKeys(n0OfWorkers, rowKeys, startRowKeyNo, i);
			IpdrRestAaaCgNatExecuter aaaCgNatExecuter = new IpdrRestAaaCgNatExecuter(rowKeysPerWorker,
					ipdrHbaseService);
			Future<Set<IpdrAaaCgNatDO>> aaaCgNatListFeature = threadPoolService.submit(aaaCgNatExecuter);
			if (aaaCgNatListFeature.get() != null)
				aaaCgNat.addAll(aaaCgNatListFeature.get());
		}
		return aaaCgNat;
	}

	/**
	 * 
	 * @param rowKeys
	 * @param startRowKeyNo
	 * @param i
	 * @return
	 */
	private List<String> prepareRowKeys(int n0OfWorkers, List<String> rowKeys, int startRowKeyNo, int i) {
		List<String> subListRowKeys = null;
		if (i == n0OfWorkers) {
			subListRowKeys = rowKeys.subList(startRowKeyNo, rowKeys.size());
		} else {
			subListRowKeys = rowKeys.subList(startRowKeyNo, i * HBaseConstants.HBASE_MAX_REC_PER_WORKER);
		}
		System.out.println("subListRowKeys:"+subListRowKeys);
		return subListRowKeys;
	}

	private class IpdrRestPgwCgNatExecuter implements Callable<Set<IpdrPgwCgNatDO>> {
		IpdrHbaseServiceImpl ipdrHbaseService = null;
		List<String> rowKeys = null;

		public IpdrRestPgwCgNatExecuter(List<String> rowKeys, IpdrHbaseServiceImpl ipdrHbaseService) {
			this.ipdrHbaseService = ipdrHbaseService;
			this.rowKeys = rowKeys;
		}

		@Override
		public Set<IpdrPgwCgNatDO> call() throws Exception {
			return ipdrHbaseService.getPgwCgNatDtlsMultiGets(rowKeys);
		}

	}

	private class IpdrRestAaaCgNatExecuter implements Callable<Set<IpdrAaaCgNatDO>> {
		IpdrHbaseServiceImpl ipdrHbaseService = null;
		List<String> rowKeys = null;

		public IpdrRestAaaCgNatExecuter(List<String> rowKeys, IpdrHbaseServiceImpl ipdrHbaseService) {
			this.ipdrHbaseService = ipdrHbaseService;
			this.rowKeys = rowKeys;
		}

		@Override
		public Set<IpdrAaaCgNatDO> call() throws Exception {
			return ipdrHbaseService.getAaaCgNatDtlsMultiGets(rowKeys);
		}

	}

}
