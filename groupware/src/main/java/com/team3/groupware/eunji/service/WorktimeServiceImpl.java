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

	@Override
	public void insert(WorktimeVO worktimeVo) {
		
		this.worktimeDao.insert(worktimeVo);
	}

	@Override
	public List<WorktimeVO> worktime_view_select(int emp_num) {
		// TODO Auto-generated method stub
		return worktimeDao.worktime_view_select(emp_num);
	}

	
	@Override
	public Map<String, Object> select_vacation_days(int emp_num) {
		
		return worktimeDao.select_vacation_days(emp_num);
	}

	// ajax 연결 list 오버라이드
	@Override
	public List<EmployeeVO> dept_name_list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return worktimeDao.dept_name_list(map);
	}

	@Override
	public Map<String, Object> select_worktime_new_name(int emp_num) {
		// TODO Auto-generated method stub
		return worktimeDao.select_worktime_new_name(emp_num);
	}

	// 검색
	@Override
	public List<EmployeeVO> deptListSearch(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return worktimeDao.deptListSearch(map);
	}






}
