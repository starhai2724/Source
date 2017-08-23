package com.sms.Controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.OutputRows.ThoiHanSuDungOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.ThoiHanSuDungDAO;
import com.sms.form.ThoiHanSuDungForm;
import com.sms.form.ThoiHanSuDungRowForm;
import com.sms.output.ThoiHanSuDungOutputBean;

@Controller
public class ThoiHanSuDungController {

	public static final String THOI_HAN_SD = "thoiHanSuDung.jsp";

	@RequestMapping(value = "/thoiGianSuDung/init")
	public String init(@ModelAttribute("ThoiHanSuDungForm") ThoiHanSuDungForm form, HttpSession session, Model model) {

		form.setMessage("");
		form.setMessageErr("");
		// Init data
		initData(form);
		session.setAttribute(SystemCommon.PAGE_ID, THOI_HAN_SD);
		return SystemCommon.PAGE_HOME;
	}
	
	/**
	 * 
	 * @param form
	 */
	private void initData(ThoiHanSuDungForm form){
		ThoiHanSuDungOutputBean outputBean = ThoiHanSuDungDAO.intances.getAll();
		ThoiHanSuDungRowForm rowForm;
		if (outputBean != null && outputBean.getLst().size() > 0) {
			for (ThoiHanSuDungOutputRowBean outputRowBean : outputBean.getLst()) {
				rowForm = new ThoiHanSuDungRowForm();
				rowForm.setIdStoreOnwer(outputRowBean.getIdStoreOnwer());
				rowForm.setTenCuaHang(outputRowBean.getTenCuaHang());
				rowForm.setEmail(outputRowBean.getEmail());
				rowForm.setPathJSP(outputRowBean.getPathJSP());
				rowForm.setSdt(outputRowBean.getSdt());
				rowForm.setThoiGianSuDung(SMSComons.formatDate(outputRowBean.getThoiGianSuDung()));
				form.getLst().add(rowForm);
			}
		}
	}
	/**
	 * 
	 * @param form
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/thoiGianSuDung/update/{idStore}")
	public String update(@ModelAttribute("ThoiHanSuDungForm") ThoiHanSuDungForm form, @PathVariable("idStore") String idStore, HttpSession session, Model model) {
		
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		String year  = String.valueOf(localDate.getYear());
		String month = (localDate.getMonthValue() < 10 ? String.valueOf("0"+localDate.getMonthValue()) : String.valueOf(localDate.getMonthValue()));
		String day   = (localDate.getDayOfMonth() < 10 ? String.valueOf("0"+localDate.getDayOfMonth()) : String.valueOf(localDate.getDayOfMonth()));
		
		int temp = Integer.parseInt(month);
		temp = temp + 6;
		if(temp > 12){
			temp = temp - 12;
			year = (Integer.parseInt(year) + 1)+"";
		}
		month = (temp < 10 ? String.valueOf("0"+temp) : String.valueOf(temp));
		
		String d = year + month + day;
		int cnt = ThoiHanSuDungDAO.intances.update(idStore, d);
		
		if(cnt == 1){
			form.setMessage("Gia hạn thành công.");
			form.setMessageErr("");
		}else {
			form.setMessage("");
			form.setMessageErr("Gia hạn không thành công.");
		}
		// Init data
		initData(form);
		session.setAttribute(SystemCommon.PAGE_ID, THOI_HAN_SD);
		return SystemCommon.PAGE_HOME;
	}
}
