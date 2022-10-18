package com.team3.groupware.eunji.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.team3.groupware.eunji.model.TodoDAO;
import com.team3.groupware.eunji.model.TodoVO;

@Service
public class TodoServiceImpl implements TodoService {

	@Inject
	TodoDAO todoDao;
	
	// todo 내용 입력
	@Override
	public void todo_insert(Map<String, Object> map) {
		this.todoDao.todo_insert(map);
	}
	
	// todo list 보이기
	@Override
	public List<TodoVO> todo_board_list(int emp_num) {
		return todoDao.todo_board_list(emp_num);
	}

	// todo 만들기
	@Override
	public TodoVO todo_board_New(Map<String, Object> map) {
		return todoDao.todo_board_NEW(map);
	}
	
	// todo 삭제
	@Override
	public Map<String, Object> todo_delete(TodoVO todoVo) {
		return this.todoDao.todo_delete(todoVo);
		
	}

	// todo 수정
	@Override
	public void todo_modify(Map<String, Object> map) {
		this.todoDao.todo_modify(map);
	}

	// 즐겨찾기 todo
	@Override
	public void todo_favorite(Map<String, Object> map) {
		 this.todoDao.todo_favorite(map);
	}

	// 즐겨찾기 해제
	@Override
	public void todo_favorite_R(Map<String, Object> map) {
	    this.todoDao.todo_favorite_R(map);
		
	}






	

}
