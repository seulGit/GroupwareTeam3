package com.team3.groupware.jeongchi.model;

import java.util.List;
import java.util.Map;

import com.team3.groupware.common.model.EmployeeVO;

public interface MessageDAO {

//	void write(MessageVO messageVo);

	List<EmployeeVO> writeAddressSearch(Map<String, Object> addSearchMap, String search_option, String keyword);

	int sendMessage(MessageVO messageVO);

	List<MessageVO> sendMessageList(int start, int end, MessageVO messageVO, int emp_num);

	int count(MessageVO messageVO);

	List<MessageVO> receiveMessageList(int start, int end, MessageVO messageVO, int emp_num);

	List<MessageVO> importantMessageList(int start, int end, MessageVO messageVO, int emp_num);
	
	List<MessageVO> tempMessageList(int start, int end, MessageVO messageVO, int emp_num);

	Map<String, Object> message_detail(MessageVO messageVO);

}
