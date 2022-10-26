package com.team3.groupware.seulgi.controller;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.seulgi.model.AdminDAO;
import com.team3.groupware.seulgi.model.AdminVO;
import com.team3.groupware.seulgi.model.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginDAO loginDao;
    @Autowired
    AdminDAO adminDao;


    //로그아웃
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String login(HttpSession session) {
        if(session.getAttribute("emp_num")!=null || session.getAttribute("emp_num")!=""){
            session.invalidate();
        }
        return "login";
    }

    //로그인
    @RequestMapping(value="/login_check", method= RequestMethod.POST)
    public ModelAndView loginPost(EmployeeVO vo, AdminVO vo2, HttpSession session, ModelAndView mv) throws Exception {

        EmployeeVO emp_info = loginDao.login_check(vo);
        AdminVO emp_info2 = adminDao.authority_info(vo2);

        //로그인 정보가 DB와 일치하는지 확인
        if(emp_info != null) { //일치할 시}

            session.setAttribute("emp_num", emp_info.getEmp_num());
            session.setAttribute("auth_code", emp_info.getAuth_code()); //권한별 사이드메뉴바 항목 구분을 위해 auth_code 받아놓음
            session.setAttribute("emp_name", emp_info.getEmp_name());
            session.setAttribute("dept_code", emp_info.getDept_code());
            session.setAttribute("dept_name", emp_info.getDept_name());
            session.setAttribute("position_grade", emp_info.getPosition_grade());

            session.setMaxInactiveInterval(1800);

            mv.addObject("emp_num", emp_info.getEmp_num());
            mv.addObject("auth_code", emp_info.getAuth_code());
            mv.addObject("message", "success");

            loginDao.saveLog(vo);


            //권한 확인(일반 Or 관리자)
            if(emp_info.getAuth_code().equals("normal")) {
                mv.setViewName("/main");
                return mv;
            }
            else if(emp_info.getAuth_code().equals("admin")) { // 관리자 계정일 시
                //메뉴 별 권한에 대한 정보를 세션에 담아둠
                session.setAttribute("authority_EDMS", emp_info2.getAuthority_EDMS());
                session.setAttribute("authority_worktime", emp_info2.getAuthority_worktime());
                session.setAttribute("authority_booking", emp_info2.getAuthority_booking());
                session.setAttribute("authority_board", emp_info2.getAuthority_board());
                session.setAttribute("authority_personnelCard", emp_info2.getAuthority_personnelCard());
                session.setAttribute("authority_loginHistory", emp_info2.getAuthority_loginHistory());
                session.setAttribute("authority_authority", emp_info2.getAuthority_authority());
//                System.out.println(emp_info2);
//                System.out.println(emp_info2.getAuthority_EDMS());
//                System.out.println(emp_info2.getAuthority_personnelCard());
                mv.setViewName("/main_admin");
                return mv;
            }
        }
        else if(emp_info == null){ //불일치할 시
            mv.addObject("message", "error");
            mv.setViewName("/login");
        }
        return mv;
    }




}
