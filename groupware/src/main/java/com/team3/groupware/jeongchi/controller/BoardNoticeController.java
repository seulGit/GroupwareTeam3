package com.team3.groupware.jeongchi.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.team3.groupware.eunji.model.BoardVO;
import com.team3.groupware.eunji.service.BoardService;

@RestController
public class BoardNoticeController {
	
	@Inject
	BoardService boardService;
	
	// 일반 게시판
	@GetMapping("/board_notice")
	public ModelAndView boardNotice(BoardVO boardVo, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		int emp_num = 0;
		
		
		if(session.getAttribute("emp_num") != null) {
			String change = String.valueOf(session.getAttribute("emp_num"));
			List<BoardVO> boardNoticeList = boardService.board_selectNTList(boardVo);
			mv.addObject("boardNoticeList", boardNoticeList);
		}
		mv.setViewName("/jeongchi/board/board_notice");
		return mv;
	}

}
