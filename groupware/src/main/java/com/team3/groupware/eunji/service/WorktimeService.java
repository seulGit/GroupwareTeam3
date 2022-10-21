package com.team3.groupware.eunji.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.eunji.model.Vacation_annualVO;
import com.team3.groupware.eunji.model.WorktimeVO;

public interface WorktimeService {

	// 출퇴근 시간 입력
	void insert(WorktimeVO worktimeVo);
	
	// 출퇴근 시간 보이기
	List<WorktimeVO> worktime_view_select(int emp_num);
	
	// 연차 보이기
	Map<String, Object> select_vacation_days(int emp_num);

	// ajax 연결 list
	// 부서 정보 보이기
	List<EmployeeVO> dept_name_list(Map<String, Object> map);

	// 휴가계 작성 사원 정보 보이기
	Map<String, Object> select_worktime_new_name(int emp_num);
	
	// 검색
	List<EmployeeVO> deptListSearch(Map<String, Object> map);

	// 연차 신청서 입력
	void vacation_annual_insert(Map<String, Object> map);




	

	
	
	

	

}
