package com.ril.ipdr.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ril.ipdr.rest.exceptions.IpdrErrorDetails;

/**
 * 
 * @author Narasimha Rao Kattunga
 * 
 */
public class JSONResponse {
	HeaderDTO responseMetdata;

	@JsonInclude(value = Include.NON_NULL)
	Object data;

	@JsonInclude(value = Include.NON_NULL)
	IpdrErrorDetails error;

	public HeaderDTO getResponseMetdata() {
		return responseMetdata;
	}

	public void setResponseMetdata(HeaderDTO responseMetdata) {
		this.responseMetdata = responseMetdata;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public IpdrErrorDetails getError() {
		return error;
	}

	public void setError(IpdrErrorDetails error) {
		this.error = error;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		JSONResponse that = (JSONResponse) o;
		if (data != null ? !data.equals(that.data) : that.data != null)
			return false;
		if (responseMetdata != null ? !responseMetdata.equals(that.responseMetdata) : that.responseMetdata != null)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int result = responseMetdata != null ? responseMetdata.hashCode() : 0;
		result = 31 * result + (data != null ? data.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "JSONResponse{" + "header=" + responseMetdata + ", data=" + data + '}';
	}
}
