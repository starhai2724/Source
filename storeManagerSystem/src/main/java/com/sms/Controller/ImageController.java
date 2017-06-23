package com.sms.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.dao.CreateTableProductDAO;
import com.sms.domain.Image;
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
	
	@RequestMapping(value = "/imageDisplay/{id}", method = RequestMethod.GET)
	public void getImage(HttpServletResponse response, HttpServletRequest request, @PathVariable("id") String id)
			throws ServletException, IOException {
		String pathJSP = "cuahangthoitrang";
		ImageOutputBean imageOutputBean = CreateTableProductDAO.intances.getImage(pathJSP, "", id);
		
		// save image into database
//		File file = new File("D:\\THISIS\\image\\Test.png");
		byte[] bFile = imageOutputBean.getHinh();
		//Get image from database
		try {
			FileOutputStream fos = new FileOutputStream("D:\\THISIS\\image\\Test1.png");
            fos.write(bFile);
            fos.close();
			
			
//			FileInputStream fileInputStream = new FileInputStream(file);
			// convert file into array of bytes
//			fileInputStream.read(bFile);
//			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("image/jpeg, image/jpg, image/png,image/gif");
		response.getOutputStream().write(bFile);
		response.getOutputStream().close();
	}
}