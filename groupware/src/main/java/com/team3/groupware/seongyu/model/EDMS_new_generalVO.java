package com.team3.groupware.seongyu.model;

import java.util.Date;

public class EDMS_new_generalVO {
    // EDMS_approval_request
    private String approval_request_docu_title; // 제목
    private String approval_request_docu_contents; // 내용
    private int EDMS_docu_num; // 문서번호

    //    EDMS_docu
    private String EDMS_docu_category; // 문서 종류
    private int emp_num; // 작성자 사원번호
    private Date EDMS_docu_date; // 작성일자
    private boolean EDMS_docu_urgent; // 긴급여부
    private String EDMS_docu_file_route; // 첨부파일 루트
    private int EDMS_docu_temp; // 임시보관 여부
    private int EDMS_docu_cancel; // 취소여부

    //      EDMS_approval
    private String EDMS_approval_emp_1; // 첫번째 결재자 사원번호
    private String EDMS_approval_emp_2; // 두번째 결재자 사원번호

    public String getApproval_request_docu_title() {
        return approval_request_docu_title;
    }

    public void setApproval_request_docu_title(String approval_request_docu_title) {
        this.approval_request_docu_title = approval_request_docu_title;
    }

    public String getApproval_request_docu_contents() {
        return approval_request_docu_contents;
    }

    public void setApproval_request_docu_contents(String approval_request_docu_contents) {
        this.approval_request_docu_contents = approval_request_docu_contents;
    }

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

    public boolean getEDMS_docu_urgent() {
        return EDMS_docu_urgent;
    }

    public void setEDMS_docu_urgent(boolean EDMS_docu_urgent) {
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

    public String getEDMS_approval_emp_1() {
        return EDMS_approval_emp_1;
    }

    public void setEDMS_approval_emp_1(String EDMS_approval_emp_1) {
        this.EDMS_approval_emp_1 = EDMS_approval_emp_1;
    }

    public String getEDMS_approval_emp_2() {
        return EDMS_approval_emp_2;
    }

    public void setEDMS_approval_emp_2(String EDMS_approval_emp_2) {
        this.EDMS_approval_emp_2 = EDMS_approval_emp_2;
    }

    @Override
    public String toString() {
        return "EDMS_new_generalVO{" +
                "approval_request_docu_title='" + approval_request_docu_title + '\'' +
                ", approval_request_docu_contents='" + approval_request_docu_contents + '\'' +
                ", EDMS_docu_num=" + EDMS_docu_num +
                ", EDMS_docu_category='" + EDMS_docu_category + '\'' +
                ", emp_num=" + emp_num +
                ", EDMS_docu_date=" + EDMS_docu_date +
                ", EDMS_docu_urgent=" + EDMS_docu_urgent +
                ", EDMS_docu_file_route='" + EDMS_docu_file_route + '\'' +
                ", EDMS_docu_temp=" + EDMS_docu_temp +
                ", EDMS_docu_cancel=" + EDMS_docu_cancel +
                ", EDMS_approval_emp_1='" + EDMS_approval_emp_1 + '\'' +
                ", EDMS_approval_emp_2='" + EDMS_approval_emp_2 + '\'' +
                '}';
    }
}
