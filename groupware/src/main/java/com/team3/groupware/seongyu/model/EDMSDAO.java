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
        return sqlSessionTemplate.selectList("employee.select_emp_dept");
    }

    public int insert_general(EDMS_new_generalVO edms_new_generalVO) {
        int insert_docu = sqlSessionTemplate.insert("EDMS.insert_docu");
        System.out.println(edms_new_generalVO.getEDMS_docu_num());

        int insert_general = sqlSessionTemplate.insert("EDMS.insert_general");
        return 1;
    }
}
