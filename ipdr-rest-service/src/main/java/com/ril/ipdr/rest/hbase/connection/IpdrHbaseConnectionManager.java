package com.ril.ipdr.rest.hbase.connection;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
//import org.apache.hadoop.hbase.client.RowLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ril.ipdr.rest.exceptions.IpdrRestException;

public class IpdrHbaseConnectionManager {
	private final static Logger logger = LoggerFactory.getLogger(IpdrHbaseConnectionManager.class);
	private static Configuration hbaseConf = null;

	/*
	 * static { hbaseConf = HBaseConfiguration.create(); String zookeeperHost =
	 * "japhdpdpnn.rjil.ril.com,japhdpdsnn.rjil.ril.com,japhdpdyn1.rjil.ril.com"
	 * ; hbaseConf.set("hbase.master", "*" + "japhddvnn1.ril.com" + ":9000*");
	 * hbaseConf.set("hbase.zookeeper.quorum", zookeeperHost);
	 * hbaseConf.set("hbase.zookeeper.property.clientport", "2181");
	 * hbaseConf.set("zookeeper.znode.parent", "/hbase-unsecure"); }
	 */

	/*
	 * public static Configuration getConnection() { if (null == hbaseConf) {
	 * hbaseConf = HBaseConfiguration.create(); String zookeeperHost =
	 * "japhdpdpnn.rjil.ril.com,japhdpdsnn.rjil.ril.com,japhdpdyn1.rjil.ril.com";
	 * hbaseConf .set("hbase.master", "*" + "japhddvnn1.ril.com" + ":9000*");
	 * hbaseConf.set("hbase.zookeeper.quorum", zookeeperHost);
	 * hbaseConf.set("hbase.zookeeper.property.clientport", "2181");
	 * hbaseConf.set("zookeeper.znode.parent", "/hbase-unsecure"); } return
	 * hbaseConf; }
	 */

	public static Configuration getConnection(String env) {
		if (null == hbaseConf) {
			hbaseConf = HBaseConfiguration.create();
			// String zookeeperHost =
			// "japhddvdn2.ril.com,japhddvdn1.ril.com,japhddvdn3.ril.com";
			String zookeeperHost = "dl100en01-hdfs.ddc.teliasonera.net,dl100nn01-hdfs.ddc.teliasonera.net,dl100nn02-hdfs.ddc.teliasonera.net";
			hbaseConf.set("hbase.zookeeper.quorum", zookeeperHost);
			hbaseConf.set("hbase.zookeeper.property.clientport", "2181");
			hbaseConf.set("hadoop.security.authentication", "kerberos");
			hbaseConf.set("hbase.security.authentication", "kerberos");
			hbaseConf.set("hbase.master.kerberos.principal", "hbase/dl100en01-hdfs.ddc.teliasonera.net@TCAD.TELIA.SE");
			hbaseConf.set("hbase.regionserver.kerberos.principal", "hbase/dl100en01-hdfs.ddc.teliasonera.net@TCAD.TELIA.SE");
			hbaseConf.set("zookeeper.znode.parent", "/hbase");
		}
		return hbaseConf;

	}

	public static HTable createHtableInstance(Configuration conf, String tableName) {
		HTable htableInstance = null;
		try {
			htableInstance = new HTable(conf, tableName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return htableInstance;
	}

	public void close(HTable htable) throws IpdrRestException {
		try {
			htable.flushCommits();
			htable.close();
		} catch (IOException e) {
			throw new IpdrRestException(e.getMessage());
		}
	}

	public void flush(HTable htable) throws IpdrRestException {
		try {
			htable.flushCommits();
		} catch (IOException e) {
			throw new IpdrRestException(e.getMessage());
		}
	}

}
