package com.team3.groupware.common.service;

import com.team3.groupware.common.model.DepartmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentDAO departmentDAO;

    @Override
    public Object select_dept_list() {
        return departmentDAO.select_dept_list();
    }
}
