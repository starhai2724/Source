package com.sms.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.hibernate.Session;

import com.mysql.jdbc.PreparedStatement;
import com.sms.dao.common.HibernateUtil;
import com.sms.domain.Image;

public class TestInsertImage {

	public void insert(){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQL();
		try{
			 //save image into database
	    	File file = new File("D:\\THISIS\\image\\Test.png");
	        byte[] bFile = new byte[(int) file.length()];

	        try {
		     FileInputStream fileInputStream = new FileInputStream(file);
		     //convert file into array of bytes
		     fileInputStream.read(bFile);
		     fileInputStream.close();
	        } catch (Exception e) {
		     e.printStackTrace();
	        }
			
			Image image = new Image();
			image.setIdImage("02");
			image.setItemImage(bFile);
//			session.save(image);
			Image result = HibernateUtil.insertObject(image);
			
			//Get image from database
			Image image2 = (Image)session.get(Image.class, "01");
	        byte[] bAvatar = image2.getItemImage();
	        try{
	            FileOutputStream fos = new FileOutputStream("D:\\THISIS\\image\\Test1.png");
	            fos.write(bAvatar);
	            fos.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
			
		}catch(Exception e){
			
		}
		
	}
	
	public void createTable(){
		
		
	}
	
	

	
	public String getSQL(){
		StringBuffer  sb = new StringBuffer();
		sb.append("   INSERT into image VALUES(?,?)");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		TestInsertImage test = new TestInsertImage();
		test.insert();
		
	}
}
