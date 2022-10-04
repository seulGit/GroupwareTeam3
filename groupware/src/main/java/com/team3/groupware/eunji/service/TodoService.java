package com.team3.groupware.eunji.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.team3.groupware.eunji.model.TodoVO;

public interface TodoService {

	// todo 불러오기
	List<TodoVO> todo_board_list(int emp_num);

	// todo 생성
	void todo_insert(Map<String, Object> map);

	// todo 새롭게 생성
	TodoVO todo_board_New(Map<String, Object> map);

	// todo 삭제
	Map<String, Object> todo_delete(TodoVO todoVo);

	// todo 수정
	void todo_modify(Map<String, Object> map);




}
