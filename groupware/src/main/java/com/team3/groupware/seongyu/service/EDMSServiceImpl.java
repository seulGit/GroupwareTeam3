package com.team3.groupware.seongyu.service;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.seongyu.model.EDMSDAO;
import com.team3.groupware.seongyu.model.EDMS_new_certificateVO;
import com.team3.groupware.seongyu.model.EDMS_new_expenseVO;
import com.team3.groupware.seongyu.model.EDMS_new_generalVO;
import kr.co.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class EDMSServiceImpl implements EDMSService{

    @Resource(name="fileUtils")
    private FileUtils fileUtils;

    @Autowired
    EDMSDAO edmsdao;

    @Override
    public List<EmployeeVO> selct_emp_list() {
        return edmsdao.select_emp_list();
    }

    @Override
    public void insert_general(EDMS_new_generalVO edms_new_generalVO,
                              MultipartHttpServletRequest mpRequest) throws Exception {
        edmsdao.insert_general(edms_new_generalVO);

        List<Map<String,Object>> list = fileUtils.parse_insert_file_info_general(edms_new_generalVO, mpRequest);
        int size = list.size();
        for(int i=0; i<size; i++){
            System.out.println(list.get(i));
            edmsdao.insertFile(list.get(i));
        }
    }

    @Override
    public int insert_expense(EDMS_new_expenseVO edms_new_expenseVO,
                              MultipartHttpServletRequest mpRequest) throws Exception {
        int result = edmsdao.insert_expense(edms_new_expenseVO);

        List<Map<String,Object>> list = fileUtils.parse_insert_file_info_expense(edms_new_expenseVO, mpRequest);
        int size = list.size();
        for(int i=0; i<size; i++){
            System.out.println(list.get(i));
            edmsdao.insertFile(list.get(i));
        }
        return result;
    }

    @Override
    public int insert_certificate(EDMS_new_certificateVO edms_new_certificateVO,
                                  MultipartHttpServletRequest mpRequest) throws Exception {
        int result = edmsdao.insert_certificate(edms_new_certificateVO);

        List<Map<String,Object>> list = fileUtils.parse_insert_file_info_certificate(edms_new_certificateVO, mpRequest);
        int size = list.size();
        for(int i=0; i<size; i++){
            System.out.println(list.get(i));
            edmsdao.insertFile(list.get(i));
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> select_EDMS_docu_ing(Map<String, Object> map) {
        return edmsdao.select_EDMS_docu_ing(map);
    }

    @Override
    public Map<String, Object> select_EDMS_docu_certificate(Map<String, Object> map) {
        return this.edmsdao.select_EDMS_docu_certificate(map);
    }

    @Override
    public int select_EDMS_docu_ing_length(Map<String, Object> map) {
        return this.edmsdao.select_EDMS_docu_ing_length(map);
    }

    @Override
    public List<Map<String, Object>> select_EDMS_docu_wait(Map<String, Object> map) {
        return this.edmsdao.select_EDMS_docu_wait(map);
    }

    @Override
    public int select_EDMS_docu_wait_length(Map<String, Object> map) {
        return this.edmsdao.select_EDMS_docu_wait_length(map);
    }

    @Override
    public Map<String, Object> select_EDMS_docu_general(Map<String, Object> map) {
        return this.edmsdao.select_EDMS_docu_general(map);
    }

    @Override
    public Map<String, Object> select_EDMS_docu_money(Map<String, Object> map) {
        return this.edmsdao.select_EDMS_docu_money(map);
    }

    @Override
    public List<Map<String, Object>> select_EDMS_docu_end(Map<String, Object> map) {
        return this.edmsdao.select_EDMS_docu_end(map);
    }

    @Override
    public int select_EDMS_docu_end_length(Map<String, Object> map) {
        return this.edmsdao.select_EDMS_docu_end_length(map);
    }

    @Override
    public void EDMS_docu_active_change(Map<String, Object> map) {
        this.edmsdao.EDMS_docu_active_change(map);
    }
}
