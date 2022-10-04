package com.team3.groupware.seongyu.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CalendarDAO {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    public int insert(Map<String, Object> map){
        return this.sqlSessionTemplate.insert("calendar_event.event_insert", map);
    }

    public List<Map<String, Object>> selectList(Map<String, Object> emp_num) {
        return this.sqlSessionTemplate.selectList("calendar_event.event_select_list", emp_num);
    }

    public int delete(Map<String, Object> map) {
        return this.sqlSessionTemplate.delete("calendar_event.event_delete", map);
    }

    public int DateChange(Map<String, Object> map) {
        return this.sqlSessionTemplate.update("calendar_event.event_date_change", map);
    }

    public void Change(Map<String, Object> map) {
        this.sqlSessionTemplate.update("calendar_event.event_change", map);
    }
}
