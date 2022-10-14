package com.team3.groupware.seongyu.controller;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.common.service.DepartmentService;
import com.team3.groupware.seongyu.model.EDMS_new_certificateVO;
import com.team3.groupware.seongyu.model.EDMS_new_expenseVO;
import com.team3.groupware.seongyu.model.EDMS_new_generalVO;
import com.team3.groupware.seongyu.service.EDMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/EDMS")
public class EDMSController {

    @Autowired
    EDMSService edmsService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/new")
    public ModelAndView EDMS_new(){
        ModelAndView mv = new ModelAndView();
        List<EmployeeVO> vo = edmsService.selct_emp_list();

        mv.addObject("emp_info", vo);
        mv.setViewName("/seongyu/EDMS/EDMS_new");

        return mv;
    }

    @PostMapping("general")
    public ModelAndView EDMS_new_general(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/seongyu/EDMS/general");
        return mv;
    }

    @PostMapping("money")
    public ModelAndView EDMS_new_money(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/seongyu/EDMS/money");
        return mv;
    }

    @PostMapping("certificate")
    public ModelAndView EDMS_new_certificate(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/seongyu/EDMS/certificate");
        return mv;
    }

    @RequestMapping("general_add")
    public ModelAndView general_add(EDMS_new_generalVO edms_new_generalVO,
                                    MultipartHttpServletRequest mpRequest) throws Exception{

        edmsService.insert_general(edms_new_generalVO, mpRequest);

        return new ModelAndView("redirect:EDMS/ing");
    }
    @RequestMapping("money_add")
    public ModelAndView expence_add(EDMS_new_expenseVO edms_new_expenseVO,
                                    MultipartHttpServletRequest mpRequest) throws Exception{

        int insert_expence = this.edmsService.insert_expense(edms_new_expenseVO, mpRequest);

        return new ModelAndView("redirect:EDMS/ing");
    }

    @RequestMapping("certificate_add")
    public ModelAndView certificate_add(EDMS_new_certificateVO edms_new_certificateVO,
                                        MultipartHttpServletRequest mpRequest) throws Exception{

        int insert_certificate = this.edmsService.insert_certificate(edms_new_certificateVO, mpRequest);

        return new ModelAndView("redirect:EDMS/ing");
    }


    @GetMapping("/ing")
    public ModelAndView EDMS_home_view(@RequestParam Map<String, Object> map){
        ModelAndView mv = new ModelAndView();

        String start = (String) map.get("crt_page");

        int crt_start_page = Integer.parseInt(start);
        int crt_end_page = Integer.parseInt(start);

        System.out.println(crt_start_page);
        map.put("crt_start_page", crt_start_page * 10 - 10);
        map.put("crt_end_page", crt_end_page * 10);
        List<Map<String, Object>> list = this.edmsService.select_EDMS_docu_ing(map);
        int list_length = this.edmsService.select_EDMS_docu_ing_length(map);

        mv.addObject("EDMS_length", list_length);
        mv.addObject("EDMS_list", list);
        mv.setViewName("/seongyu/EDMS/EDMS_ing");
        return mv;
    }

    @GetMapping("/docu")
    public ModelAndView EDMS_docu(@RequestParam Map<String, Object> map){
        Map<String, Object> edms_new_certificateVO = this.edmsService.select_EDMS_docu_certificate(map);
        ModelAndView mv = new ModelAndView();
        mv.addObject("docu", edms_new_certificateVO);
        mv.setViewName("/seongyu/EDMS/EDMS_docu");
        return mv;
    }

    @GetMapping("/end")
    public ModelAndView EDMS_home(@RequestParam Map<String, Object> map){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/seongyu/EDMS/EDMS_end");
        return mv;
    }

    @GetMapping("/wait")
    public ModelAndView EDMS_wait(@RequestParam Map<String, Object> map){
        ModelAndView mv = new ModelAndView();

        String start = (String) map.get("crt_page");

        int crt_start_page = Integer.parseInt(start);
        int crt_end_page = Integer.parseInt(start);

        map.put("crt_start_page", crt_start_page * 10 - 10);
        map.put("crt_end_page", crt_end_page * 10);
        int list_length = this.edmsService.select_EDMS_docu_wait_length(map);

        List<Map<String, Object>> list = this.edmsService.select_EDMS_docu_wait(map);

        mv.addObject("EDMS_length", list_length);
        mv.addObject("EDMS_list", list);

        mv.setViewName("/seongyu/EDMS/EDMS_wait");
        return mv;
    }

}
