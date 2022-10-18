package com.team3.groupware.eunji.model;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

public interface TodoDAO {

	// todo 생성
	void todo_insert(Map<String, Object> map);
	
	// todo 목록 
	List<TodoVO> todo_board_list(int emp_num);

	// todo 새롭게 생성
	TodoVO todo_board_NEW(Map<String, Object> map);

	// todo 삭제
	Map<String, Object> todo_delete(TodoVO todoVo);

	// todo 수정
	void todo_modify(Map<String, Object> map);

	// 즐겨찾기 todo
	void todo_favorite(Map<String, Object> map);

	// 즐겨찾기 해제
	void todo_favorite_R(Map<String, Object> map);

	

	


}
