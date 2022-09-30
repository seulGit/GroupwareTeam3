package com.team3.groupware.eunji.model;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDAOImpl implements TodoDAO {

	@Inject
	SqlSessionTemplate session;
	
	
	@Override
	public void todo_insert(Map<String, Object> map) {
		this.session.insert("todo.todo_write", map);
		
	}
	
	@Override
	public List<TodoVO> todo_board_list(int emp_num) {
		return session.selectList("todo.todo_board_list", emp_num);
	}

	
	@Override
	public TodoVO todo_board_NEW(Map<String, Object> map) {
		return session.selectOne("todo.todo_New_select", map);
	}

	@Override
	public void todo_delete(TodoVO todoVo) {
		this.session.delete("todo.todo_delete", todoVo);
	}

	




}
