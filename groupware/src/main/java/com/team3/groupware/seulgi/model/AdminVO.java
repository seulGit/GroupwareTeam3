package com.team3.groupware.seulgi.model;

public class AdminVO {

    private int emp_num;
    private int authority_EDMS;
    private int authority_worktime;
    private int authority_booking;
    private int authority_board;
    private int authority_personnelCard;
    private int authority_loginHistory;
    private int authority_authority;

    public int getEmp_num() {
        return emp_num;
    }

    public void setEmp_num(int emp_num) {
        this.emp_num = emp_num;
    }

    public int getAuthority_EDMS() {
        return authority_EDMS;
    }

    public void setAuthority_EDMS(int authority_EDMS) {
        this.authority_EDMS = authority_EDMS;
    }

    public int getAuthority_worktime() {
        return authority_worktime;
    }

    public void setAuthority_worktime(int authority_worktime) {
        this.authority_worktime = authority_worktime;
    }

    public int getAuthority_booking() {
        return authority_booking;
    }

    public void setAuthority_booking(int authority_booking) {
        this.authority_booking = authority_booking;
    }

    public int getAuthority_board() {
        return authority_board;
    }

    public void setAuthority_board(int authority_board) {
        this.authority_board = authority_board;
    }

    public int getAuthority_personnelCard() {
        return authority_personnelCard;
    }

    public void setAuthority_personnelCard(int authority_personnelCard) {
        this.authority_personnelCard = authority_personnelCard;
    }

    public int getAuthority_loginHistory() {
        return authority_loginHistory;
    }

    public void setAuthority_loginHistory(int authority_loginHistory) {
        this.authority_loginHistory = authority_loginHistory;
    }

    public int getAuthority_authority() {
        return authority_authority;
    }

    public void setAuthority_authority(int authority_authority) {
        this.authority_authority = authority_authority;
    }

    @Override
    public String toString() {
        return "AdminVO{" +
                "emp_num=" + emp_num +
                ", authority_EDMS=" + authority_EDMS +
                ", authority_worktime=" + authority_worktime +
                ", authority_booking=" + authority_booking +
                ", authority_board=" + authority_board +
                ", authority_personnelCard=" + authority_personnelCard +
                ", authority_loginHistory=" + authority_loginHistory +
                ", authority_authority=" + authority_authority +
                '}';
    }
}
