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
import com.sms.common.SystemCommon;
import com.sms.dao.DotKhuyenMaiDAO;
import com.sms.form.DotKhuyenMaiForm;
import com.sms.formRows.DotKhuyenMaiRowForm;
import com.sms.input.DotKhuyenMaiInputBean;

@Controller
public class dotKhuyenMaiController {

	public static final String DOTKHUYENMAI = "dotKhuyenMai.jsp";
	public static final String CHITIETDKM = "chiTietDKM.jsp";
	
	@RequestMapping(value  = "/dotKhuyenMai/init")
	public String init(@ModelAttribute("DotKhuyenMaiForm") DotKhuyenMaiForm form, HttpSession session){
		String pathJSP = "cuahangthoitrang";
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
		//Loai KM
		form.getLst_loaiKM().put("00", "--- Chọn loại khuyến mãi ---");
		form.getLst_loaiKM().put("01", "Theo giá khuyến mãi có sẵn");
		form.getLst_loaiKM().put("02", "Theo phần trăm sản phẩm");
		form.getLst_loaiKM().put("03", "Theo phần trăm hóa đơn");
		form.getLst_loaiKM().put("04", "Tặng kèm sản phầm");
		form.getLst_loaiKM().put("05", "Tặng phiếu giảm giá");
		form.getLst_loaiKM().put("06", "Tặng phiếu quà tặng");
		form.getLst_loaiKM().put("07", "Miễn phí ship hàng");
		
		
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
				String donViKM = outputRowBean.getDonViKM();
				String loaiThe = outputRowBean.getDk_loaiThe();
				
				Iterator<Entry<String, String>> its_loaiKM = lst_loaiKM.entrySet().iterator();
				while (its_loaiKM.hasNext()) {
				    Entry<String, String> it = its_loaiKM.next();
				    if(loaiKM.equals(it.getKey())){
				    	formRow.setLoaiKM(it.getValue());
				    }
				}
				
				Iterator<Entry<String, String>> its_donViKM = lst_donViKM.entrySet().iterator();
				while (its_donViKM.hasNext()) {
				    Entry<String, String> it = its_donViKM.next();
				    if(donViKM.equals(it.getKey())){
				    	formRow.setMucGiamGia(outputRowBean.getMucKM() + " " + it.getValue());
				    	if(it.getKey().equals("03") && !outputRowBean.getMucKM().equals("") && outputRowBean.getMucKM().trim().length() != 0){
					    	formRow.setMucGiamGia(String.format("%,.2f",Double.parseDouble(outputRowBean.getMucKM())) + " " + it.getValue());
					    }
				    }
				}
				
				Iterator<Entry<String, String>> its_loaiThe = lst_loaiThe.entrySet().iterator();
				while (its_loaiThe.hasNext()) {
				    Entry<String, String> it = its_loaiThe.next();
				    if(loaiThe.equals(it.getKey())){
						formRow.setDk_loaiThe(it.getValue());
				    }
				}
				
				String ngayBD,thangKT,namKT = "";
				String ngayKT,thangBD,namBD = "";
				
				if(outputRowBean.getNgayKT() != null && outputRowBean.getNgayKT().trim().length() != 0){
					ngayKT = outputRowBean.getNgayKT().substring(6,outputRowBean.getNgayKT().length() );
					thangKT = outputRowBean.getNgayKT().substring(4,6 );
					namKT = outputRowBean.getNgayKT().substring(0,4 );
					formRow.setNgayKT(namKT + "/" + thangKT + "/" + ngayKT);
				}
				
				if(outputRowBean.getNgayBD() != null && outputRowBean.getNgayBD().trim().length() != 0){
					 ngayBD = outputRowBean.getNgayBD().substring(6,outputRowBean.getNgayBD().length() );
					 thangBD = outputRowBean.getNgayBD().substring(4,6 );
					 namBD = outputRowBean.getNgayBD().substring(0,4 );
					 formRow.setNgayBD(namBD + "/" + thangBD + "/" + ngayBD);
				}
				
						
				if(!outputRowBean.getDk_tongHD().equals("") && outputRowBean.getDk_tongHD().trim().length() != 0 && outputRowBean.getDk_tongHD() != null){
					formRow.setDk_tongHD(String.format("%,.2f",Double.parseDouble(outputRowBean.getDk_tongHD())));
				}else{
					formRow.setDk_tongHD(outputRowBean.getDk_tongHD());
				}
				
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
		String pathJSP = "cuahangthoitrang";
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
