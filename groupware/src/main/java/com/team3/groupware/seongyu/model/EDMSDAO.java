package com.team3.groupware.seongyu.model;

import com.team3.groupware.common.model.EmployeeVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EDMSDAO {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    public List<EmployeeVO> select_emp_list(EmployeeVO employeeVO) {
        return sqlSessionTemplate.selectList("employee.select_emp_dept", employeeVO);
    }
}
