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

    public List<EmployeeVO> select_emp_list() {
        return sqlSessionTemplate.selectList("employee.select_list");
    }
}
