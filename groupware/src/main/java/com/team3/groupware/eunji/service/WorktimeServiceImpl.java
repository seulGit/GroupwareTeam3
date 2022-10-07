package com.team3.groupware.eunji.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.eunji.model.WorktimeDAO;
import com.team3.groupware.eunji.model.WorktimeVO;

@Service
public class WorktimeServiceImpl implements WorktimeService {
	
	@Inject
	WorktimeDAO worktimeDao;

	// 출퇴근 시간 입력
	@Override
	public void insert(WorktimeVO worktimeVo) {
		this.worktimeDao.insert(worktimeVo);
	}

	// 출퇴근 시간 보이기
	@Override
	public List<WorktimeVO> worktime_view_select(int emp_num) {
		return worktimeDao.worktime_view_select(emp_num);
	}

	// 연차 보이기
	@Override
	public Map<String, Object> select_vacation_days(int emp_num) {		
		return worktimeDao.select_vacation_days(emp_num);
	}

	// ajax 연결 list 오버라이드
	// 부서 정보 보이기
	@Override
	public List<EmployeeVO> dept_name_list(Map<String, Object> map) {
		return worktimeDao.dept_name_list(map);
	}

	// 휴가계 작성 사원 정보 보이기
	@Override
	public Map<String, Object> select_worktime_new_name(int emp_num) {
		return worktimeDao.select_worktime_new_name(emp_num);
	}

	// 검색
	@Override
	public List<EmployeeVO> deptListSearch(Map<String, Object> map) {
		return worktimeDao.deptListSearch(map);
	}






}
