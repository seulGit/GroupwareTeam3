package com.team3.groupware.seulgi.model;

import com.team3.groupware.common.model.EmployeeVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements  LoginDAO{

    @Autowired
    SqlSessionTemplate sqlSessionTemplate; 

    @Override
    public EmployeeVO login_check(EmployeeVO vo) {
        EmployeeVO ll = sqlSessionTemplate.selectOne("login.login_check", vo);
        return ll;
    }

    @Override
    public void saveLog(EmployeeVO vo) {
        sqlSessionTemplate.insert("login.saveLog", vo);
    }
}
