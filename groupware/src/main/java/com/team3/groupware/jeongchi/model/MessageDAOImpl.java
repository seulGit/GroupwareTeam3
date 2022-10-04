package com.team3.groupware.jeongchi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.groupware.common.model.EmployeeVO;


@Repository
public class MessageDAOImpl implements MessageDAO {

	@Autowired 
	SqlSessionTemplate SqlSessionTemplate;

//	@Override
//	public void write(MessageVO messageVo) {
//		SqlSessionTemplate.insert("note.sendNote", messageVo);
//	}

	@Override
	public List<EmployeeVO> writeAddressSearch(Map<String, Object> addSearchMap, String search_option, String keyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("search_option", search_option);
		return SqlSessionTemplate.selectList("note.addFindList", map);
	}

	@Override
	public int sendMessage(MessageVO messageVO) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.insert("note.sendNote", messageVO);
	}

	@Override
	public List<MessageVO> sendMessageList(int start, int end, MessageVO messageVO, int emp_num) {
		Map<String, Object> map = new HashMap<>();
		map.put("emp_num", emp_num);
		map.put("start", start);
		map.put("end", end);
		return SqlSessionTemplate.selectList("note.sendMessageList", map);
	}

	@Override
	public int count(MessageVO messageVO) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.selectOne("note.count", messageVO);
	}

	@Override
	public List<MessageVO> receiveMessageList(int start, int end, MessageVO messageVO, int emp_num) {
		Map<String, Object> map2 = new HashMap<>();
		map2.put("emp_num2", emp_num);
		map2.put("start", start);
		map2.put("end", end);
		return SqlSessionTemplate.selectList("note.receiveMessageList", map2);
	}

}
