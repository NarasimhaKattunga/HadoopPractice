package com.ril.ipdr.rest.exceptions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class IpdrErrorDetails {
	@JsonInclude(Include.NON_NULL)
	private String code;
	@JsonInclude(Include.NON_NULL)
	private String message;
	
	@JsonInclude(value = Include.NON_NULL)
	private String masterUrl;
	
	private boolean isInputValid = true;
	
	@JsonInclude(Include.NON_EMPTY)
	//private Map<String, List<ValidationError>> inputErrors = new HashMap<>();
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	public String getMasterUrl() {
		return masterUrl;
	}
	public void setMasterUrl(String masterUrl) {
		this.masterUrl = masterUrl;
	}
	/*public Map<String, List<ValidationError>> getInputErrors() {
		return inputErrors;
	}
	public void setInputErrors(Map<String, List<ValidationError>> inputErrors) {
		this.inputErrors = inputErrors;
	}*/
	public boolean isInputValid() {
		return isInputValid;
	}
	public void setInputValid(boolean isInputValid) {
		this.isInputValid = isInputValid;
	}
}
