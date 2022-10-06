package com.team3.groupware.jeongchi.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.jeongchi.model.MessageDAO;
import com.team3.groupware.jeongchi.model.MessageVO;


@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDAO messageDao;
	
	// 쪽지테이블에 첨부파일이 없는 쪽지 insert 하기
//	@Override
//	public void write(MessageVO messageVo) {
//		// TODO Auto-generated method stub
//		
//		messageDao.write(messageVo);
//	}

	@Override
	public List<EmployeeVO> writeAddressSearch(Map<String, Object> addSearchMap, String search_option, String keyword) {
		// TODO Auto-generated method stub
		return messageDao.writeAddressSearch(addSearchMap, search_option, keyword);
	}

	@Override
	public int sendMessage(MessageVO messageVO) {
		// TODO Auto-generated method stub
		return messageDao.sendMessage(messageVO);
	}

	@Override
	public List<MessageVO> sendMessageList(int start, int end, MessageVO messageVO, int emp_num) {
		// TODO Auto-generated method stub
		return messageDao.sendMessageList(start, end, messageVO, emp_num);
	}

	@Override
	public int count(MessageVO messageVO) {
		// TODO Auto-generated method stub
		return messageDao.count(messageVO);
	}

	@Override
	public List<MessageVO> receiveMessageList(int start, int end, MessageVO messageVO, int emp_num) {
		// TODO Auto-generated method stub
		return messageDao.receiveMessageList(start, end, messageVO, emp_num);
	}
	
	@Override
	public List<MessageVO> importantMessageList(int start, int end, MessageVO messageVO, int emp_num) {
		// TODO Auto-generated method stub
		return messageDao.importantMessageList(start, end, messageVO, emp_num);
	}
	

}
