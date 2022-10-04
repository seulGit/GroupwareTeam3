package com.team3.groupware.eunji.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.eunji.model.WorktimeVO;

public interface WorktimeService {

	void insert(WorktimeVO worktimeVo);
	
	List<WorktimeVO> worktime_view_select(int emp_num);
	
	Map<String, Object> select_vacation_days(int emp_num);

	// ajax 연결 list
	List<EmployeeVO> dept_name_list(Map<String, Object> map);

	Map<String, Object> select_worktime_new_name(int emp_num);
	
	// 검색
	List<EmployeeVO> deptListSearch(Map<String, Object> map);




	

	
	
	

	

}
