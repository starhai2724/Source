package com.sms.inputs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageInputBean {

	private String idStore;

	private String id;

	private String path;

	private List<File> listFile = new ArrayList<>();

	public String getIdStore() {
		return idStore;
	}

	public void setIdStore(String idStore) {
		this.idStore = idStore;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<File> getListFile() {
		return listFile;
	}

	public void setListFile(List<File> listFile) {
		this.listFile = listFile;
	}

}
