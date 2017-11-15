package com.bridgelabz.service.utility;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.bridgelabz.model.User;

public class SendEmail {

	private JavaMailSender mailSender;

	public String sendEmail(User user) {
		String status = null;
		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("Administrator");
			helper.setTo(user.getEmail());
			helper.setSubject("Registration confirmation");
			helper.setText("you are registered", true);
			mailSender.send(message);
			status = "Confirmation email is sent to your address (" + user.getEmail() + ")";

		} catch (MessagingException e) {

			status = "There was an error in email sending. Please check your email address: " + user.getEmail();
		}

		return status;
	}

	@Autowired
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
}
