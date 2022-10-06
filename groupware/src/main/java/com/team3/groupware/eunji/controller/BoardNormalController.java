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
import org.springframework.web.bind.annotation.RequestBody;
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
		mv.setViewName("/eunji/board/board_normalList");
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
	
	// 게시글 검색
	@PostMapping("/board_search")
	public ModelAndView board_search(@RequestBody Map<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("search",boardService.board_search(map));
		mv.setViewName("/eunji/board/board_search");
		return mv;
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
	public ModelAndView board_view(@RequestParam Map<String,Object> map, BoardVO boardVo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/eunji/board/board_detail");
		mv.addObject("detailMap", boardService.board_detail(map));
		
		// 게시글 조회수 증가
		int board_num = boardVo.getBoard_num();
		boardService.board_view_plus(board_num);

		List<Map<String, Object>> board_comment = boardService.board_comment_select(board_num);
		mv.addObject("board_comment", board_comment);
		
		
		return mv;
	}
	
	// 게시물 디테일 페이지에서 수정 버튼 클릭 시 데이터 가져오기
	@GetMapping("/board_modify")
	public ModelAndView board_modify(@RequestParam Map<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		 Map<String, Object> detailMap = boardService.board_detail(map);
		mv.addObject("detailMap", detailMap);
		mv.setViewName("/eunji/board/board_modify");
		return mv;
	}
	
	// 게시물 디테일 페이지에서 수정 
	@PostMapping("/board_modify")
	public ModelAndView board_modify(BoardVO boardVo) {
		ModelAndView mv = new ModelAndView();
		boardService.board_modify(boardVo);
		int board_num = boardVo.getBoard_num();
		mv.setViewName("redirect:/board_detail?board_num=" + board_num);
		return mv;
	}
	
	// 게시글 삭제
		@PostMapping("/board_delete")
		public ModelAndView board_delete(BoardVO boardVo) {
			ModelAndView mv = new ModelAndView();
			int board_num = boardVo.getBoard_num();
			boardService.board_delete(boardVo);
			mv.setViewName("redirect:/board_normal");
			return mv;
		}
		
		// 게시판 댓글 입력
		@PostMapping("/board_comment")
		public ModelAndView board_comment(@RequestParam Map<String,Object> map) {
			ModelAndView mv = new ModelAndView();		
			String cast = (String)map.get("board_num");
			int board_num = Integer.parseInt(cast);
			boardService.board_comment_insert(map);
			mv.setViewName("redirect:/board_detail?board_num=" + board_num);
			return mv;
		}
		
		@PostMapping("/comment_delete")
		public ModelAndView comment_delete(@RequestParam Map<String, Object> map) {
			ModelAndView mv = new ModelAndView();
			System.out.println(map);
			String cast = (String)map.get("board_num");
			int board_num = Integer.parseInt(cast);
			
			boardService.comment_delete(map);
			mv.setViewName("redirect:/board_detail?board_num=" + board_num);
			return mv;
		}
		
	}

	
	

