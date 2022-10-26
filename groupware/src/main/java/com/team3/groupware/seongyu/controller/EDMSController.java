package com.team3.groupware.seongyu.controller;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.common.service.DepartmentService;
import com.team3.groupware.seongyu.model.EDMS_new_certificateVO;
import com.team3.groupware.seongyu.model.EDMS_new_expenseVO;
import com.team3.groupware.seongyu.model.EDMS_new_generalVO;
import com.team3.groupware.seongyu.service.EDMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/EDMS")
public class EDMSController {

    @Autowired
    EDMSService edmsService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/home")
    public ModelAndView EDMS_home(@RequestParam Map<String, Object> map){
        ModelAndView mv = new ModelAndView();

        map.put("crt_start_page", 0);
        map.put("crt_end_page", 3);

        List<Map<String, Object>> EDMS_wait = this.edmsService.select_EDMS_docu_wait(map);
        List<Map<String, Object>> EDMS_ing = this.edmsService.select_EDMS_docu_ing(map);
        List<Map<String, Object>> EDMS_end = this.edmsService.select_EDMS_docu_end(map);

        int ing_list_length = this.edmsService.select_EDMS_docu_ing_length(map);
        int wait_list_length = this.edmsService.select_EDMS_docu_wait_length(map);
        int end_list_length = this.edmsService.select_EDMS_docu_end_length(map);

        mv.addObject("EDMS_wait", EDMS_wait);
        mv.addObject("EDMS_ing", EDMS_ing);
        mv.addObject("EDMS_end", EDMS_end);

        mv.addObject("ing_list_length", ing_list_length);
        mv.addObject("wait_list_length", wait_list_length);
        mv.addObject("end_list_length", end_list_length);


        mv.setViewName("/seongyu/EDMS/EDMS_home");
        return mv;
    }

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

        return new ModelAndView("redirect:ing?emp_num=" + edms_new_generalVO.getEmp_num() + "&crt_page=1&crt_block=0");
    }
    @RequestMapping("money_add")
    public ModelAndView expence_add(EDMS_new_expenseVO edms_new_expenseVO,
                                    MultipartHttpServletRequest mpRequest) throws Exception{

        int insert_expence = this.edmsService.insert_expense(edms_new_expenseVO, mpRequest);

        return new ModelAndView("redirect:ing?emp_num=" + edms_new_expenseVO.getEmp_num() + "&crt_page=1&crt_block=0");
    }

    @RequestMapping("certificate_add")
    public ModelAndView certificate_add(EDMS_new_certificateVO edms_new_certificateVO,
                                        MultipartHttpServletRequest mpRequest) throws Exception{

        int insert_certificate = this.edmsService.insert_certificate(edms_new_certificateVO, mpRequest);

        return new ModelAndView("redirect:ing?emp_num=" + edms_new_certificateVO.getEmp_num() + "&crt_page=1&crt_block=0");
    }


    @GetMapping("/ing")
    public ModelAndView EDMS_ing_view(@RequestParam Map<String, Object> map){
        ModelAndView mv = new ModelAndView();

        // 페이징 처리
        String start = (String) map.get("crt_page");

        int crt_start_page = Integer.parseInt(start);
        int crt_end_page = Integer.parseInt(start);

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
        ModelAndView mv = new ModelAndView();
        if(map.get("EDMS_docu_category").equals("일반품의서")){
            Map<String, Object> edms_new_generalVO = this.edmsService.select_EDMS_docu_general(map);
            mv.addObject("docu", edms_new_generalVO);
        } else if(map.get("EDMS_docu_category").equals("비용품의서")){
            Map<String, Object> edms_new_moneyVO = this.edmsService.select_EDMS_docu_money(map);
            mv.addObject("docu", edms_new_moneyVO);
        } else if(map.get("EDMS_docu_category").equals("증명서신청")){
            Map<String, Object> edms_new_certificateVO = this.edmsService.select_EDMS_docu_certificate(map);
            mv.addObject("docu", edms_new_certificateVO);
        }

        mv.setViewName("/seongyu/EDMS/EDMS_docu");
        return mv;
    }

    @GetMapping("/end")
    public ModelAndView EDMS_end(@RequestParam Map<String, Object> map){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/seongyu/EDMS/EDMS_end");
        return mv;
    }

    @GetMapping("/wait")
    public ModelAndView EDMS_wait(@RequestParam Map<String, Object> map){
        ModelAndView mv = new ModelAndView();

        // 페이징 처리
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

    @PostMapping("/EDMS_docu_remove")
    public ModelAndView EDMS_docu_remove(@RequestParam Map<String, Object> map){
        ModelAndView mv = new ModelAndView();

        this.edmsService.EDMS_docu_active_change(map);

        mv.setViewName("redirect:home?emp_num=" + map.get("emp_num"));
        return mv;
    }

}
