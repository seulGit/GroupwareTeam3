package com.team3.groupware.eunji.model;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.team3.groupware.common.model.EmployeeVO;

public interface WorktimeDAO {

	// 출퇴근 시간 입력
	void insert(WorktimeVO worktimeVo);

	// 출퇴근 시간 보이기
	List<WorktimeVO> worktime_view_select(int emp_num);
	
	// 연차 보이기
	Map<String, Object> select_vacation_days(int emp_num);

	// 부서 정보 보이기 ajax
	List<EmployeeVO> dept_name_list(Map<String, Object> map);

	// 휴가계 작성 사원 정보 보이기
	Map<String, Object> select_worktime_new_name(int emp_num);

	// 검색
	List<EmployeeVO> deptListSearch(Map<String, Object> map);

	


}
