package com.team3.groupware.seongyu.service;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.seongyu.model.EDMS_new_certificateVO;
import com.team3.groupware.seongyu.model.EDMS_new_expenseVO;
import com.team3.groupware.seongyu.model.EDMS_new_generalVO;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Map;

public interface EDMSService {

    List<EmployeeVO> selct_emp_list();

    void insert_general(EDMS_new_generalVO edms_new_generalVO,
                       MultipartHttpServletRequest mpRequest) throws Exception;

    int insert_expense(EDMS_new_expenseVO edms_new_expenseVO,
                       MultipartHttpServletRequest mpRequest) throws Exception;

    int insert_certificate(EDMS_new_certificateVO edms_new_certificateVO,
                           MultipartHttpServletRequest mpRequest) throws Exception;

    List<Map<String, Object>> select_EDMS_docu_ing(Map<String, Object> map);

    Map<String, Object> select_EDMS_docu_certificate(Map<String, Object> map);

    int select_EDMS_docu_ing_length(Map<String, Object> map);

    List<Map<String, Object>> select_EDMS_docu_wait(Map<String, Object> map);

    int select_EDMS_docu_wait_length(Map<String, Object> map);

    Map<String, Object> select_EDMS_docu_general(Map<String, Object> map);

    Map<String, Object> select_EDMS_docu_money(Map<String, Object> map);

    List<Map<String, Object>> select_EDMS_docu_end(Map<String, Object> map);

    int select_EDMS_docu_end_length(Map<String, Object> map);

    void EDMS_docu_active_change(Map<String, Object> map);
}
