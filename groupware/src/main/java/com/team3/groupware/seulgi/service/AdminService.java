package com.team3.groupware.seulgi.service;

import com.team3.groupware.common.model.EmployeeVO;

import java.util.List;
import java.util.Map;

public interface AdminService {

    //===========================================================인사기록카드
    List<EmployeeVO> personnelCardSearch(Map<String, Object> map);

    void modify(Map<String, Object> map);

    List<EmployeeVO> personnelCardSearch2(Map<String, Object> map);

    void delete(Map<String, Object> map);

    void initPW(Map<String, Object> map);

    void insert(Map<String, Object> map);

    //===========================================================접속내역조회
    List<EmployeeVO> loginHistorySearch(Map<String, Object> map);

    List<Map<String, Object>> authoritySearch(Map<String, Object> map);
}
