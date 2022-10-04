package com.team3.groupware.seongyu.model;

import java.util.Date;

public class EDMS_approvalVO {
    private String EDMS_approval_emp_1; // 결재자 1
    private Date EDMS_approval_date_1; // 결재일자
    private int EDMS_approval_1; // 승인 여부 1
    private String EDMS_approval_emp_2; // 결재자 2
    private Date EDMS_approval_date_2; // 결재일자 2
    private int EDMS_approval_2; // 승인여부 2
    private int EDMS_docu_num; // 문서번호

    public String getEDMS_approval_emp_1() {
        return EDMS_approval_emp_1;
    }

    public void setEDMS_approval_emp_1(String EDMS_approval_emp_1) {
        this.EDMS_approval_emp_1 = EDMS_approval_emp_1;
    }

    public Date getEDMS_approval_date_1() {
        return EDMS_approval_date_1;
    }

    public void setEDMS_approval_date_1(Date EDMS_approval_date_1) {
        this.EDMS_approval_date_1 = EDMS_approval_date_1;
    }

    public int getEDMS_approval_1() {
        return EDMS_approval_1;
    }

    public void setEDMS_approval_1(int EDMS_approval_1) {
        this.EDMS_approval_1 = EDMS_approval_1;
    }

    public String getEDMS_approval_emp_2() {
        return EDMS_approval_emp_2;
    }

    public void setEDMS_approval_emp_2(String EDMS_approval_emp_2) {
        this.EDMS_approval_emp_2 = EDMS_approval_emp_2;
    }

    public Date getEDMS_approval_date_2() {
        return EDMS_approval_date_2;
    }

    public void setEDMS_approval_date_2(Date EDMS_approval_date_2) {
        this.EDMS_approval_date_2 = EDMS_approval_date_2;
    }

    public int getEDMS_approval_2() {
        return EDMS_approval_2;
    }

    public void setEDMS_approval_2(int EDMS_approval_2) {
        this.EDMS_approval_2 = EDMS_approval_2;
    }

    public int getEDMS_docu_num() {
        return EDMS_docu_num;
    }

    public void setEDMS_docu_num(int EDMS_docu_num) {
        this.EDMS_docu_num = EDMS_docu_num;
    }

    @Override
    public String toString() {
        return "EDMS_approvalVO{" +
                "EDMS_approval_emp_1='" + EDMS_approval_emp_1 + '\'' +
                ", EDMS_approval_date_1=" + EDMS_approval_date_1 +
                ", EDMS_approval_1=" + EDMS_approval_1 +
                ", EDMS_approval_emp_2='" + EDMS_approval_emp_2 + '\'' +
                ", EDMS_approval_date_2=" + EDMS_approval_date_2 +
                ", EDMS_approval_2=" + EDMS_approval_2 +
                ", EDMS_docu_num=" + EDMS_docu_num +
                '}';
    }
}
