package com.sms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SYSTEM_CONTROL")
public class SystemControl {

	@Id
	@Column(name = "PARAMETER_ID", length = 6)
	private String parameteID;

	@Column(name = "PARAMETER_TXT")
	private String parameterTXT;

	@Column(name = "PARAMETER_NAME")
	private String Name;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;

	public String getParameteID() {
		return parameteID;
	}

	public void setParameteID(String parameteID) {
		this.parameteID = parameteID;
	}

	public String getParameterTXT() {
		return parameterTXT;
	}

	public void setParameterTXT(String parameterTXT) {
		this.parameterTXT = parameterTXT;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
