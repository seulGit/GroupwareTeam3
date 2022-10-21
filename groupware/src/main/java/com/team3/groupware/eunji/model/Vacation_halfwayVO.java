package com.team3.groupware.eunji.model;

import java.util.Date;

public class Vacation_halfwayVO {
	
	private int vacation_docu_num; 				// 문서번호
	private Date halfway_date;					// 반차날짜
	private String halfway_norning_aftermoon;   // 오전오후 반차 선택
	private String halfway_reason;				// 반차 사유	
	private String halfway_title;				// 반차 제목
	private String halfway_contents;			// 반차 내용
	
	
	public int getVacation_docu_num() {
		return vacation_docu_num;
	}
	public void setVacation_docu_num(int vacation_docu_num) {
		this.vacation_docu_num = vacation_docu_num;
	}
	public Date getHalfway_date() {
		return halfway_date;
	}
	public void setHalfway_date(Date halfway_date) {
		this.halfway_date = halfway_date;
	}
	public String getHalfway_norning_aftermoon() {
		return halfway_norning_aftermoon;
	}
	public void setHalfway_norning_aftermoon(String halfway_norning_aftermoon) {
		this.halfway_norning_aftermoon = halfway_norning_aftermoon;
	}
	public String getHalfway_reason() {
		return halfway_reason;
	}
	public void setHalfway_reason(String halfway_reason) {
		this.halfway_reason = halfway_reason;
	}
	public String getHalfway_title() {
		return halfway_title;
	}
	public void setHalfway_title(String halfway_title) {
		this.halfway_title = halfway_title;
	}
	public String getHalfway_contents() {
		return halfway_contents;
	}
	public void setHalfway_contents(String halfway_contents) {
		this.halfway_contents = halfway_contents;
	}
	
	
	@Override
	public String toString() {
		return "Vacation_halfwayVO [vacation_docu_num=" + vacation_docu_num + ", halfway_date=" + halfway_date
				+ ", halfway_norning_aftermoon=" + halfway_norning_aftermoon + ", halfway_reason=" + halfway_reason
				+ ", halfway_title=" + halfway_title + ", halfway_contents=" + halfway_contents + "]";
	}
	
	
	
}
