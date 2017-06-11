package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.OutputRows.DotKhuyenMaiOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.DotKhuyenMaiDAO;
import com.sms.form.DotKhuyenMaiForm;
import com.sms.formRows.DotKhuyenMaiRowForm;
import com.sms.input.DotKhuyenMaiInputBean;

@Controller
public class dotKhuyenMaiController {

	public static final String DOTKHUYENMAI = "dotKhuyenMai.jsp";
	
	@RequestMapping(value  = "/dotKhuyenMai/init")
	public String init(@ModelAttribute("DotKhuyenMaiForm") DotKhuyenMaiForm form, HttpSession session){
		String pathJSP = "cuahangthoitrang";
		//reset
		form.setMaDKM("");
		form.setTenDKM("");
		form.setMucKM("");
		form.setMucGiamGia("");
		form.setNgayKT("");
		form.setDk_tongHD("");
		form.setDk_tongSL("");
		form.setLoaiKM("");
		form.setDk_loaiThe("");
		form.setDonViKM("");
		//Flag update
		form.setUpdateFlag("");
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", DOTKHUYENMAI);
		return  SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * 
	 * @param form
	 * @param pathJSP
	 */
	
	private void initData(DotKhuyenMaiForm form, String pathJSP){
		//Loai KM
		form.getLst_loaiKM().put("01", "--- Chọn loại khuyến mãi ---");
		form.getLst_loaiKM().put("01", "Theo phần trăm sản phẩm");
		form.getLst_loaiKM().put("02", "Theo phần trăm hóa đơn");
		form.getLst_loaiKM().put("03", "Tặng kèm sản phầm");
		form.getLst_loaiKM().put("04", "Tặng phiếu giảm giá");
		form.getLst_loaiKM().put("05", "Tặng phiếu quà tặng");
		form.getLst_loaiKM().put("06", "Miễn phí ship hàng");
		
		
		// Loai The
		form.getLst_dk_loaiThe().put("00", "--- Chọn loại thẻ ---");
		form.getLst_dk_loaiThe().put("01", "Thẻ khách hàng");
		form.getLst_dk_loaiThe().put("02", "Thẻ thành viên");
		form.getLst_dk_loaiThe().put("03", "Thẻ vàng");
		form.getLst_dk_loaiThe().put("04", "Thẻ VIP");
		
		
		// Don vị KM
		form.getLst_donViKM().put("00", "--- Chọn đơn vị ---");
		form.getLst_donViKM().put("01", " % Hóa đơn");
		form.getLst_donViKM().put("02", " % Sản phẩm");
		form.getLst_donViKM().put("03", " VNĐ");
		form.getLst_donViKM().put("04", " Cái");
		
		
		
		List<DotKhuyenMaiOutputRowBean> lst = DotKhuyenMaiDAO.intances.getAll(pathJSP);
		DotKhuyenMaiRowForm formRow; 
		int cnt = 1;
		if(lst != null && lst.size() > 0){
			for(int i = 0; lst.size() > i; i++){
				DotKhuyenMaiOutputRowBean outputRowBean = lst.get(i);	
				formRow = new DotKhuyenMaiRowForm();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setMaDKM(outputRowBean.getMaDKM());
				formRow.setTenDKM(outputRowBean.getTenDKM());
				formRow.setLoaiKM(outputRowBean.getLoaiKM());
				formRow.setNgayBD(outputRowBean.getNgayBD());
				formRow.setMucGiamGia(outputRowBean.getMaDKM() + " " + outputRowBean.getDonViKM());
				formRow.setDk_loaiThe(outputRowBean.getDk_loaiThe());
				formRow.setDk_tongHD(outputRowBean.getDk_tongHD());
				formRow.setDk_tongSL(outputRowBean.getDk_tongSL());
				
				form.getLst().add(formRow);
			}
		}
		
	}
	
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	
	@RequestMapping(value ="/dotKhuyenMai/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("DotKhuyenMaiForm") DotKhuyenMaiForm form, HttpSession session) {
		//get domain
		String pathJSP = "cuahangthoitrang";
		System.out.println("form: "+form.getLst().size());
		//input
		DotKhuyenMaiInputBean inputBean = new DotKhuyenMaiInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setMaDKM("");
		inputBean.setTenDKM(form.getTenDKM());
		inputBean.setLoaiKM(form.getLoaiKM());
		inputBean.setNgayBD(form.getNgayBD());
		inputBean.setNgayKT(form.getNgayKT());
		inputBean.setMucKM(form.getMaDKM());
		inputBean.setDonViKM(form.getDonViKM());
		inputBean.setDk_loaiThe(form.getDk_loaiThe());
		inputBean.setDk_tongHD(form.getDk_tongHD());
		inputBean.setDk_tongSL(form.getDk_tongSL());

		
		//insert
		int cnt = DotKhuyenMaiDAO.intances.insert(inputBean);
		
		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", DOTKHUYENMAI);
		return  SystemCommon.ADMIN_STORE;
	}
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	
	@RequestMapping(value ="/dotKhuyenMai/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("DotKhuyenMaiForm") DotKhuyenMaiForm form, HttpSession session){
		//get domain
		String pathJSP = "cuahangthoitrang";
		
		//input
		DotKhuyenMaiInputBean inputBean = new DotKhuyenMaiInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setMaDKM(form.getMaDKM());
		inputBean.setTenDKM(form.getTenDKM());
		inputBean.setLoaiKM(form.getLoaiKM());
		inputBean.setNgayBD(form.getNgayBD());
		inputBean.setNgayKT(form.getNgayKT());
		inputBean.setMucKM(form.getMaDKM());
		inputBean.setDonViKM(form.getDonViKM());
		inputBean.setDk_loaiThe(form.getDk_loaiThe());
		inputBean.setDk_tongHD(form.getDk_tongHD());
		inputBean.setDk_tongSL(form.getDk_tongSL());
		
		//insert
		int cnt = DotKhuyenMaiDAO.intances.update(inputBean);
		
		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
			//Flag update
			form.setUpdateFlag("0");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", DOTKHUYENMAI);
		return  SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * 
	 * @param form
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/dotKhuyenMai/getById/{id}", method = RequestMethod.POST)
	public String getProductById(@ModelAttribute("DotKhuyenMaiForm") DotKhuyenMaiForm form, @PathVariable("id") String id, HttpSession session){
		//get domain
		String pathJSP = "cuahangthoitrang";
		
		DotKhuyenMaiInputBean inputBean = new DotKhuyenMaiInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setMaDKM(id);
		
		List<DotKhuyenMaiOutputRowBean> lst = DotKhuyenMaiDAO.intances.getById(inputBean);
		DotKhuyenMaiOutputRowBean DotKhuyenMaiOutputRowBean = lst.get(0);
		form.setMaDKM(DotKhuyenMaiOutputRowBean.getMaDKM());
		form.setTenDKM(DotKhuyenMaiOutputRowBean.getTenDKM());
		form.setLoaiKM(DotKhuyenMaiOutputRowBean.getLoaiKM());
		form.setNgayBD(DotKhuyenMaiOutputRowBean.getNgayBD());
		form.setNgayKT(DotKhuyenMaiOutputRowBean.getNgayKT());
		form.setMucKM(DotKhuyenMaiOutputRowBean.getMaDKM());
		form.setDonViKM(DotKhuyenMaiOutputRowBean.getDonViKM());
		form.setDk_loaiThe(DotKhuyenMaiOutputRowBean.getDk_loaiThe());
		form.setDk_tongHD(DotKhuyenMaiOutputRowBean.getDk_tongHD());
		form.setDk_tongSL(DotKhuyenMaiOutputRowBean.getDk_tongSL());
		
		//Flag update
		form.setUpdateFlag("1");
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE",DOTKHUYENMAI);
		return  SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * 
	 * @param form
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/dotKhuyenMai/delete/{id}")
	public String delete(@ModelAttribute("DotKhuyenMaiForm") DotKhuyenMaiForm form, @PathVariable("id") String id, HttpSession session){
		//get domain
		String pathJSP = "cuahangthoitrang";
		DotKhuyenMaiInputBean input = new DotKhuyenMaiInputBean();
		input.setPathJSP(pathJSP);
		input.setMaDKM(id);
		System.out.println("ahihi xóa nè " + id);
		
		//delete
		int cnt = DotKhuyenMaiDAO.intances.deleteById(input);
		
		if(cnt == 1){
			form.setMessage("Xử lý xóa thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý xóa không thành công.");
			form.setMessage("");
		}
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", DOTKHUYENMAI);
		return  SystemCommon.ADMIN_STORE;
	}
	
}
