package com.team3.groupware.eunji.controller;



import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team3.groupware.eunji.model.BoardVO;
import com.team3.groupware.eunji.service.BoardService;

@Controller
public class BoardNormalController {
	
	@Inject
	BoardService boardService;
	
	// 일반 게시판
	@GetMapping("/board_normal")
	public ModelAndView boardNoraml(BoardVO boardVo, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		int emp_num = 0;
		
		if(session.getAttribute("emp_num") != null) {
			String change = String.valueOf(session.getAttribute("emp_num"));
			List<BoardVO> boardNormalList = boardService.board_selectList(boardVo);
			mv.addObject("boardNormalList", boardNormalList);
		}
		mv.setViewName("/eunji/board/board_normal");
		return mv;
	}
	
	// 게시물 작성
	@GetMapping("/board_write")
	public ModelAndView board_write(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		// 사원이름이 작성자에 보일 수 있도록 세션에서 이름 가져옴
		session.getAttribute("emp_name");
		String emp_name = String.valueOf(session.getAttribute("emp_name"));
		
		int emp_num = 0;
		// 로그인이 되어있는지 확인
		if(session.getAttribute("emp_num") != null) {
			String change = String.valueOf(session.getAttribute("emp_num"));
			mv.setViewName("/eunji/board/board_write");
			return mv;
		} else {
			// 로그인되지 않았다면 로그인페이지로 이동
			mv.setViewName("/login");
			return mv;
		}
	}
	
	// 게시물 작성 DB로 전송
	@PostMapping("/board_write")
	public ModelAndView board_new_write(@Valid BoardVO boardVo) {

		ModelAndView mv = new ModelAndView();
		boardService.board_write_insert(boardVo);
		mv.setViewName("redirect:/board_normal");
		return mv;
		}
	
	// 게시물 디테일 페이지
	@GetMapping("/board_detail")
	public ModelAndView board_view(@RequestParam Map<String,Object> map) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/eunji/board/board_detail");
		System.out.println(boardService.board_detail(map));
		mv.addObject("detailMap", boardService.board_detail(map));
		return mv;
	}
		
	}

	
	

