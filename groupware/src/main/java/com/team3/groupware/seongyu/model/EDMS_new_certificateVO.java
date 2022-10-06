package com.team3.groupware.seongyu.model;

import java.util.Date;

public class EDMS_new_certificateVO {
    // EDMS_certificate
    private String certificate_docu_title; // 제목
    private String certificate_docu_contents; // 내용
    private String certificate_name;    // 증명서 종류
    private String certificate_purpose;     // 용도
    private String certificate_submit_to;   // 제출처
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

    public String getCertificate_docu_title() {
        return certificate_docu_title;
    }

    public void setCertificate_docu_title(String certificate_docu_title) {
        this.certificate_docu_title = certificate_docu_title;
    }

    public String getCertificate_docu_contents() {
        return certificate_docu_contents;
    }

    public void setCertificate_docu_contents(String certificate_docu_contents) {
        this.certificate_docu_contents = certificate_docu_contents;
    }

    public String getCertificate_name() {
        return certificate_name;
    }

    public void setCertificate_name(String certificate_name) {
        this.certificate_name = certificate_name;
    }

    public String getCertificate_purpose() {
        return certificate_purpose;
    }

    public void setCertificate_purpose(String certificate_purpose) {
        this.certificate_purpose = certificate_purpose;
    }

    public String getCertificate_submit_to() {
        return certificate_submit_to;
    }

    public void setCertificate_submit_to(String certificate_submit_to) {
        this.certificate_submit_to = certificate_submit_to;
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

    public boolean isEDMS_docu_urgent() {
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
        return "EDMS_new_certificateVO{" +
                "certificate_docu_title='" + certificate_docu_title + '\'' +
                ", certificate_docu_contents='" + certificate_docu_contents + '\'' +
                ", certificate_name='" + certificate_name + '\'' +
                ", certificate_purpose='" + certificate_purpose + '\'' +
                ", certificate_submit_to='" + certificate_submit_to + '\'' +
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
