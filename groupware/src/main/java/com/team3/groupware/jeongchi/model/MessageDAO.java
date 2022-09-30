package com.team3.groupware.jeongchi.model;

import java.util.List;
import java.util.Map;

import com.team3.groupware.common.model.EmployeeVO;

public interface MessageDAO {

	void write(MessageVO messageVo);

	List<EmployeeVO> writeAddressSearch(String search_option, String keyword);

	List<EmployeeVO> writeAddressSearch(Map<String, Object> addSearchMap, String search_option, String keyword);

}
