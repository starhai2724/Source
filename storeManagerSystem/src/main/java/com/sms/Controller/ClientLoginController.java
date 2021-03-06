		
package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sms.OutputRows.ThoiHanSuDungOutputRowBean;
import com.sms.common.MD5HashingExample;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.ThoiHanSuDungDAO;
import com.sms.form.KhachHangForm;
import com.sms.form.LoginForm;
import com.sms.form.StoreOwnerForm;
import com.sms.form.ThoiHanSuDungRowForm;
import com.sms.impl.ClientLoginImpl;
import com.sms.models.User;
import com.sms.output.ThoiHanSuDungOutputBean;
@Controller
public class ClientLoginController {

	public static final String PAGE_INFO = "thongTinCuaHang.jsp";
	public static final String PAGE_ID = "PAGE_ID";
	public static final String PAGE_REGISTER = "registerUser";
	
	@RequestMapping(value ="/", method = RequestMethod.GET)	
	public String home(@ModelAttribute("LoginForm") LoginForm loginForm, HttpSession session, Model model, BindingResult result){
		if (result.hasErrors()) {
			return SystemCommon.PAGE_ERROR;
	    }
		return SystemCommon.PAGE_LOGIN;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("LoginForm") LoginForm loginForm, ModelMap model, HttpSession session, BindingResult result){
		ThoiHanSuDungOutputBean outputBean = ThoiHanSuDungDAO.intances.getAll();
		String onlineDT = SMSComons.getDate();
		if (outputBean != null && outputBean.getLst().size() > 0) {
			for(ThoiHanSuDungOutputRowBean thoiHanSuDungOutputRowBean : outputBean.getLst()){
				if(SMSComons.compareDate(thoiHanSuDungOutputRowBean.getThoiGianSuDung(), onlineDT) < 0){
					ThoiHanSuDungDAO.intances.updateStoreOnwer(thoiHanSuDungOutputRowBean.getIdStoreOnwer(), "1");
				}
			}
		}
		model.addAttribute("LoginForm", loginForm);
		loginForm.setMessageErr("Sai Tên đăng nhập hoặc mật khẩu");
		User req = new User();
		req.setUsername(loginForm.getUsername());
		req.setPassword(MD5HashingExample.MD5(loginForm.getPassword()));
		ClientLoginImpl loginImpl = new ClientLoginImpl();
		User response = loginImpl.checkLogin(req);
		if(null != response && !StringUtils.isEmpty(response.getUsername())){
			User userlocal = response;
			// set session userlocal
			session.setAttribute("userLocal", userlocal);
			
			//role User
			if(SystemCommon.USER.equals(userlocal.getRole())){
				session.setAttribute("pathURL", userlocal.getURLStore());
				
				return "redirect:/thongKe/init";
				
			//role Root
			}else if(SystemCommon.ROOT.equals(userlocal.getRole())){
				return SystemCommon.PAGE_HOME;
			}
		}
		return SystemCommon.PAGE_LOGIN;
	}
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("storeOwnerForm") StoreOwnerForm storeOwnerForm){
		return PAGE_REGISTER;
	}
	
	@RequestMapping(value ="/dangXuat", method = RequestMethod.GET)	
	public String dangXuat(@ModelAttribute("LoginForm") LoginForm loginForm, HttpSession session, Model model){
		// set session userlocal
		session.removeAttribute("userLocal");
		session.removeAttribute("pathURL");
		return SystemCommon.PAGE_LOGIN;
	}
}
