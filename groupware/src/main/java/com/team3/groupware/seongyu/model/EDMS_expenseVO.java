package com.team3.groupware.seongyu.model;

public class EDMS_expenseVO {

    private String expense_docu_title;
    private String expense_docu_contents;
    private String expense_purpose;
    private String expense_total_expense;
    private String expense_payment;
    private int EDMS_docu_num;

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

    @Override
    public String toString() {
        return "EDMS_expenseVO{" +
                "expense_docu_title='" + expense_docu_title + '\'' +
                ", expense_docu_contents='" + expense_docu_contents + '\'' +
                ", expense_purpose='" + expense_purpose + '\'' +
                ", expense_total_expense='" + expense_total_expense + '\'' +
                ", expense_payment='" + expense_payment + '\'' +
                ", EDMS_docu_num=" + EDMS_docu_num +
                '}';
    }
}
