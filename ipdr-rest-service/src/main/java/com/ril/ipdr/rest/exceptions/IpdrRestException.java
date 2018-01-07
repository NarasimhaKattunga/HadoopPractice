package com.ril.ipdr.rest.exceptions;

import com.ril.ipdr.rest.enums.ErrorCodes;
import com.ril.ipdr.rest.enums.ResponseCodes;

public class IpdrRestException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8250153122914134815L;


	private ErrorCodes errorCode;

	private Object[] messageArguments;

	private ResponseCodes responseCodes;

	/**
	 * 
	 * Creates a new instance of <code>IpdrRestException</code> without detail
	 * message.
	 * 
	 */

	public IpdrRestException() {

	}

	/**
	 * 
	 * Constructs an instance of <code>IpdrRestException</code> with the specified
	 * detail message.
	 * 
	 * @param msg
	 *            the detail message.
	 * 
	 */

	public IpdrRestException(String msg) {
		super(msg);

	}

	/**
	 * 
	 * Constructs an instance of <code>IpdrRestException</code> with the specified
	 * detail message and cause.
	 * 
	 * @param msg
	 *            the detail message.
	 * 
	 * @param cause
	 *            the cause.
	 * 
	 */

	public IpdrRestException(String msg, Throwable cause) {
		super(msg, cause);

	}

	/**
	 * 
	 * Constructs an instance of <code>NeuroException</code> with the specified
	 * detail message and cause.
	 * 
	 * @param msg
	 *            the detail message.
	 * 
	 * @param cause
	 *            the cause.
	 * 
	 *//*

	public IpdrRestException(ErrorMessagesEnum msg, Throwable cause, String localizedMessage) {

		super(localizedMessage, cause);

		setErrorMessageEnum(msg);

	}*/

	/*public IpdrRestException(ErrorMessagesEnum msg) {

		super(msg.name());

		setErrorMessageEnum(msg);

	}

	public IpdrRestException(ErrorMessagesEnum msg, ResponseCodes responseCode) {

		super(msg.name());

		setErrorMessageEnum(msg);

		setResponseCodes(responseCode);

	}*/

	/**
	 * 
	 * Constructs an instance of <code>NeuroException</code> with the specified
	 * detail message and cause.
	 * 
	 * @param msg
	 *            the detail message.
	 * 
	 * @param cause
	 *            the cause.
	 * 
	 */

	/*public IpdrRestException(ErrorCode code, ErrorMessagesEnum msg, Throwable cause, String localizedMessage) {

		super(localizedMessage, cause);

		setErrorMessageEnum(msg);

		setErrorCode(code);

	}
*/
	/*public IpdrRestException(ErrorMessagesEnum msg, String localizedMessage) {

		super(localizedMessage);

		setErrorMessageEnum(msg);

	}

	public IpdrRestException(ErrorMessagesEnum msg, Object[] messageArgs, ResponseCodes responseCodes) {

		super(msg.getKey());

		setErrorMessageEnum(msg);
		setMessageArguments(messageArgs);
		setResponseCodes(responseCodes);

	}

	*//**
	 * 
	 * Constructs an instance of <code>NeuroException</code> with the specified
	 * detail message and cause.
	 * 
	 * @param msg
	 *            the detail message.
	 * 
	 * @param cause
	 *            the cause.
	 * 
	 *//*

	public NeuroException(ErrorMessagesEnum msg, Object[] messageArgs, Throwable cause, String localizedMessage) {

		super(localizedMessage, cause);

		setErrorMessageEnum(msg);

		setMessageArguments(messageArgs);

	}

	*//**
	 * Constructs an instance of <code>NeuroException</code> with the specified
	 * detail code , message and cause.
	 * 
	 * @param code
	 * @param msg
	 * @param messageArgs
	 * @param cause
	 * @param localizedMessage
	 *//*

	public NeuroException(ErrorCode code, ErrorMessagesEnum msg, Object[] messageArgs, Throwable cause,
			String localizedMessage) {

		super(localizedMessage, cause);

		setErrorMessageEnum(msg);

		setMessageArguments(messageArgs);

	}

	*//**
	 * 
	 * Constructs an instance of <code>NeuroException</code> with the specified
	 * detail cause.
	 * 
	 * @param cause
	 *            the cause.
	 * 
	 *//*

	public NeuroException(Throwable cause) {

		super(cause);
		if (cause instanceof NeuroException) {
			setErrorMessageEnum(((NeuroException) cause).getErrorMessageEnum());
		}

	}*/

	@Override

	public String toString() {

		return getMessage();

	}

	/*public ErrorMessagesEnum getErrorMessageEnum() {

		return errorCodeEnum;

	}

	public void setErrorMessageEnum(ErrorMessagesEnum errorCodeEnum) {

		this.errorCodeEnum = errorCodeEnum;

	}*/

	public Object[] getMessageArguments() {

		return messageArguments;

	}

	public void setMessageArguments(Object[] messageArguments) {

		this.messageArguments = messageArguments;

	}

	public ErrorCodes getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCodes errorCode) {
		this.errorCode = errorCode;
	}

	public ResponseCodes getResponseCodes() {
		return responseCodes;
	}

	public void setResponseCodes(ResponseCodes responseCodes) {
		this.responseCodes = responseCodes;
	}
}
