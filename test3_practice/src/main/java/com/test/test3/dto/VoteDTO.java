package com.test.test3.dto;

public class VoteDTO {
	private String vJumin;
	private String vName;
	private String mNo;
	private String vTime;
	private String vArea;
	private String vConfirm;
	
	public String getvJumin() {
		return vJumin;
	}
	public void setvJumin(String vJumin) {
		this.vJumin = vJumin;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getmNo() {
		return mNo;
	}
	public void setmNo(String mNo) {
		this.mNo = mNo;
	}
	public String getvTime() {
		return vTime;
	}
	public void setvTime(String vTime) {
		this.vTime = vTime;
	}
	public String getvArea() {
		return vArea;
	}
	public void setvArea(String vArea) {
		this.vArea = vArea;
	}
	public String getvConfirm() {
		return vConfirm;
	}
	public void setvConfirm(String vConfirm) {
		this.vConfirm = vConfirm;
	}
	
	@Override
	public String toString() {
		return "VoteDTO [vJumin=" + vJumin + ", vName=" + vName + ", mNo=" + mNo + ", vTime=" + vTime + ", vArea="
				+ vArea + ", vConfirm=" + vConfirm + "]";
	}
	
	
}
