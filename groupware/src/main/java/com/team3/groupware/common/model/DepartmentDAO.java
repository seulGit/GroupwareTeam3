package com.team3.groupware.common.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDAO {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    public Object select_dept_list() {
        return sqlSessionTemplate.selectList("department.dept_list");
    }
}
