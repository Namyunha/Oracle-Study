package com.test.test2.dto;

public class SaleDTO {
	private int custno;
	private String custname;
	private String grade;
	private int saleamount;
	
	public int getCustno() {
		return custno;
	}
	
	public void setCustno(int custno) {
		this.custno = custno;
	}
	
	public String getCustname() {
		return custname;
	}
	
	public void setCustname(String custname) {
		this.custname = custname;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public int getSaleamount() {
		return saleamount;
	}
	
	public void setSaleamount(int saleamount) {
		this.saleamount = saleamount;
	}
	
	@Override
	public String toString() {
		return "SaleDTO [custno=" + custno + ", custname=" + custname + ", grade=" + grade + ", saleamount="
				+ saleamount + "]";
	}
	
	
}
