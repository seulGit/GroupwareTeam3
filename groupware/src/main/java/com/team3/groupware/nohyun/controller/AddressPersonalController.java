package com.team3.groupware.nohyun.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.team3.groupware.nohyun.service.AddressPersonalService;

@RestController
public class AddressPersonalController {

	@Autowired
	AddressPersonalService addressPersonalService;
	@RequestMapping(value = "address_personal")
	public ModelAndView main() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("nohyun/address/address_personal");
		return mv;
	}
	
//	@RequestMapping(value = "ajaxCategory")
//	public ModelAndView Category(@RequestParam Map<String, Object> map) {
//		
//		List<Map<String, Object>> AddCategory = this.addressPersonalService.AddCategory(map); // insert
//		List<Map<String, Object>> SearchCategory = this.addressPersonalService.SearchCategory(map); // select
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("nohyun/address/address_personal_category");
//		mv.addObject("categoryData",SearchCategory);
//		return mv;
//	}
	
//	@RequestMapping(value="/insert", method = RequestMethod.GET)
//	public String insert() {
//		
//		return "nohyun/address/address_personal";
//	}
	
}
