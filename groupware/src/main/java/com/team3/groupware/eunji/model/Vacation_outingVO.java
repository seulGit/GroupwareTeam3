package com.team3.groupware.eunji.model;

public class Vacation_outingVO {
	
	private int vacation_docu_num; 			// 문서번호
	private String outing_place;			// 외출행선지
	private String outing_reason;			// 외출 사유
	private String outing_title;			// 외출 제목
	private String outing_contents;			// 외출 내용
	
	
	public int getVacation_docu_num() {
		return vacation_docu_num;
	}
	public void setVacation_docu_num(int vacation_docu_num) {
		this.vacation_docu_num = vacation_docu_num;
	}
	public String getOuting_place() {
		return outing_place;
	}
	public void setOuting_place(String outing_place) {
		this.outing_place = outing_place;
	}
	public String getOuting_reason() {
		return outing_reason;
	}
	public void setOuting_reason(String outing_reason) {
		this.outing_reason = outing_reason;
	}
	public String getOuting_title() {
		return outing_title;
	}
	public void setOuting_title(String outing_title) {
		this.outing_title = outing_title;
	}
	public String getOuting_contents() {
		return outing_contents;
	}
	public void setOuting_contents(String outing_contents) {
		this.outing_contents = outing_contents;
	}
	
	
	@Override
	public String toString() {
		return "Vacation_outingVO [vacation_docu_num=" + vacation_docu_num + ", outing_place=" + outing_place
				+ ", outing_reason=" + outing_reason + ", outing_title=" + outing_title + ", outing_contents="
				+ outing_contents + "]";
	}
	
	
	
}
