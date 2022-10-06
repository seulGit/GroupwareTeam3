package com.team3.groupware.common.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.groupware.eunji.model.BoardVO;

@Repository
public class MainDAOImpl implements MainDAO {
	
	@Autowired 
	SqlSessionTemplate SqlSessionTemplate;

	@Override
	public List<BoardVO> allBoardView(Map<String, Object> boardMap) {
		
	List<BoardVO> mainBoardList = SqlSessionTemplate.selectList("mainAjax.mainBoardList", boardMap);
	return mainBoardList;
	}

}
