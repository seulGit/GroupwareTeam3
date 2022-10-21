package com.team3.groupware.eunji.model;



public class Vacation_annualVO {
	
	private int vacation_docu_num;			// 문서번호
    private String vacation_start;			// 연차시작일
    private String vacation_last; 			// 연차마지막일
    private String vacation_reason; 		// 연차사유
    private String vacation_title;			// 연차제목
    private String vacation_dontents;		// 연차 내용
    
    
	public int getVacation_docu_num() {
		return vacation_docu_num;
	}
	public void setVacation_docu_num(int vacation_docu_num) {
		this.vacation_docu_num = vacation_docu_num;
	}
	public String getVacation_start() {
		return vacation_start;
	}
	public void setVacation_start(String vacation_start) {
		this.vacation_start = vacation_start;
	}
	public String getVacation_last() {
		return vacation_last;
	}
	public void setVacation_last(String vacation_last) {
		this.vacation_last = vacation_last;
	}
	public String getVacation_reason() {
		return vacation_reason;
	}
	public void setVacation_reason(String vacation_reason) {
		this.vacation_reason = vacation_reason;
	}
	public String getVacation_title() {
		return vacation_title;
	}
	public void setVacation_title(String vacation_title) {
		this.vacation_title = vacation_title;
	}
	public String getVacation_dontents() {
		return vacation_dontents;
	}
	public void setVacation_dontents(String vacation_dontents) {
		this.vacation_dontents = vacation_dontents;
	}
	
	
	@Override
	public String toString() {
		return "Vacation_annualVO [vacation_docu_num=" + vacation_docu_num + ", vacation_start=" + vacation_start
				+ ", vacation_last=" + vacation_last + ", vacation_reason=" + vacation_reason + ", vacation_title="
				+ vacation_title + ", vacation_dontents=" + vacation_dontents + "]";
	}
	
	
}
