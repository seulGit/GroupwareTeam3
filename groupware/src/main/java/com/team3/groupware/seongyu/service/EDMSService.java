package com.team3.groupware.seongyu.service;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.seongyu.model.EDMS_new_generalVO;

import java.util.List;

public interface EDMSService {

    List<EmployeeVO> selct_emp_list();

    int insert_general(EDMS_new_generalVO edms_new_generalVO);
}
