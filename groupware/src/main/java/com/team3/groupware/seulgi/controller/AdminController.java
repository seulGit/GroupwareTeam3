package com.team3.groupware.seulgi.controller;

import com.team3.groupware.common.model.EmployeeDAO;
import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.common.service.EmployeeService;
import com.team3.groupware.seulgi.model.LoginDAO;
import com.team3.groupware.seulgi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AdminService adminService;


    //인사기록카드
    //인사기록카드 페이지 view
    @GetMapping ("/admin/admin_personnelCard")
    public ModelAndView personnelCard() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/seulgi/admin/admin_personnelCard");
        return mv;
    }

    //사원정보 검색
    @PostMapping("/admin/admin_personnelCard/search")
    public ModelAndView personnelCardSearch(@RequestBody Map<String, Object> map) {
        ModelAndView mv = new ModelAndView();
//        List<EmployeeVO> vv = adminService.personnelCardSearch(map);
//        for(int i = 0; i < vv.size(); i++){
//            System.out.println(vv.get(i).getLeave_date());
//        }

//        System.out.println(adminService.personnelCardSearch(map));
        mv.addObject("data", adminService.personnelCardSearch(map));
        mv.setViewName("/seulgi/admin/admin_personnelCard_searchList");

        return mv;
    }


    //사원정보 수정
    @PostMapping("/admin/admin_personnelCard/modify")
    @ResponseBody
    public ModelAndView personnelCardModify(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Map<String, Object> map) {
        adminService.initPW(map);
        adminService.modify(map);
        adminService.personnelCardSearch(map);

        ModelAndView mv = new ModelAndView();
        mv.addObject("data", adminService.personnelCardSearch2(map));
        mv.setViewName("/seulgi/admin/admin_personnelCard_searchList");

        return mv;
    }

    //사원정보 등록
    @GetMapping ("/admin/admin_personnelCardRegister")
    public ModelAndView personnelCardRegister() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/seulgi/admin/admin_personnelCardRegister");
        return mv;
    }

    @PostMapping("/admin/admin_personnelCardRegister")
    @ResponseBody
    public void personnelCardRegister(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Map<String, Object> map) {
        adminService.insert(map);
    }

    //사원정보 삭제
    @PostMapping("/admin/admin_personnelCard/delete")
    @ResponseBody
    public ModelAndView personnelCardDelete(@RequestParam Map<String, Object> map) {

        adminService.delete(map);

        ModelAndView mv = new ModelAndView();
        mv.addObject("data", adminService.personnelCardSearch2(map));
        mv.setViewName("/seulgi/admin/admin_personnelCard_searchList");

        return mv;
    }



}
