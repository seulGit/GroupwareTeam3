package com.team3.groupware.jeongchi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.groupware.common.model.EmployeeVO;


@Repository
public class MessageDAOImpl implements MessageDAO {

	@Autowired 
	SqlSessionTemplate SqlSessionTemplate;

	@Override
	public void write(MessageVO messageVo) {
		SqlSessionTemplate.insert("note.sendNote", messageVo);
	}

	@Override
	public List<EmployeeVO> writeAddressSearch(String search_option, String keyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("search_option", search_option);
		return SqlSessionTemplate.selectList("note.addFindList", map);
	}

	@Override
	public List<EmployeeVO> writeAddressSearch(Map<String, Object> addSearchMap, String search_option, String keyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("search_option", search_option);
		return SqlSessionTemplate.selectList("note.addFindList", map);
	}
	
}
