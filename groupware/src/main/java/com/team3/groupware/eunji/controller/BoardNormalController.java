package com.team3.groupware.eunji.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team3.groupware.eunji.model.BoardVO;
import com.team3.groupware.eunji.service.BoardService;

@Controller
public class BoardNormalController {
	
	@Inject
	BoardService boardService;
	
	// 일반 게시판
	@GetMapping("/board_normal")
	public ModelAndView boardNoraml(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		int emp_num = 0;
		
		if(session.getAttribute("emp_num") != null) {
			String change = String.valueOf(session.getAttribute("emp_num"));
			System.out.println(change);
			emp_num = Integer.parseInt(change);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/eunji/board/board_normal");
		return mv;
	}
	
	// 게시물 보기
	@GetMapping("/board_view")
	public ModelAndView board_view() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/eunji/board/board_view");
		return mv;
	}
	
	// 게시물 작성
	@GetMapping("/board_write")
	public ModelAndView board_write() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/eunji/board/board_write");
		return mv;
	}
	@PostMapping("/board_write")
	public ModelAndView board_new_write(BoardVO boardVo) {
		
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	

}
