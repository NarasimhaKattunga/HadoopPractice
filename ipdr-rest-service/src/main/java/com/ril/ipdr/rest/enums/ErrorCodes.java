package com.ril.ipdr.rest.enums;

public enum ErrorCodes {
	IPDR_ER001(101);

	private int value;

	private ErrorCodes(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
