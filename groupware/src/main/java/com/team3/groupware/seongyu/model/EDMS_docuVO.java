package com.team3.groupware.seongyu.model;

import java.util.Date;

public class EDMS_docuVO {
    private int EDMS_docu_num; // 문서 번호 숫자 자동 생성
    private String EDMS_docu_category; // 증명서신청, 일반품의서, 비용품의서
    private int emp_num; // 기안자
    private Date EDMS_docu_date; // 문서 작성일
    private int EDMS_docu_urgent; // 긴급 여부 불리언
    private String EDMS_docu_file_route; // 첨부파일 경로
    private int EDMS_docu_temp; // 임시보관여부 불리언
    private int EDMS_docu_cancel; // 취소여부 불리언

    public int getEDMS_docu_num() {
        return EDMS_docu_num;
    }

    public void setEDMS_docu_num(int EDMS_docu_num) {
        this.EDMS_docu_num = EDMS_docu_num;
    }

    public String getEDMS_docu_category() {
        return EDMS_docu_category;
    }

    public void setEDMS_docu_category(String EDMS_docu_category) {
        this.EDMS_docu_category = EDMS_docu_category;
    }

    public int getEmp_num() {
        return emp_num;
    }

    public void setEmp_num(int emp_num) {
        this.emp_num = emp_num;
    }

    public Date getEDMS_docu_date() {
        return EDMS_docu_date;
    }

    public void setEDMS_docu_date(Date EDMS_docu_date) {
        this.EDMS_docu_date = EDMS_docu_date;
    }

    public int getEDMS_docu_urgent() {
        return EDMS_docu_urgent;
    }

    public void setEDMS_docu_urgent(int EDMS_docu_urgent) {
        this.EDMS_docu_urgent = EDMS_docu_urgent;
    }

    public String getEDMS_docu_file_route() {
        return EDMS_docu_file_route;
    }

    public void setEDMS_docu_file_route(String EDMS_docu_file_route) {
        this.EDMS_docu_file_route = EDMS_docu_file_route;
    }

    public int getEDMS_docu_temp() {
        return EDMS_docu_temp;
    }

    public void setEDMS_docu_temp(int EDMS_docu_temp) {
        this.EDMS_docu_temp = EDMS_docu_temp;
    }

    public int getEDMS_docu_cancel() {
        return EDMS_docu_cancel;
    }

    public void setEDMS_docu_cancel(int EDMS_docu_cancel) {
        this.EDMS_docu_cancel = EDMS_docu_cancel;
    }

    @Override
    public String toString() {
        return "EDMS_docuVO{" +
                "EDMS_docu_num=" + EDMS_docu_num +
                ", EDMS_docu_category='" + EDMS_docu_category + '\'' +
                ", emp_num=" + emp_num +
                ", EDMS_docu_date=" + EDMS_docu_date +
                ", EDMS_docu_urgent=" + EDMS_docu_urgent +
                ", EDMS_docu_file_route='" + EDMS_docu_file_route + '\'' +
                ", EDMS_docu_temp=" + EDMS_docu_temp +
                ", EDMS_docu_cancel=" + EDMS_docu_cancel +
                '}';
    }
}
