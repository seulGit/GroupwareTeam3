package com.team3.groupware.eunji.model;

public class Vacation_early_departureVO {
	
	private int vacation_docu_num; 					//문서번호
	private String early_departure_reason; 			// 조퇴사유
	private String early_departure_title;   		// 조퇴 제목
	private String early_departure_contents; 		// 조퇴 내용
	
	
	public int getVacation_docu_num() {
		return vacation_docu_num;
	}
	public void setVacation_docu_num(int vacation_docu_num) {
		this.vacation_docu_num = vacation_docu_num;
	}
	public String getEarly_departure_reason() {
		return early_departure_reason;
	}
	public void setEarly_departure_reason(String early_departure_reason) {
		this.early_departure_reason = early_departure_reason;
	}
	public String getEarly_departure_title() {
		return early_departure_title;
	}
	public void setEarly_departure_title(String early_departure_title) {
		this.early_departure_title = early_departure_title;
	}
	public String getEarly_departure_contents() {
		return early_departure_contents;
	}
	public void setEarly_departure_contents(String early_departure_contents) {
		this.early_departure_contents = early_departure_contents;
	}
	
	
	@Override
	public String toString() {
		return "Vacation_early_departureVO [vacation_docu_num=" + vacation_docu_num + ", early_departure_reason="
				+ early_departure_reason + ", early_departure_title=" + early_departure_title
				+ ", early_departure_contents=" + early_departure_contents + "]";
	}
	
	
	
}
