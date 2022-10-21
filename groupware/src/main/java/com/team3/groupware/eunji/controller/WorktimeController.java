package com.team3.groupware.eunji.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.team3.groupware.eunji.model.Vacation_annualVO;
import com.team3.groupware.eunji.model.WorktimeVO;
import com.team3.groupware.eunji.service.WorktimeService;

@RestController
public class WorktimeController {

	@Inject
	WorktimeService worktimeService;
	
	// 근태관리 홈
	@GetMapping("/worktime")
	public ModelAndView worktime(WorktimeVO worktimeVo, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		
		int emp_num = 0;
		// 로그인 했을 경우
		if(session.getAttribute("emp_num") != null) {
			String change = String.valueOf(session.getAttribute("emp_num"));
			emp_num = Integer.parseInt(change);
			
			Map<String, Object> worktimeMap = worktimeService.select_vacation_days(emp_num);
			mv.addObject("worktimeMap", worktimeMap);
			mv.addObject("emp_num",session.getAttribute("emp_num"));
			mv.setViewName("/eunji/worktime/worktime");
		}

		return mv;
	}
	
	// worktime 메인에서 출퇴근 현황 버튼 클릭 시 데이터가 출퇴근 현황 페이지에 출력될 수 있도록 
	@PostMapping("/worktime")
	public ModelAndView worktimeVies(WorktimeVO worktimeVo) {
		Map<String, Object> worktimeMap = new HashMap<>();
		
		worktimeMap.put("worktime_go", worktimeVo.getWorktime_go());
		worktimeMap.put("worktime_out", worktimeVo.getWorktime_out());
		
		// 값이 있을 때 데이터 입력
		if(worktimeMap.values() != null) {
			worktimeService.insert(worktimeVo);
			return new ModelAndView("redirect:/worktime");
		// 값이 없을 때 데이터 입력 안됨
		} else {
			return new ModelAndView();
		}
		
	}
	
	// 출퇴근 현황
	@GetMapping("/worktime_view")
	public ModelAndView worktimeView(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		
		String change = String.valueOf(session.getAttribute("emp_num"));
		int emp_num = Integer.parseInt(change);
		
		List<WorktimeVO> list = worktimeService.worktime_view_select(emp_num);
		mv.addObject("worktime_view_list", list);
		mv.setViewName("/eunji/worktime/worktime_view");
		return mv;
	}
	
	// 휴가계 신청
	@GetMapping("/vacation_new")
	public ModelAndView worktimeNew(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		String change = String.valueOf(session.getAttribute("emp_num"));
		int emp_num = Integer.parseInt(change);
		
		Map<String, Object> WorktimeNameMap = worktimeService.select_worktime_new_name(emp_num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("WorktimeNameMap", WorktimeNameMap);
		mv.setViewName("/eunji/worktime/vacation_new");
		return mv;
	}
	
	
	// 승인 대기중
	@GetMapping("/vacation_wait")
	public ModelAndView worktimeWait() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/eunji/worktime/vacation_wait");
		return mv;
	}
	
	// 진행준 문서
	@GetMapping("/vacation_ing")
	public ModelAndView worktimeIng() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/eunji/worktime/vacation_ing");
		return mv;
	}
	
	// 완료문서
	@GetMapping("/vacation_end")
	public ModelAndView worktimeEnd() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/eunji/worktime/vacation_end");
		return mv;
	}
	
	// 휴가계 신청 조직도 클릭 시 ajax
	@PostMapping("/worktime_dept")
	public ModelAndView deptList(@RequestBody Map<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", worktimeService.dept_name_list(map));
		mv.setViewName("/eunji/worktime/worktime_deptList");	
		return mv;
	}
	
	// 조직도 버튼 모달 창의 검색
	@PostMapping("/worktime_deptSearch")
	public ModelAndView deptListSearch(@RequestBody Map<String,Object> map) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", worktimeService.deptListSearch(map));
		mv.setViewName("/eunji/worktime/worktime_deptList");
		return mv;
	}
	
	// 휴가계 종류 선택 시 휴가신청서 폼 변경
	// 연차
	@PostMapping("/vacation_annual")
	public ModelAndView worktime_vacation(HttpServletRequest request, @RequestBody Map<String,Object> map) {
		System.out.println(map);
		HttpSession session = request.getSession();
		
		String change = String.valueOf(session.getAttribute("emp_num"));
		int emp_num = Integer.parseInt(change);
		
		Map<String, Object> WorktimeNameMap = worktimeService.select_worktime_new_name(emp_num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("WorktimeNameMap", WorktimeNameMap);
	
		if(map.get("vacation").equals("annual")) {
			mv.setViewName("eunji/worktime/vacation_annual");		
		
		} else if(map.get("vacation").equals("halfway")) {
			mv.setViewName("eunji/worktime/vacation_halfway");
		
		} else if(map.get("vacation").equals("sick_leave")) {
			mv.setViewName("eunji/worktime/vacation_sick_leave");
		
		} else if(map.get("vacation").equals("early_departure")) {
			mv.setViewName("eunji/worktime/vacation_early_departure");
		
		} else if(map.get("vacation").equals("outing")) {
			mv.setViewName("eunji/worktime/vacation_outing");
		}
		return mv;
	}
	
	// 연차 데이터 넣기
	@PostMapping("/vacation_insert")
	public ModelAndView vacation_annaul_insert(@RequestParam Map<String,Object> map) {
		System.out.println(map);
		/* worktimeService.vacation_annual_insert(map); */
		
		/*
		 * if(map.get("vacation").equals("annual")) {
		 * worktimeService.vacation_annual_insert(annualVo);
		 * 
		 * } else if(map.get("vacation").equals("halfway")) {
		 * 
		 * 
		 * } else if(map.get("vacation").equals("sick_leave")) {
		 * 
		 * 
		 * } else if(map.get("vacation").equals("early_departure")) {
		 * 
		 * 
		 * } else if(map.get("vacation").equals("outing")) {
		 * 
		 * }
		 */
		return new ModelAndView("redirect:/vacation_ing");
	}
	
	
	
	
	
}
