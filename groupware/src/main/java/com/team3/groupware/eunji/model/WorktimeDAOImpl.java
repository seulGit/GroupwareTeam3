package com.team3.groupware.eunji.model;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.team3.groupware.common.model.EmployeeVO;

@Repository
public class WorktimeDAOImpl implements WorktimeDAO {
	
	@Inject
	SqlSessionTemplate session;

	// 출퇴근 시간 입력
	@Override
	public void insert(WorktimeVO worktimeVo) {	
		session.insert("worktime.worktime_view_insert", worktimeVo);
		
	}

	// 출퇴근 시간 보이기
	@Override
	public List<WorktimeVO> worktime_view_select(int emp_num) {
		return session.selectList("worktime.worktime_view_select", emp_num);
	}

	// 연차 보이기
	@Override
	public Map<String, Object> select_vacation_days(int emp_num) {	
		return session.selectOne("worktime.worktime_vacation_days", emp_num);
	}

	// ajax dao 오버라이드
	// 부서 정보 보이기
	@Override
	public List<EmployeeVO> dept_name_list(Map<String, Object> map ) {
		// TODO Auto-generated method stub
		return session.selectList("worktime.worktime_dept_info", map);
	}

	// 휴가계 작성 사원 정보 보이기
	@Override
	public Map<String, Object> select_worktime_new_name(int emp_num) {
		// TODO Auto-generated method stub
		return session.selectOne("worktime.worktime_emp_dept_name", emp_num);
	}

	// 검색
	@Override
	public List<EmployeeVO> deptListSearch(Map<String, Object> map) {
		return session.selectList("worktime.list_dept", map);
	}






}
