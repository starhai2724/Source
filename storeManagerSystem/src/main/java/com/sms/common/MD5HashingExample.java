package com.sms.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashingExample {

	public static String MD5(String password) {
		StringBuffer sb = new StringBuffer();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte byteData[] = md.digest();
			// convert the byte to hex format method 1
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		MD5HashingExample.MD5("123");
	}
}
