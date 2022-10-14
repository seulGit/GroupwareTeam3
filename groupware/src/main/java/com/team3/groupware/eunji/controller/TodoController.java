package com.team3.groupware.eunji.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.team3.groupware.eunji.model.TodoVO;
import com.team3.groupware.eunji.service.TodoService;

@Controller
public class TodoController {

	@Inject
	TodoService todoService;
	
	// todo
	@GetMapping("/todo")
	public ModelAndView todo(Map<String,Object> map, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		// 형변환
		int emp_num = 0;
		
		if(session.getAttribute("emp_num") != null) {
			String change = String.valueOf(session.getAttribute("emp_num"));
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
		ModelAndView mv = new ModelAndView();

		// 새롭게 생성된 todo 가져오기
		mv.addObject("data", todoService.todo_board_New(map));
		mv.setViewName("/eunji/todo/todo_write");
		return mv;
	}
	
	// todo 삭제
	@PostMapping("/todo_delete")
	public ModelAndView todoDelete(TodoVO todoVo) {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> todoDelMap = todoService.todo_delete(todoVo);
		mv.setViewName("redirect:/todo");
		mv.addObject("todoDelMap", todoDelMap);
		return mv;
	}
	
	// todo 수정
	@PostMapping("/todo_modify")
	@ResponseBody
	// 수정 삭제같은 리턴이 필요없을 경우 responsebody를 사용해서 응답받을 수 있음
	public void todoModify(@RequestBody Map<String,Object> map) {
		 todoService.todo_modify(map);
	   }
}
