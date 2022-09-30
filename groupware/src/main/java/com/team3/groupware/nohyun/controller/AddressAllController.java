package com.team3.groupware.nohyun.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.team3.groupware.nohyun.service.AddressAllService;

@RestController
public class AddressAllController {
	
	@Autowired
	AddressAllService addressAllService;
	
	@RequestMapping(value = "address_all")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		System.out.println(map.toString());
		List<Map<String, Object>> list = this.addressAllService.list(map);
		ModelAndView mv = new ModelAndView(); //
		mv.addObject("data", list);

		mv.setViewName("nohyun/address/address_all");
		return mv;

	}
	@RequestMapping(value="ajaxChosung")
	public ModelAndView list_chosung(@RequestParam Map<String, Object> chosung) {
		System.out.println(chosung.toString());
		List<Map<String, Object>> list = this.addressAllService.list_chosung(chosung);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("nohyun/address/address_all_list");
		mv.addObject("data", list);
		
		return mv;
	}
	@RequestMapping(value="ajaxChosungAll")
	public ModelAndView list_whole(@RequestParam Map<String, Object> whole) {
		System.out.println(whole.toString());
		List<Map<String, Object>> list = this.addressAllService.list_whole(whole);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("nohyun/address/address_all_list");
		mv.addObject("data", list);
		
		return mv;
	}
	
	@RequestMapping(value="ajaxSearch")
	public ModelAndView keyword_search(@RequestParam Map<String, Object> keyword) {
		
		List<Map<String, Object>> list = this.addressAllService.keyword_search(keyword);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("nohyun/address/address_all_list");
		mv.addObject("data", list);
		
		return mv;
	}
}
