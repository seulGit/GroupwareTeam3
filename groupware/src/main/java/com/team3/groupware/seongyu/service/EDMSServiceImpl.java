package com.team3.groupware.seongyu.service;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.seongyu.model.EDMSDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EDMSServiceImpl implements EDMSService{

    @Autowired
    EDMSDAO edmsdao;

    @Override
    public List<EmployeeVO> selct_emp_list(EmployeeVO employeeVO) {
        return edmsdao.select_emp_list(employeeVO);
    }
}
