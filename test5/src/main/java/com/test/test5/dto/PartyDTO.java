package com.test.test5.dto;

public class PartyDTO {
	private String p_code;
	private String p_name;
	private String indate;
	private String p_reader;
	private String tel;
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getP_reader() {
		return p_reader;
	}
	public void setP_reader(String p_reader) {
		this.p_reader = p_reader;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "PartyDTO [p_code=" + p_code + ", p_name=" + p_name + ", indate=" + indate + ", p_reader=" + p_reader
				+ ", tel=" + tel + "]";
	}
}
