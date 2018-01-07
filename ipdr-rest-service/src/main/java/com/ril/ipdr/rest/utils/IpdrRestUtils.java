package com.ril.ipdr.rest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jivesoftware.smack.util.StringUtils;

public class IpdrRestUtils {

	public static Date getDate(String strDate) {
		Date dt = null;
		try {
			if (!StringUtils.isNullOrEmpty(strDate)) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				dt = simpleDateFormat.parse(strDate);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dt;
	}

	public static long getEpocTime(String strDate) {
		long epoch = 0L;
		try {
			if (!StringUtils.isNullOrEmpty(strDate)) {
				epoch = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate).getTime() / 1000;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return epoch;
	}
}
