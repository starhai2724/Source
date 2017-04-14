package com.sms.output;

import java.util.ArrayList;
import java.util.List;
import com.sms.OutputRows.PathJSPOutputRowBean;

public class PathJSPOutputBean {

	private List<PathJSPOutputRowBean> lst = new ArrayList<PathJSPOutputRowBean>();

	public List<PathJSPOutputRowBean> getLst() {
		return lst;
	}

	public void setLst(List<PathJSPOutputRowBean> lst) {
		this.lst = lst;
	}

}
