package com.team3.groupware.seongyu.service;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.seongyu.model.EDMSDAO;
import com.team3.groupware.seongyu.model.EDMS_new_generalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EDMSServiceImpl implements EDMSService{

    @Autowired
    EDMSDAO edmsdao;

    @Override
    public List<EmployeeVO> selct_emp_list() {
        return edmsdao.select_emp_list();
    }

    @Override
    public int insert_general(EDMS_new_generalVO edms_new_generalVO) {
        return edmsdao.insert_general(edms_new_generalVO);
    }
}
