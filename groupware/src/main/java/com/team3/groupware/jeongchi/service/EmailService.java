package com.team3.groupware.jeongchi.service;

import com.team3.groupware.jeongchi.model.MessageVO;

public interface EmailService {
	void sendMail(MessageVO vo);
}
