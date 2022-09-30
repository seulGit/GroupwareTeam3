package com.team3.groupware.jeongchi.service;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.team3.groupware.jeongchi.model.EmailVO;
import com.team3.groupware.jeongchi.model.MessageVO;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	JavaMailSender mailSender;
	@Override
	public void sendMail(MessageVO vo) {
		try {
			MimeMessage msg=mailSender.createMimeMessage(); //이메일 객체
			//수신자
			msg.addRecipient(RecipientType.TO, new InternetAddress(vo.getMessage_receiver()));
			//발신자 이메일주소, 이름
			msg.addFrom(new InternetAddress[] {
					new InternetAddress(vo.getMessage_sender())
			});
			msg.setSubject(vo.getMessage_title(),"utf-8"); //제목
			msg.setText(vo.getMessage_contents(),"utf-8"); //내용
			mailSender.send(msg); //이메일 발신
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





