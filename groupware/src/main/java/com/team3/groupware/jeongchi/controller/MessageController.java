package com.team3.groupware.jeongchi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.common.service.EmployeeService;
import com.team3.groupware.jeongchi.model.EmailVO;
import com.team3.groupware.jeongchi.model.MessageCriteria;
import com.team3.groupware.jeongchi.model.MessageVO;
import com.team3.groupware.jeongchi.service.EmailService;
import com.team3.groupware.jeongchi.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/message/write")
	public ModelAndView write() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/jeongchi/message/message_write");
		return mv;
	}
	
	@RequestMapping("/send")
	public ModelAndView send(MessageVO vo, Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			emailService.sendMail(vo);
			model.addAttribute("message", "이메일이 발송되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "이메일 발송 실패...");
		}
		mv.setViewName("/jeongchi/message/message_write");
		return mv;
	}
	
// 보내기 버튼 눌렀을 때 DB에 저장  //
//	@GetMapping("/message/write")
//	public ModelAndView write() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/jeongchi/message/message_write");
//		return mv;
//	}
	
	@PostMapping("/message/write")
	public ModelAndView write(MessageVO messageVo, HttpServletRequest request) {
//		System.out.println(request.getParameter("contents"));
//		System.out.println(noteVo);
		messageService.write(messageVo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/message/write");
		return mv;
	}

// === 쪽지함의 쪽지쓰기의 주소록에서 조직 클릭한 경우(ajax) === //
	@GetMapping("/message/writeAddress")
	public List<EmployeeVO> writeAddress(HttpServletRequest request) {
//		public List<EmployeeDTO> writeAddress(@RequestParam List<EmployeeDTO> empMap) {
		String dept_code = request.getParameter("dept_code");
		// System.out.println("모달창에서 클릭한 부서 번호 ==> " + fk_dept_no);
		Map<String, Object> empMap = new HashMap<>();
		empMap.put("dept_code", dept_code);
		// 부서에 따른 사원조회
		List<EmployeeVO> empList = empService.writeAddress(empMap);
		
		return empList;
	}
//	@PostMapping("/message/writeAddressSearch")
//	public ModelAndView writeAddressSearch(
//			@RequestParam(defaultValue = "all") String search_option, 
//			@RequestParam(defaultValue = "" ) String keyword, 
//			@RequestBody Map<String, Object> map) {
////		public List<EmployeeDTO> writeAddress(@RequestParam List<EmployeeDTO> empMap) {
//		ModelAndView mv = new ModelAndView();
//		List<EmployeeVO> writeAddressSearch = messageService.writeAddressSearch(map);
//		
//		mv.addObject("writeAddress", writeAddressSearch);
//		mv.setViewName("/jeongchi/message/writeAddressSeartch");
//		// System.out.println("모달창에서 클릭한 부서 번호 ==> " + fk_dept_no);
//		
//		// 부서에 따른 사원조회
//		return mv;
//	}
	
//	@PostMapping("/message/writeAddressSearch")
//	public ModelAndView writeAddressSearch(@RequestParam(defaultValue = "all") String search_option, 
//			@RequestParam(defaultValue = "" ) String keyword) {
//		
//		List<EmployeeVO> addSearchList = messageService.writeAddressSearch(search_option, keyword);
//		ModelAndView mv = new ModelAndView();
//		Map<String, Object> addSearchMap = new HashMap<>();
//		System.out.println(addSearchList);
//		System.out.println(addSearchMap);
//		addSearchMap.put("addSearchList", addSearchList);
//		addSearchMap.put("search_option", search_option);
//		addSearchMap.put("keyword", keyword);
//		mv.addObject("addSearchData", addSearchMap);
//		mv.setViewName("/jeongchi/message/messageAddressSearch");
//		System.out.println(mv);
//		return mv;
//	}

	@PostMapping("/message/writeAddressSearch")
	public List<EmployeeVO> writeAddressSearch(@RequestParam(defaultValue = "all") String search_option, 
			@RequestParam(defaultValue = "" ) String keyword) {
		
		Map<String, Object> addSearchMap = new HashMap<>();
		System.out.println(addSearchMap);
		addSearchMap.put("search_option", search_option);
		addSearchMap.put("keyword", keyword);
		System.out.println(addSearchMap);
		// 부서에 따른 사원조회
		List<EmployeeVO> addSearchList = messageService.writeAddressSearch(addSearchMap, search_option, keyword);
		return addSearchList;
	}
	@GetMapping("/message/message_send")
	public ModelAndView sendMessage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/jeongchi/message/message_send");
		return mv;
	}
}