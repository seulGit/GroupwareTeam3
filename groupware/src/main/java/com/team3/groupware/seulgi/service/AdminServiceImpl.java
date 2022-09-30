package com.team3.groupware.seulgi.service;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.seulgi.model.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public List<EmployeeVO> personnelCardSearch(Map<String, Object> map) {
        return adminDAO.personnelCardSearch(map);
    }

    @Override
    public void modify(Map<String, Object> map) {
        adminDAO.modify(map);
    }

    @Override
    public List<EmployeeVO> personnelCardSearch2(Map<String, Object> map) {
        return adminDAO.personnelCardSearch2(map);
    }

    @Override
    public void delete(Map<String, Object> map) {
        adminDAO.delete(map);
    }

    @Override
    public void initPW(Map<String, Object> map) {
        adminDAO.initPW(map);
    }

    @Override
    public void insert(Map<String, Object> map) {
        adminDAO.insert(map);
    }
}
