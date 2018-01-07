package com.ril.ipdr.rest.enums;

import java.util.HashMap;
import java.util.Map;

public class CircleID {

	public static String getCircleId(String cCode) {
		Map<String, String> cIdMap = new HashMap<String, String>();
		cIdMap.put("840", "WB");
		cIdMap.put("854", "AP");
		cIdMap.put("855", "AS");
		cIdMap.put("856", "BR");
		cIdMap.put("857", "GJ");
		cIdMap.put("858", "HR");
		cIdMap.put("859", "HP");
		cIdMap.put("860", "JK");
		cIdMap.put("861", "KA");
		cIdMap.put("862", "KL");
		cIdMap.put("863", "MP");
		cIdMap.put("864", "MH");
		cIdMap.put("865", "NE");
		cIdMap.put("866", "OR");
		cIdMap.put("867", "PB");
		cIdMap.put("868", "RJ");
		cIdMap.put("869", "TN");
		cIdMap.put("870", "UW");
		cIdMap.put("871", "UE");
		cIdMap.put("872", "DL");
		cIdMap.put("873", "KO");
		cIdMap.put("874", "MU");
		return cIdMap.get(cCode);

	}

}
