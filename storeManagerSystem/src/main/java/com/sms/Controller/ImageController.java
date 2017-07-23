package com.sms.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.DangKiWebDAO;
import com.sms.dao.LayoutDAO;
import com.sms.domain.Image;
import com.sms.output.DangKiWebOutputBean;
import com.sms.output.ImageOutputBean;

@Controller
@RequestMapping("/myImage")
public class ImageController {

//	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
//	public void showImage(HttpServletResponse response, HttpServletRequest request)
//			throws ServletException, IOException {
//
//		// save image into database
//		File file = new File("D:\\THISIS\\image\\Test.png");
//		byte[] bFile = new byte[(int) file.length()];
//
//		try {
//			FileInputStream fileInputStream = new FileInputStream(file);
//			// convert file into array of bytes
//			fileInputStream.read(bFile);
//			fileInputStream.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		response.setContentType("image/jpeg, image/jpg, image/png,image/gif");
//		response.getOutputStream().write(bFile);
//		response.getOutputStream().close();
//	}
	
	@RequestMapping(value = "/{path}/imageDisplay/{id}", method = RequestMethod.GET)
	public void getImage(HttpServletResponse response, HttpServletRequest request, @PathVariable("id") String id, @PathVariable("path") String path, HttpSession session)
			throws ServletException, IOException {
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(path)) {
			// quay ve trang login
			return ;
		}
		ImageOutputBean imageOutputBean = CreateTableProductDAO.intances.getImage(path, "", id);
		if(imageOutputBean !=null &&  imageOutputBean.getHinh() != null){
			byte[] bFile = imageOutputBean.getHinh();
			response.setContentType("image/jpeg, image/jpg, image/png,image/gif");
			response.getOutputStream().write(bFile);
			response.getOutputStream().close();
		}
	}
	
	@RequestMapping(value = "/{path}/imageDisplay_1/{id}", method = RequestMethod.GET)
	public void getImage_1(HttpServletResponse response, HttpServletRequest request, @PathVariable("id") String id, @PathVariable("path") String path, HttpSession session)
			throws ServletException, IOException {
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(path)) {
			// quay ve trang login
			return ;
		}
		ImageOutputBean imageOutputBean = CreateTableProductDAO.intances.getImage(path, "", id);
		if(imageOutputBean !=null &&  imageOutputBean.getHinhChiTiet1() != null){
			byte[] bFile = imageOutputBean.getHinhChiTiet1();
			response.setContentType("image/jpeg, image/jpg, image/png,image/gif");
			response.getOutputStream().write(bFile);
			response.getOutputStream().close();
		}
	}
	
	@RequestMapping(value = "/{path}/imageDisplay_2/{id}", method = RequestMethod.GET)
	public void getImage_2(HttpServletResponse response, HttpServletRequest request, @PathVariable("id") String id, @PathVariable("path") String path, HttpSession session)
			throws ServletException, IOException {
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(path)) {
			// quay ve trang login
			return ;
		}
		ImageOutputBean imageOutputBean = CreateTableProductDAO.intances.getImage(path, "", id);
		if(imageOutputBean !=null &&  imageOutputBean.getHinhChiTiet2() != null){
			byte[] bFile = imageOutputBean.getHinhChiTiet2();
			response.setContentType("image/jpeg, image/jpg, image/png,image/gif");
			response.getOutputStream().write(bFile);
			response.getOutputStream().close();
		}
	}
	
	@RequestMapping(value = "/{path}/imageDisplay_3/{id}", method = RequestMethod.GET)
	public void getImage_3(HttpServletResponse response, HttpServletRequest request, @PathVariable("id") String id, @PathVariable("path") String path, HttpSession session)
			throws ServletException, IOException {
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(path)) {
			// quay ve trang login
			return ;
		}
		ImageOutputBean imageOutputBean = CreateTableProductDAO.intances.getImage(path, "", id);
		if(imageOutputBean !=null &&  imageOutputBean.getHinhChiTiet3() != null){
			byte[] bFile = imageOutputBean.getHinhChiTiet3();
			response.setContentType("image/jpeg, image/jpg, image/png,image/gif");
			response.getOutputStream().write(bFile);
			response.getOutputStream().close();
		}
	}
	
	@RequestMapping(value = "/{path}/imageDisplayHeader/{hinh}", method = RequestMethod.GET)
	public void getImageHeader(HttpServletResponse response, HttpServletRequest request, @PathVariable("hinh") String hinh, @PathVariable("path") String path,
			HttpSession session)throws ServletException, IOException {
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(path)) {
			// quay ve trang login
			return ;
		}
		DangKiWebOutputBean imageOutputBean = DangKiWebDAO.intances.getDataByPathJSP(path);
		if(imageOutputBean !=null &&  imageOutputBean.getHinh1() != null && hinh.equals("hinh1")){
			byte[] bFile = imageOutputBean.getHinh1();
			response.setContentType("image/jpeg, image/jpg, image/png,image/gif");
			response.getOutputStream().write(bFile);
			response.getOutputStream().close();
		}
		if(imageOutputBean !=null &&  imageOutputBean.getHinh2() != null && hinh.equals("hinh2")){
			byte[] bFile = imageOutputBean.getHinh2();
			response.setContentType("image/jpeg, image/jpg, image/png,image/gif");
			response.getOutputStream().write(bFile);
			response.getOutputStream().close();
		}
		if(imageOutputBean !=null &&  imageOutputBean.getHinh3() != null && hinh.equals("hinh3")){
			byte[] bFile = imageOutputBean.getHinh3();
			response.setContentType("image/jpeg, image/jpg, image/png,image/gif");
			response.getOutputStream().write(bFile);
			response.getOutputStream().close();
		}
		if(imageOutputBean !=null &&  imageOutputBean.getHinh4() != null && hinh.equals("hinh4")){
			byte[] bFile = imageOutputBean.getHinh4();
			response.setContentType("image/jpeg, image/jpg, image/png,image/gif");
			response.getOutputStream().write(bFile);
			response.getOutputStream().close();
		}
		if(imageOutputBean !=null &&  imageOutputBean.getHinh5() != null && hinh.equals("hinh5")){
			byte[] bFile = imageOutputBean.getHinh5();
			response.setContentType("image/jpeg, image/jpg, image/png,image/gif");
			response.getOutputStream().write(bFile);
			response.getOutputStream().close();
		}
	}
}