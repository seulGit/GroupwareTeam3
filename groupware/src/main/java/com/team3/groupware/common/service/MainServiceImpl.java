package com.team3.groupware.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.groupware.common.model.MainDAO;
import com.team3.groupware.eunji.model.BoardVO;

@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	private MainDAO mainDao;

	@Override
	public List<BoardVO> allBoardView(Map<String, Object> boardMap) {
		List<BoardVO> mainBoardList = mainDao.allBoardView(boardMap);
		return mainBoardList;
	}

}
