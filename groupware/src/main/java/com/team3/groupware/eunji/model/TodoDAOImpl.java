package com.team3.groupware.eunji.model;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository
public class TodoDAOImpl implements TodoDAO {

	@Inject
	SqlSessionTemplate session;
	
	// todo 생성
	@Override
	public void todo_insert(Map<String, Object> map) {
		this.session.insert("todo.todo_write", map);		
	}
	
	// todo 목록 가져오기
	@Override
	public List<TodoVO> todo_board_list(int emp_num) {
		return session.selectList("todo.todo_board_list", emp_num);
	}

	// todo 새롭게 생성
	@Override
	public TodoVO todo_board_NEW(Map<String, Object> map) {
		return session.selectOne("todo.todo_New_select", map);
	}

	// todo 삭제
	@Override
	public Map<String, Object> todo_delete(TodoVO todoVo) {
		System.out.println(todoVo);
		return session.selectOne("todo.todo_delete", todoVo);
	}


	// todo 수정
	@Override
	public void todo_modify(Map<String, Object> map) {
		this.session.selectOne("todo.todo_modify", map);	
	}

	// 즐겨찾기 todo
	@Override
	public void todo_favorite(Map<String, Object> map) {
		this.session.selectList("todo.todo_favorite", map);
	}

	// 즐겨찾기 해제
	@Override
	public void todo_favorite_R(Map<String, Object> map) {
		this.session.update("todo.todo_favorite_R", map);
		
	}

	




}
