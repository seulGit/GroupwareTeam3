package com.team3.groupware.nohyun.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressPersonalDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
//	public List<Map<String, Object>> selectList_add(Map<String, Object> map) {
//		
//		return this.sqlSessionTemplate.selectList("address_personal.address_personal_add_category",map);
//	}
//
//	public List<Map<String, Object>> selectList_search(Map<String, Object> map) {
//		// TODO Auto-generated method stub
//		return this.sqlSessionTemplate.selectList("address_personal.address_personal_search_category",map);
//	}

}
