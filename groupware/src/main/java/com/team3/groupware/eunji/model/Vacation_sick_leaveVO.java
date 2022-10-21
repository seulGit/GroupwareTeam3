package com.team3.groupware.eunji.model;

import java.util.Date;

public class Vacation_sick_leaveVO {
	
	private int vacation_docu_num; 		// 문서번호
	private Date sick_leave_start;		// 병가 시작일
	private Date sick_leave_last;		// 병가 마지막일
	private String sick_leave_reason;	// 병가 사유
	private String sick_leave_title;	// 병가 제목
	private String sick_leave_contents;	// 병가 내용
	
	
	public int getVacation_docu_num() {
		return vacation_docu_num;
	}
	public void setVacation_docu_num(int vacation_docu_num) {
		this.vacation_docu_num = vacation_docu_num;
	}
	public Date getSick_leave_start() {
		return sick_leave_start;
	}
	public void setSick_leave_start(Date sick_leave_start) {
		this.sick_leave_start = sick_leave_start;
	}
	public Date getSick_leave_last() {
		return sick_leave_last;
	}
	public void setSick_leave_last(Date sick_leave_last) {
		this.sick_leave_last = sick_leave_last;
	}
	public String getSick_leave_reason() {
		return sick_leave_reason;
	}
	public void setSick_leave_reason(String sick_leave_reason) {
		this.sick_leave_reason = sick_leave_reason;
	}
	public String getSick_leave_title() {
		return sick_leave_title;
	}
	public void setSick_leave_title(String sick_leave_title) {
		this.sick_leave_title = sick_leave_title;
	}
	public String getSick_leave_contents() {
		return sick_leave_contents;
	}
	public void setSick_leave_contents(String sick_leave_contents) {
		this.sick_leave_contents = sick_leave_contents;
	}
	
	
	@Override
	public String toString() {
		return "Vacation_sick_leaveVO [vacation_docu_num=" + vacation_docu_num + ", sick_leave_start="
				+ sick_leave_start + ", sick_leave_last=" + sick_leave_last + ", sick_leave_reason=" + sick_leave_reason
				+ ", sick_leave_title=" + sick_leave_title + ", sick_leave_contents=" + sick_leave_contents + "]";
	}
	
	
	
	
}
