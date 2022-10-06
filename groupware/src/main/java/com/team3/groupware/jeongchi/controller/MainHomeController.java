package com.team3.groupware.jeongchi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.team3.groupware.common.service.MainService;
import com.team3.groupware.eunji.model.BoardVO;


@RestController
public class MainHomeController {
	
	@Autowired
	MainService mainService;

	@GetMapping("/mainView")
	public List<BoardVO> mainView(HttpServletRequest request) {
		
		String board_category_num = request.getParameter("board_category_num");
		Map<String, Object> boardMap = new HashMap<>();
		boardMap.put("board_category_num", board_category_num);
		List<BoardVO> mainBoardList = mainService.allBoardView(boardMap);
		
		return mainBoardList;
	}
	
	@GetMapping("/mainAllBoardView")
	public List<BoardVO> allBoardView(HttpServletRequest request) {
		
		String board_category_num = request.getParameter("board_category_num");
		Map<String, Object> boardMap = new HashMap<>();
		boardMap.put("board_category_num", board_category_num);
		List<BoardVO> mainBoardList = mainService.allBoardView(boardMap);
		
		return mainBoardList;
	}


}