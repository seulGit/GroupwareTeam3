package com.team3.groupware.eunji.model;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.team3.groupware.common.model.EmployeeVO;

public interface WorktimeDAO {

	void insert(WorktimeVO worktimeVo);

	List<WorktimeVO> worktime_view_select(int emp_num);
	
	Map<String, Object> select_vacation_days(int emp_num);

	// ajax dao
	List<EmployeeVO> dept_name_list(Map<String, Object> map);

	Map<String, Object> select_worktime_new_name(EmployeeVO employeeVo);

	


}
