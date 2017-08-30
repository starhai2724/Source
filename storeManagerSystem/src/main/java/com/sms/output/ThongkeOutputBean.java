package com.sms.output;

import java.util.ArrayList;
import java.util.List;

import com.sms.OutputRows.ThongkeTheoKhachHangOutputRowBean;
import com.sms.OutputRows.ThongkeTheoSanPhamOutputRowBean;

public class ThongkeOutputBean {
	
	private List<ThongkeTheoSanPhamOutputRowBean> lst = new ArrayList<ThongkeTheoSanPhamOutputRowBean>();
	
	private List<ThongkeTheoKhachHangOutputRowBean> thongkeTheoKhachHangOutputRowBeans = new ArrayList<>();

	public List<ThongkeTheoSanPhamOutputRowBean> getLst() {
		return lst;
	}

	public void setLst(List<ThongkeTheoSanPhamOutputRowBean> lst) {
		this.lst = lst;
	}

	public List<ThongkeTheoKhachHangOutputRowBean> getThongkeTheoKhachHangOutputRowBeans() {
		return thongkeTheoKhachHangOutputRowBeans;
	}

	public void setThongkeTheoKhachHangOutputRowBeans(
			List<ThongkeTheoKhachHangOutputRowBean> thongkeTheoKhachHangOutputRowBeans) {
		this.thongkeTheoKhachHangOutputRowBeans = thongkeTheoKhachHangOutputRowBeans;
	}

	
}
