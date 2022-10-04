package com.team3.groupware.jeongchi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.common.model.PageUtil;
import com.team3.groupware.common.service.EmployeeService;
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
	
//  이메일 용
//	@RequestMapping("/send")
//	public ModelAndView send(MessageVO vo, Model model) {
//		ModelAndView mv = new ModelAndView();
//		try {
//			emailService.sendMail(vo);
//			model.addAttribute("message", "이메일이 발송되었습니다.");
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("message", "이메일 발송 실패...");
//		}
//		mv.setViewName("/jeongchi/message/message_write");
//		return mv;
//	}
	
	@PostMapping("/message/sendMessage")
	public int sendMessage(MessageVO messageVO) {
		messageService.sendMessage(messageVO);
		System.out.println(messageVO.toString());
	
		
		return 0;
	}
	
// 보내기 버튼 눌렀을 때 DB에 저장  //
//	@GetMapping("/message/write")
//	public ModelAndView write() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/jeongchi/message/message_write");
//		return mv;
//	}
	
//	@PostMapping("/message/write")
//	public ModelAndView write(MessageVO messageVo, HttpServletRequest request) {
//		System.out.println(request.getParameter("contents"));
//		System.out.println(noteVo);
//		messageService.write(messageVo);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("redirect:/message/write");
//		return mv;
//	}

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

	@PostMapping("/message/writeAddressSearch")
	public List<EmployeeVO> writeAddressSearch(@RequestParam String search_option, 
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
//	================ message_write.jsp 끝  ============== //
	
	
//	================ message_send.jsp 시작  ============== //
	@GetMapping("/message/message_send")
	public ModelAndView sendMessageList(
			@RequestParam(defaultValue = "1") int curPage,
			MessageVO messageVO, HttpServletRequest request) {	
		
		HttpSession session = request.getSession();
		String change = String.valueOf(session.getAttribute("emp_num"));
	    int emp_num = Integer.parseInt(change);
		
		int count = messageService.count(messageVO);
		System.out.println(count);
		
		PageUtil page_info = new PageUtil(count, curPage);
		int start = page_info.getPageBegin();
		int end = page_info.getPageEnd();
		
		List<MessageVO> sendMessageList = messageService.sendMessageList(start, end, messageVO, emp_num);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/jeongchi/message/message_send");
		Map<String, Object> messageMap = new HashMap<>();
		
		messageMap.put("sendMessageList", sendMessageList);
		messageMap.put("count", count);
		messageMap.put("page_info", page_info);
		System.out.println(messageMap.toString());
		mv.addObject("messageMap", messageMap);
		//mv.addObject("list", list);
		return mv;
	}
	
	@GetMapping("/message/message_receive")
	public ModelAndView receiveMessageList(
			@RequestParam(defaultValue = "1") int curPage,
			MessageVO messageVO, HttpServletRequest request) {	
		
		HttpSession session = request.getSession();
		String change = String.valueOf(session.getAttribute("emp_num"));
	    int emp_num = Integer.parseInt(change);
	    
		int count = messageService.count(messageVO);
		System.out.println(count);
		
		PageUtil page_info = new PageUtil(count, curPage);
		int start = page_info.getPageBegin();
		int end = page_info.getPageEnd();
		
		List<MessageVO> receiveMessageList = messageService.receiveMessageList(start, end, messageVO, emp_num);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/jeongchi/message/message_receive");
		Map<String, Object> messageMap2 = new HashMap<>();
		
		messageMap2.put("receiveMessageList", receiveMessageList);
		messageMap2.put("count", count);
		messageMap2.put("page_info", page_info);
		System.out.println(messageMap2.toString());
		mv.addObject("messageMap2", messageMap2);
		//mv.addObject("list", list);
		return mv;
	}
}



