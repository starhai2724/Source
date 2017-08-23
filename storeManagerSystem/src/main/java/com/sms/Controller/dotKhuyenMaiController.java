package com.sms.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import com.sms.dao.LayoutDAO;
import com.sms.domain.SystemControl;
import com.sms.form.DotKhuyenMaiForm;
import com.sms.formRows.DotKhuyenMaiRowForm;
import com.sms.input.DotKhuyenMaiInputBean;

@Controller
public class dotKhuyenMaiController {

	public static final String DOTKHUYENMAI = "dotKhuyenMai.jsp";
	public static final String CHITIETDKM = "chiTietDKM.jsp";
	
	@RequestMapping(value  = "/dotKhuyenMai/init")
	public String init(@ModelAttribute("DotKhuyenMaiForm") DotKhuyenMaiForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		//reset
		form.setMaDKM("");
		form.setTenDKM("");
		form.setMucKM("");
		form.setMucGiamGia("");
		form.setNgayKT("");
		form.setNgayBD("");
		form.setDk_tongHD("");
		form.setDk_tongSL("");
		form.setLoaiKM("");
		form.setDk_loaiThe("");
		form.setDonViKM("");
		form.setMoTa("");
		//Flag update
		form.setFlagUpdate("");
		
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		
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
		form.getLst().clear();
		//Loai KM
		form.getLst_loaiKM().put("00", "Theo giá khuyến mãi có sẵn");
		form.getLst_loaiKM().put("01", "Theo phần trăm hóa đơn");
		
		// Loai The
		form.getLst_dk_loaiThe().put("00", "Thẻ thành viên");
		form.getLst_dk_loaiThe().put("01", "Thẻ khách hàng");
		form.getLst_dk_loaiThe().put("02", "Thẻ vàng");
		form.getLst_dk_loaiThe().put("03", "Thẻ VIP");
		
		
		// Don vị KM
		form.getLst_donViKM().put("00", " VNĐ");
		form.getLst_donViKM().put("01", " % Hóa đơn");
		
		List<DotKhuyenMaiOutputRowBean> lst = DotKhuyenMaiDAO.intances.getAll(pathJSP);
		DotKhuyenMaiRowForm formRow; 
		int cnt = 1;
		Map<String, String> lst_loaiKM = form.getLst_loaiKM();
		Map<String, String> lst_donViKM = form.getLst_donViKM();
		Map<String, String> lst_loaiThe = form.getLst_dk_loaiThe();
		if(lst != null && lst.size() > 0){
			for(int i = 0; lst.size() > i; i++){
				DotKhuyenMaiOutputRowBean outputRowBean = lst.get(i);	
				formRow = new DotKhuyenMaiRowForm();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setMaDKM(outputRowBean.getMaDKM());
				formRow.setTenDKM(outputRowBean.getTenDKM());
				String loaiKM = outputRowBean.getLoaiKM();
				String loaiThe = outputRowBean.getDk_loaiThe();
				
				Iterator<Entry<String, String>> its_loaiKM = lst_loaiKM.entrySet().iterator();
				while (its_loaiKM.hasNext()) {
				    Entry<String, String> it = its_loaiKM.next();
				    if(loaiKM.equals(it.getKey())){
				    	formRow.setLoaiKM(it.getValue());
				    }
				}
				
				if(loaiKM.equals("00")) formRow.setMucGiamGia(String.format("%,.2f",Double.parseDouble(outputRowBean.getMucKM())) + " VNĐ." );
				else if(loaiKM.equals("01")) formRow.setMucGiamGia(String.format("%,.2f",Double.parseDouble(outputRowBean.getMucKM())) + " % Hóa Đơn." );
				
				Iterator<Entry<String, String>> its_loaiThe = lst_loaiThe.entrySet().iterator();
				while (its_loaiThe.hasNext()) {
				    Entry<String, String> it = its_loaiThe.next();
				    if(loaiThe.equals(it.getKey())){
						formRow.setDk_loaiThe(it.getValue());
				    }
				}
				
				formRow.setNgayKT(SMSComons.formatDate(outputRowBean.getNgayKT()));
				
				formRow.setNgayBD(SMSComons.formatDate(outputRowBean.getNgayBD()));
						
				formRow.setDk_tongHD(SMSComons.formatMoney(outputRowBean.getDk_tongHD()));
				
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
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		boolean valid = true;
		if ("00".equals(form.getLoaiKM().trim())) { // gia KM có san
			if ("0".equals(form.getMucKM().trim())){
				form.setMessageErr("Trường hợp chọn giá KM có sẵn thì mức giảm giá phải là số lớn hơn 0.");
				valid = false;
			}
			
		}else{
			if ("0".equals(form.getMucKM().trim()) || Integer.parseInt(form.getMucKM().trim()) > 100) {
				form.setMessageErr("Trường hợp chọn KM theo phần trăm hóa đơn thì mức giảm giá phải là số từ 0 đến 100.");
				valid = false;
			}
		}
		
		String ngayBD = SMSComons.formatDateInput(form.getNgayBD());
		String ngayKT = SMSComons.formatDateInput(form.getNgayKT());
		
		if(SMSComons.compareDate(ngayBD,SMSComons.getDate()) < 0){
			form.setMessageErr("Hãy chọn ngày bắt đầu KM từ hôm nay trở đi.");
			form.setMessage("");
			valid = false;
		}
		if(SMSComons.compareDate(ngayBD,ngayKT) > 0){
			form.setMessageErr("Hãy chọn ngày bắt đầu KM nhỏ hơn ngày kết thúc KM.");
			form.setMessage("");
			valid = false;
		}
		
		if(valid == true){
				// trong 1 thoi gian chi co the ton tai mot dot khuyen mai
				boolean checkExistOfMonth= false;
				List<DotKhuyenMaiOutputRowBean> lst = DotKhuyenMaiDAO.intances.getAll(pathJSP);
				for(DotKhuyenMaiOutputRowBean dotKhuyenMaiOutputRowBean : lst) {
					if(dotKhuyenMaiOutputRowBean.getMaDKM().equals(form.getMaDKM())) continue;
					if(SMSComons.compareDate(ngayBD,dotKhuyenMaiOutputRowBean.getNgayBD().trim()) == 0  && 
							SMSComons.compareDate(ngayKT,dotKhuyenMaiOutputRowBean.getNgayKT().trim()) == 0){
						checkExistOfMonth = true;
					}
					if(SMSComons.compareDate(ngayBD,dotKhuyenMaiOutputRowBean.getNgayBD().trim()) > 0  && 
							SMSComons.compareDate(ngayKT,dotKhuyenMaiOutputRowBean.getNgayKT().trim()) < 0
							&& SMSComons.compareDate(ngayBD,ngayKT) > 0){
						checkExistOfMonth = true;
					}
					if(SMSComons.compareDate(ngayBD,dotKhuyenMaiOutputRowBean.getNgayBD().trim()) < 0  && 
							SMSComons.compareDate(ngayKT,dotKhuyenMaiOutputRowBean.getNgayKT().trim()) < 0
							&& SMSComons.compareDate(ngayBD,ngayKT) > 0 && SMSComons.compareDate(ngayKT,dotKhuyenMaiOutputRowBean.getNgayBD().trim()) > 0){
						checkExistOfMonth = true;
					}
					if(SMSComons.compareDate(ngayBD,dotKhuyenMaiOutputRowBean.getNgayBD().trim()) > 0  && 
							SMSComons.compareDate(ngayKT,dotKhuyenMaiOutputRowBean.getNgayKT().trim()) > 0
						&& SMSComons.compareDate(ngayBD,ngayKT) > 0 && SMSComons.compareDate(ngayBD,dotKhuyenMaiOutputRowBean.getNgayKT().trim()) < 0){
						checkExistOfMonth = true;
					}
					if(SMSComons.compareDate(ngayBD,dotKhuyenMaiOutputRowBean.getNgayBD().trim()) < 0  && 
							SMSComons.compareDate(ngayKT,dotKhuyenMaiOutputRowBean.getNgayKT().trim()) > 0
							&& SMSComons.compareDate(ngayBD,ngayKT) > 0){
						checkExistOfMonth = true;
					}
				}
				
				if(checkExistOfMonth){
					form.setMessageErr("Trong một khoảng thời gian chỉ có thể tồn tại 1 đợt khuyến mãi.Hãy chọn ngày khác.");
					form.setMessage("");
				}else {
					//input
					DotKhuyenMaiInputBean inputBean = new DotKhuyenMaiInputBean();
					inputBean.setPathJSP(pathJSP);
					inputBean.setMaDKM("");
					inputBean.setTenDKM(form.getTenDKM());
					inputBean.setLoaiKM(form.getLoaiKM());
					inputBean.setNgayBD(ngayBD);
					inputBean.setNgayKT(ngayKT);
					inputBean.setMucKM(form.getMucKM());
					inputBean.setDonViKM(form.getDonViKM());
					inputBean.setMoTa(form.getMoTa());
					inputBean.setDk_loaiThe(form.getDk_loaiThe());
					inputBean.setDk_tongHD(form.getDk_tongHD());
					inputBean.setDk_tongSL(form.getDk_tongSL());
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
				}
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
		String pathJSP = (String)session.getAttribute("pathURL"); 
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		boolean valid = true;
		if ("00".equals(form.getLoaiKM().trim())) { // gia KM có san
			if ("0".equals(form.getMucKM().trim())){
				form.setMessageErr("Trường hợp chọn giá KM có sẵn thì mức giảm giá phải là số lớn hơn 0.");
				valid = false;
			}
			
		}else{
			if ("0".equals(form.getMucKM().trim()) || Integer.parseInt(form.getMucKM().trim()) > 100) {
				form.setMessageErr("Trường hợp chọn KM theo phần trăm hóa đơn thì mức giảm giá phải là số từ 0 đến 100.");
				valid = false;
			}
		}
		
		String ngayBD = SMSComons.formatDateInput(form.getNgayBD());
		String ngayKT = SMSComons.formatDateInput(form.getNgayKT());
		
		if(SMSComons.compareDate(ngayBD,SMSComons.getDate()) < 0){
			form.setMessageErr("Hãy chọn ngày bắt đầu KM từ hôm nay trở đi.");
			form.setMessage("");
			valid = false;
		}
		if(SMSComons.compareDate(ngayBD,ngayKT) > 0){
			form.setMessageErr("Hãy chọn ngày bắt đầu KM nhỏ hơn ngày kết thúc KM.");
			form.setMessage("");
			valid = false;
		}
		
		if(valid == true){
				// trong 1 thoi gian chi co the ton tai mot dot khuyen mai
				boolean checkExistOfMonth= false;
				List<DotKhuyenMaiOutputRowBean> lst = DotKhuyenMaiDAO.intances.getAll(pathJSP);
				for(DotKhuyenMaiOutputRowBean dotKhuyenMaiOutputRowBean : lst) {
					if(dotKhuyenMaiOutputRowBean.getMaDKM().equals(form.getMaDKM())) continue;
					if(SMSComons.compareDate(ngayBD,dotKhuyenMaiOutputRowBean.getNgayBD().trim()) == 0  && 
							SMSComons.compareDate(ngayKT,dotKhuyenMaiOutputRowBean.getNgayKT().trim()) == 0){
						checkExistOfMonth = true;
					}
					if(SMSComons.compareDate(ngayBD,dotKhuyenMaiOutputRowBean.getNgayBD().trim()) > 0  && 
							SMSComons.compareDate(ngayKT,dotKhuyenMaiOutputRowBean.getNgayKT().trim()) < 0
							&& SMSComons.compareDate(ngayBD,ngayKT) > 0){
						checkExistOfMonth = true;
					}
					if(SMSComons.compareDate(ngayBD,dotKhuyenMaiOutputRowBean.getNgayBD().trim()) < 0  && 
							SMSComons.compareDate(ngayKT,dotKhuyenMaiOutputRowBean.getNgayKT().trim()) < 0
							&& SMSComons.compareDate(ngayBD,ngayKT) > 0 && SMSComons.compareDate(ngayKT,dotKhuyenMaiOutputRowBean.getNgayBD().trim()) > 0){
						checkExistOfMonth = true;
					}
					if(SMSComons.compareDate(ngayBD,dotKhuyenMaiOutputRowBean.getNgayBD().trim()) > 0  && 
							SMSComons.compareDate(ngayKT,dotKhuyenMaiOutputRowBean.getNgayKT().trim()) > 0
						&& SMSComons.compareDate(ngayBD,ngayKT) > 0 && SMSComons.compareDate(ngayBD,dotKhuyenMaiOutputRowBean.getNgayKT().trim()) < 0){
						checkExistOfMonth = true;
					}
					if(SMSComons.compareDate(ngayBD,dotKhuyenMaiOutputRowBean.getNgayBD().trim()) < 0  && 
							SMSComons.compareDate(ngayKT,dotKhuyenMaiOutputRowBean.getNgayKT().trim()) > 0
							&& SMSComons.compareDate(ngayBD,ngayKT) > 0){
						checkExistOfMonth = true;
					}
				}
			
				if(checkExistOfMonth){
					form.setMessageErr("Trong một khoảng thời gian chỉ có thể tồn tại 1 đợt khuyến mãi.Hãy chọn ngày khác.");
					form.setMessage("");
				}else {
				//input
				DotKhuyenMaiInputBean inputBean = new DotKhuyenMaiInputBean();
				inputBean.setPathJSP(pathJSP);
				inputBean.setMaDKM(form.getMaDKM());
				inputBean.setTenDKM(form.getTenDKM());
				inputBean.setLoaiKM(form.getLoaiKM());
				inputBean.setNgayBD(ngayBD);
				inputBean.setNgayKT(ngayKT);
				inputBean.setMucKM(form.getMucKM());
				inputBean.setDonViKM(form.getDonViKM());
				inputBean.setMoTa(form.getMoTa());
				inputBean.setDk_loaiThe(form.getDk_loaiThe());
				inputBean.setDk_tongHD(form.getDk_tongHD());
				inputBean.setDk_tongSL(form.getDk_tongSL());
				
				//insert
				int cnt = DotKhuyenMaiDAO.intances.update(inputBean);
				
				if(cnt == 1){
					form.setMessage("Xử lý đăng kí thành công.");
					form.setMessageErr("");
					//Flag update
					form.setFlagUpdate("0");
				}else {
					form.setMessageErr("Xử lý đăng kí không thành công.");
					form.setMessage("");
				}
			}
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
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		DotKhuyenMaiInputBean inputBean = new DotKhuyenMaiInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setMaDKM(id);
		
		List<DotKhuyenMaiOutputRowBean> lst = DotKhuyenMaiDAO.intances.getById(inputBean);
		DotKhuyenMaiOutputRowBean DotKhuyenMaiOutputRowBean = lst.get(0);
		form.setMaDKM(DotKhuyenMaiOutputRowBean.getMaDKM());
		form.setTenDKM(DotKhuyenMaiOutputRowBean.getTenDKM());
		form.setLoaiKM(DotKhuyenMaiOutputRowBean.getLoaiKM());
		form.setNgayBD(SMSComons.formatDateForm(DotKhuyenMaiOutputRowBean.getNgayBD()) );
		form.setNgayKT(SMSComons.formatDateForm(DotKhuyenMaiOutputRowBean.getNgayKT()) );
		form.setMucKM(DotKhuyenMaiOutputRowBean.getMaDKM());
		form.setDonViKM(DotKhuyenMaiOutputRowBean.getDonViKM());
		form.setMoTa(DotKhuyenMaiOutputRowBean.getMoTa());
		form.setDk_loaiThe(DotKhuyenMaiOutputRowBean.getDk_loaiThe());
		form.setDk_tongHD(DotKhuyenMaiOutputRowBean.getDk_tongHD());
		form.setDk_tongSL(DotKhuyenMaiOutputRowBean.getDk_tongSL());
		
		//Flag update
		form.setFlagUpdate("1");
		
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
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		DotKhuyenMaiInputBean input = new DotKhuyenMaiInputBean();
		input.setPathJSP(pathJSP);
		input.setMaDKM(id);
		
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
	

	@RequestMapping(value="/dotKhuyenMai/showDetail/{id}")
	public String showDetail(@ModelAttribute("DotKhuyenMaiForm") DotKhuyenMaiForm form, @PathVariable("id") String id, HttpSession session){
		
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
		session.setAttribute("idDKM", id);
		
		return  "redirect:/chiTietDKM/init";
	}
	
}
