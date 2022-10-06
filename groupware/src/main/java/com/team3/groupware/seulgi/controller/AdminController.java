package com.team3.groupware.seulgi.controller;

import com.team3.groupware.common.service.EmployeeService;
import com.team3.groupware.seulgi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AdminService adminService;

    //===========================================================인사기록카드
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
    //사원정보 등록페이지 출력
    @GetMapping ("/admin/admin_personnelCardRegister")
    public ModelAndView personnelCardRegister() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/seulgi/admin/admin_personnelCardRegister");
        return mv;
    }

    //사원정보 등록
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




    //===========================================================접속내역조회
    //접속내역조회 페이지 출력
    @GetMapping("/admin/admin_loginHistory")
    public ModelAndView loginHistory() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/seulgi/admin/admin_loginHistory");
        return mv;
    }

    //접속내역조회 검색
    @PostMapping("/admin/admin_loginHistory/search")
    public ModelAndView loginHistorySearch(@RequestBody Map<String, Object> map) {

        ModelAndView mv = new ModelAndView();

        mv.addObject("data", adminService.loginHistorySearch(map));
        mv.setViewName("/seulgi/admin/admin_loginHistory_searchList");

        return mv;
    }




    //===========================================================권한관리
    //권한관리 페이지 출력
    @GetMapping("/admin/admin_authority")
    public ModelAndView authority() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/seulgi/admin/admin_authority");
        return mv;
    }

    //권한 검색
    @PostMapping("/admin/admin_authority/search")
    public ModelAndView authoritySearch(@RequestBody Map<String, Object> map) {

        System.out.println(map);

        ModelAndView mv = new ModelAndView();

        mv.addObject("data", adminService.authoritySearch(map));
        mv.setViewName("/seulgi/admin/admin_authority_searchList");

        System.out.println(adminService.authoritySearch(map));

        return mv;
    }


}
