package com.team3.groupware.eunji.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import com.team3.groupware.eunji.model.TodoVO;
import com.team3.groupware.eunji.service.TodoService;

@Controller
public class TodoController {

	@Inject
	TodoService todoService;
	
	// todo
	@GetMapping("/todo")
	public ModelAndView todo(TodoVO todoVo, Map<String,Object> map, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		System.out.println(session);
		// 형변환
		int emp_num = 0;
		
		if(session.getAttribute("emp_num") != null) {
			String change = String.valueOf(session.getAttribute("emp_num"));
			System.out.println(change);
			emp_num = Integer.parseInt(change);
		}
		
		mv.addObject("emp_num",session.getAttribute("emp_num"));
		mv.addObject("todoMapList",todoService.todo_board_list(emp_num));
		mv.setViewName("/eunji/todo/todo");
		return mv;
	}
		
	// todo 목록 가져오기
	@PostMapping("/todo_list")
	public ModelAndView todoList(@RequestBody Map<String,Object> map) {

		todoService.todo_insert(map);
		System.out.println(map.get("todo_num"));
		ModelAndView mv = new ModelAndView();

		// 새롭게 생성된 todo 가져오기
		mv.addObject("data", todoService.todo_board_New(map));
		mv.setViewName("/eunji/todo/todo_write");
		System.out.println(mv);
		return mv;
	}
	
	// todo 삭제
	@PostMapping("/todo_delete")
	public String todoDelete(TodoVO todoVo) {
		
		todoService.todo_delete(todoVo);
		return "redirect:/todo";
	}
	
}
