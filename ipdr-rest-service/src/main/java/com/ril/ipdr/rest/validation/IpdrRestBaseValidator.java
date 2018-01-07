package com.ril.ipdr.rest.validation;

import java.util.regex.Pattern;

public class IpdrRestBaseValidator {
	public static boolean validateDate(String inputDate) {
		return (Pattern.matches(
				"((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) ([2][0-3]|[0-1][0-9]|[1-9]):[0-5][0-9]:([0-5][0-9]|[6][0])$",
				inputDate)) ? true : false;
	}
}
