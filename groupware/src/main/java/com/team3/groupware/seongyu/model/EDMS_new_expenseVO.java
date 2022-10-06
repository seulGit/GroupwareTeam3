package com.team3.groupware.seongyu.model;

import java.util.Date;

public class EDMS_new_expenseVO {
    // EDMS_expense
    private String expense_docu_title; // 제목
    private String expense_docu_contents; // 내용
    private String expense_purpose; // 용도
    private String expense_total_expense; // 총비용
    private String expense_payment; // 비용처리방법
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

    public String getExpense_docu_title() {
        return expense_docu_title;
    }

    public void setExpense_docu_title(String expense_docu_title) {
        this.expense_docu_title = expense_docu_title;
    }

    public String getExpense_docu_contents() {
        return expense_docu_contents;
    }

    public void setExpense_docu_contents(String expense_docu_contents) {
        this.expense_docu_contents = expense_docu_contents;
    }

    public String getExpense_purpose() {
        return expense_purpose;
    }

    public void setExpense_purpose(String expense_purpose) {
        this.expense_purpose = expense_purpose;
    }

    public String getExpense_total_expense() {
        return expense_total_expense;
    }

    public void setExpense_total_expense(String expense_total_expense) {
        this.expense_total_expense = expense_total_expense;
    }

    public String getExpense_payment() {
        return expense_payment;
    }

    public void setExpense_payment(String expense_payment) {
        this.expense_payment = expense_payment;
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
        return "EDMS_new_expenseVO{" +
                "expense_docu_title='" + expense_docu_title + '\'' +
                ", expense_docu_contents='" + expense_docu_contents + '\'' +
                ", expense_purpose='" + expense_purpose + '\'' +
                ", expense_total_expense='" + expense_total_expense + '\'' +
                ", expense_payment='" + expense_payment + '\'' +
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
