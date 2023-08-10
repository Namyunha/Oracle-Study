package com.test.test3.dto;

public class RankingDTO {
	private String m_no;
	private String m_name;
	private String v_sum;
	public String getM_no() {
		return m_no;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getV_sum() {
		return v_sum;
	}
	public void setV_sum(String v_sum) {
		this.v_sum = v_sum;
	}
	
	@Override
	public String toString() {
		return "RankingDTO [m_no=" + m_no + ", m_name=" + m_name + ", v_sum=" + v_sum + "]";
	}
	
	
}
