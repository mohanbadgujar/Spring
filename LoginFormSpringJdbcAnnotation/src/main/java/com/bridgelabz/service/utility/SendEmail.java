package com.bridgelabz.service.utility;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sun.org.apache.bcel.internal.generic.RETURN;

@Service
public class SendEmail {
	
	private JavaMailSender mailSender;
	
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String emailId)
	{
		MimeMessage message =  this.mailSender.createMimeMessage();
		MimeMessageHelper mimeHelper;
		/*String status = null;*/
		try {
			mimeHelper = new MimeMessageHelper(message,true);
			mimeHelper.setTo(emailId);
			
			mimeHelper.setFrom("Administrator");
			mimeHelper.setSubject("Password Reset");
			mimeHelper.setText("<html><body>hi,<br/><a href='http://localhost:8080/LoginFormSpringJdbcAnnotation/newPassword/"+emailId+"/'> Click here</a> to reset password</body></html>",true);
			mailSender.send(message);
			/*status = "Confirmation email is sent to your address (" + emailId + ")";*/
			
		} catch (MessagingException e) {
			
			/*status = "There was an error in email sending. Please check your email address: " + emailId;*/
			System.out.println("Error Sending email "+ e.getMessage());
		}
		
	}
	
	public String sendRegistrationMail(String emailId)
	{
		MimeMessage message =  this.mailSender.createMimeMessage();
		MimeMessageHelper mimeHelper;
		String status = null;
		
		try {
			mimeHelper = new MimeMessageHelper(message,true);
			mimeHelper.setTo(emailId);
			
			mimeHelper.setFrom("Administrator");
			mimeHelper.setSubject("Send registration success message");
			mimeHelper.setText("you are registered with my app successfully", true);
			mailSender.send(message);
			return status = "Confirmation email is sent to your address (" + emailId + ")";
			
		} catch (MessagingException e) {
			System.out.println("Error Sending email "+ e.getMessage());
			return status = "There was an error in email sending. Please check your email address: " + emailId;
			
		}
	}
}




/*package com.bridgelabz.service.utility;

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
*/