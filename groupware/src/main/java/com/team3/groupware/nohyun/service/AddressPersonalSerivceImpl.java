package com.team3.groupware.nohyun.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.groupware.nohyun.model.AddressPersonalDAO;

@Service
public class AddressPersonalSerivceImpl implements AddressPersonalService{

	@Autowired
	AddressPersonalDAO addressPersonalDao;
	
//	@Override
//	public List<Map<String, Object>> AddCategory(Map<String, Object> map) {
//		// TODO Auto-generated method stub
//		return this.addressPersonalDao.selectList_add(map);
//	}
//
//	@Override
//	public List<Map<String, Object>> SearchCategory(Map<String, Object> map) {
//		// TODO Auto-generated method stub
//		return this.addressPersonalDao.selectList_search(map);
//	}

}
