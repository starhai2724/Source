package com.sms.output;

import java.util.ArrayList;
import java.util.List;

import com.sms.OutputRows.ThongkeTheoKhachHangOutputRowBean;
import com.sms.OutputRows.ThongkeTheoSanPhamOutputRowBean;
import com.sms.OutputRows.ThongkeTheoThangOutputRowBean;

public class ThongkeOutputBean {
	
	private List<ThongkeTheoSanPhamOutputRowBean> lst = new ArrayList<ThongkeTheoSanPhamOutputRowBean>();
	
	private List<ThongkeTheoKhachHangOutputRowBean> thongkeTheoKhachHangOutputRowBeans = new ArrayList<>();

	private List<ThongkeTheoThangOutputRowBean> thongkeTheoThangOutputRowBeans = new ArrayList<>();
	
	
	public List<ThongkeTheoThangOutputRowBean> getThongkeTheoThangOutputRowBeans() {
		return thongkeTheoThangOutputRowBeans;
	}

	public void setThongkeTheoThangOutputRowBeans(List<ThongkeTheoThangOutputRowBean> thongkeTheoThangOutputRowBeans) {
		this.thongkeTheoThangOutputRowBeans = thongkeTheoThangOutputRowBeans;
	}

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
