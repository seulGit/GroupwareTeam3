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

    int insert_expense(EDMS_new_expenseVO edms_new_expenseVO);

    int insert_certificate(EDMS_new_certificateVO edms_new_certificateVO);

    List<Map<String, Object>> select_EDMS_docu_ing(Map<String, Object> map);
}
