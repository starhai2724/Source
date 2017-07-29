package com.sms.form;

import java.util.ArrayList;
import java.util.List;


public class DangKiWebForm extends AbstractForm {

	private String tenWebSite;

	private String idCuaHang;

	private String pathJSP;

	private String email;

	private String matKhau;

	private String quyen;

	private String sdt;

	private String diaChi;

	private String loaiKinhDoanh;

	private String maXacNhan;
	
	private String dkGiaoHangFree;
	
	private byte[]  hinh;
	private byte[]  file_1;
	private byte[]  file_2;
	private byte[]  file_3;
	private byte[]  file_4;
	private byte[]  file_5;
	
	private String linkFanpage;
	
	private List<LoaiKinhDoanhForm> lstLoaiKinhDoanh = new ArrayList<>();

	public String getTenWebSite() {
		return tenWebSite;
	}

	public String getLinkFanpage() {
		return linkFanpage;
	}


	public void setLinkFanpage(String linkFanpage) {
		this.linkFanpage = linkFanpage;
	}


	public void setTenWebSite(String tenWebSite) {
		this.tenWebSite = tenWebSite;
	}

	public String getIdCuaHang() {
		return idCuaHang;
	}

	public void setIdCuaHang(String idCuaHang) {
		this.idCuaHang = idCuaHang;
	}

	public String getPathJSP() {
		return pathJSP;
	}

	public void setPathJSP(String pathJSP) {
		this.pathJSP = pathJSP;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getLoaiKinhDoanh() {
		return loaiKinhDoanh;
	}

	public void setLoaiKinhDoanh(String loaiKinhDoanh) {
		this.loaiKinhDoanh = loaiKinhDoanh;
	}

	public String getMaXacNhan() {
		return maXacNhan;
	}

	public void setMaXacNhan(String maXacNhan) {
		this.maXacNhan = maXacNhan;
	}

	public String getDkGiaoHangFree() {
		return dkGiaoHangFree;
	}

	public void setDkGiaoHangFree(String dkGiaoHangFree) {
		this.dkGiaoHangFree = dkGiaoHangFree;
	}

	public byte[] getHinh() {
		return hinh;
	}

	public void setHinh(byte[] hinh) {
		this.hinh = hinh;
	}

	

	public byte[] getFile_1() {
		return file_1;
	}

	public void setFile_1(byte[] file_1) {
		this.file_1 = file_1;
	}

	public byte[] getFile_2() {
		return file_2;
	}

	public void setFile_2(byte[] file_2) {
		this.file_2 = file_2;
	}

	public byte[] getFile_3() {
		return file_3;
	}

	public void setFile_3(byte[] file_3) {
		this.file_3 = file_3;
	}

	public byte[] getFile_4() {
		return file_4;
	}

	public void setFile_4(byte[] file_4) {
		this.file_4 = file_4;
	}

	public byte[] getFile_5() {
		return file_5;
	}

	public void setFile_5(byte[] file_5) {
		this.file_5 = file_5;
	}

	public List<LoaiKinhDoanhForm> getLstLoaiKinhDoanh() {
		return lstLoaiKinhDoanh;
	}

	public void setLstLoaiKinhDoanh(List<LoaiKinhDoanhForm> lstLoaiKinhDoanh) {
		this.lstLoaiKinhDoanh = lstLoaiKinhDoanh;
	}
	
public static void main(String[] args) {
	  
	 /*     // Email ID cua nguoi nhan can duoc de cap den.
	      String to = "thu225656294@gmail.com";

	      // Email ID cua nguoi gui can duoc de cap den
	      String from = "thuptn1994@gmail.com";

	      // Gia su ban dang gui email tu localhost
	      String host = "localhost";

	      // Lay cac system properties
	      Properties properties = System.getProperties();

	      // Thiet lap mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Lay doi tuong Session mac dinh.
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Tao mot doi tuong MimeMessage mac dinh.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("Day la dong Subject!");

	         // Bay gio thiet lap message thuc su
	         message.setText("Day la message thuc su");

	         // Send message
	         Transport.send(message);
	         System.out.println("Gui message thanh cong....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
*/
	/*
	  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	  // Get a Properties object
	     Properties props = System.getProperties();
	     props.setProperty("mail.smtp.host", "thuptn1994.gmail.com");
	     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	     props.setProperty("mail.smtp.socketFactory.fallback", "false");
	     props.setProperty("mail.smtp.port", "465");
	     props.setProperty("mail.smtp.socketFactory.port", "465");
	     props.put("mail.smtp.auth", "true");
	     props.put("mail.debug", "true");
	     props.put("mail.store.protocol", "pop3");
	     props.put("mail.transport.protocol", "smtp");
	     final String username = "thu225656294@gmail.com";//
	     final String password = "truc315414";
	     try{
	     Session session = Session.getDefaultInstance(props, 
	                          new Authenticator(){
	                             protected PasswordAuthentication getPasswordAuthentication() {
	                                return new PasswordAuthentication(username, password);
	                             }});

	   // -- Create a new message --
	     Message msg = new MimeMessage(session);

	  // -- Set the FROM and TO fields --
	     msg.setFrom(new InternetAddress("thuptn1994@gmail.com"));
	     msg.setRecipients(Message.RecipientType.TO, 
	                      InternetAddress.parse("user120@example.com",false));
	     msg.setSubject("Hello");
	     msg.setText("How are you");
	     msg.setSentDate(new Date());
	     Transport.send(msg);
	     System.out.println("Message sent.");
	  }catch (MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);}
	  }*/
}
}
