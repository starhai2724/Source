package com.sms.models;

import java.io.Serializable;

import com.sms.common.Status;

public class ResultObject implements Serializable {
	private static final long serialVersionUID = -7285677562428617585L;
	private Status status;
	private Object obj;

	public ResultObject() {
	}

	public ResultObject(Status status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the obj
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * @param obj
	 *            the obj to set
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}

}
