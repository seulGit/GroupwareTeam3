package com.team3.groupware.eunji.model;

import java.util.List;
import java.util.Map;

public interface TodoDAO {

	void todo_insert(Map<String, Object> map);
	
	List<TodoVO> todo_board_list(int emp_num);

	TodoVO todo_board_NEW(Map<String, Object> map);

	void todo_delete(TodoVO todoVo);

	


}
