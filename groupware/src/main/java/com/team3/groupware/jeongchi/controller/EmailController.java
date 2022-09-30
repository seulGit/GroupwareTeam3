package com.team3.groupware.jeongchi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.groupware.jeongchi.model.MessageVO;
import com.team3.groupware.jeongchi.service.EmailService;


@RestController
@RequestMapping("/email/*")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@RequestMapping("write.do")
	public String write() {
		return "/email/write";
	}
	
	@RequestMapping("send.do")
	public String send(MessageVO vo, Model model) {
		try {
			emailService.sendMail(vo);
			model.addAttribute("message", "이메일이 발송되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "이메일 발송 실패...");
		}
		return "/email/write";
	}
}
