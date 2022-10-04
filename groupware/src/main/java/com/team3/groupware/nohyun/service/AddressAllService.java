package com.team3.groupware.nohyun.service;

import java.util.List;
import java.util.Map;

import com.team3.groupware.nohyun.model.AddressAllVO;

public interface AddressAllService {
//Ʋ
	List<Map<String, Object>> list(Map<String, Object> map);

	List<Map<String, Object>> list_chosung(Map<String, Object> chosung);

	List<Map<String, Object>> list_whole(Map<String, Object> whole);

	List<Map<String, Object>> keyword_search(Map<String, Object> keyword);

	List<AddressAllVO> excelList(AddressAllVO excelDown);

	List<Map<String, Object>> addressInfo(Map<String, Object> AllInfo);
	
	
	
	

}
