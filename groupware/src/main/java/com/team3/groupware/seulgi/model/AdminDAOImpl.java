package com.team3.groupware.seulgi.model;

import com.team3.groupware.common.model.EmployeeVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AdminDAOImpl implements AdminDAO{

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<EmployeeVO> personnelCardSearch(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("admin.personnelCardSearch", map);

    }

    @Override
    public void modify(Map<String, Object> map) {
        sqlSessionTemplate.update("admin.personnelCardModify", map);
    }

    @Override
    public List<EmployeeVO> personnelCardSearch2(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("admin.personnelCardSearch2", map);
    }

    @Override
    public void delete(Map<String, Object> map) {
        sqlSessionTemplate.update("admin.personnelCardDelete", map);
    }

    @Override
    public void initPW(Map<String, Object> map) {
        sqlSessionTemplate.update("admin.personnelCardInitPW", map);
    }

    @Override
    public void insert(Map<String, Object> map) {
        sqlSessionTemplate.insert("admin.personnelCardRegister", map);
    }
}
