package com.team3.groupware.nohyun.model;

public class AddressAllVO {
	
	private String emp_num;
	private String emp_name;  		
	private String position_grade;  
	private String emp_phonenum;
	private String emp_email;  		
	private String dept_name;
	private String emp_desk_num;  	
	private String emp_address;
	
	public String getEmp_num() {
		return emp_num;
	}
	public void setEmp_num(String emp_num) {
		this.emp_num = emp_num;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getPosition_grade() {
		return position_grade;
	}
	public void setPosition_grade(String position_grade) {
		this.position_grade = position_grade;
	}
	public String getEmp_phonenum() {
		return emp_phonenum;
	}
	public void setEmp_phonenum(String emp_phonenum) {
		this.emp_phonenum = emp_phonenum;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getEmp_desk_num() {
		return emp_desk_num;
	}
	public void setEmp_desk_num(String emp_desk_num) {
		this.emp_desk_num = emp_desk_num;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	@Override
	public String toString() {
		return "AddressAllVO{" +
				", emp_num='" + emp_num + '\'' +
				", emp_name='" + emp_name + '\'' +
				", position_grade='" + position_grade + '\'' +
				", emp_phonenum='" + emp_phonenum + '\'' +
				", emp_email='" + emp_email + '\'' +
				", dept_name='" + dept_name + '\'' +
				", emp_desk_num='" + emp_desk_num + '\'' +
				", emp_address='" + emp_address + '\'' +
				'}';
	}
	
}
