package com.sms.common;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtilLocal {
	public static void guiMailLienHe(String mail, String body, String subject) {
		try {
			String smtpServer = "smtp.gmail.com";
			String to = mail;
			String from = "thu225656294@gmail.com";
			String password = "225656294";
			send(smtpServer, to, from, password, subject, body);
			System.out.println("Finish!");
		} catch (Exception ex) {
			System.out.println("not Connected internet.....");
		}
	}
	public static void send(String smtpServer, String to, String from,
			String psw, String subject, String body) throws Exception {

		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpServer);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("", "true");
		final String login = from;
		final String pwd = psw;
		Authenticator pa = null;
		if (login != null && pwd != null) {
			props.put("mail.smtp.auth", "true");
			pa = new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(login, pwd);
				}
			};
		}// else: no authentication
		Session session = Session.getInstance(props, pa);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(from));
		msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to, false));

		msg.setSubject(subject);
		msg.setText(body);
		msg.setHeader("X-Mailer", "LOTONtechEmail");
		msg.setSentDate(new Date());

		MimeMultipart multipart = new MimeMultipart("related");
		// first part (the html)
		BodyPart messageBodyPart = new MimeBodyPart();
		String htmlText = body;
		System.out.println(htmlText);
		messageBodyPart.setContent(htmlText, "text/html"
				+ "; charset=\"utf-8\"");
		// SFmessageBodyPart.setHeader("Content-Type", "charset=\'utf-8\'");
		multipart.addBodyPart(messageBodyPart);

		msg.setContent(multipart);
		msg.saveChanges();

		Transport.send(msg);
		System.out.println("Message sent OK.");

	}

	/* Tao pt static */
	public static void guiMail(String mail, String body, String subject) {
		try {
			String smtpServer = "smtp.gmail.com";
			String to = mail;
			String from = "hai272404237@gmail.com";
			String password = "272404237";
			send(smtpServer, to, from, password, subject, body);
			System.out.println("Finish!");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("not Connected internet.....");
		}
	}

	public static void main(String[] args) {
		// for (int i = 0; i < 10; i++) {
		String mail = "hai2724@gmail.com";
		String body = "abc";
		guiMail(mail, body, "Email thu: ");
		// }

	}

}
