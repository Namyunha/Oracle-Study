package com.test.test4.vo;

public class ProductionVO {
	private int id;
	private String code;
	private String pname;
	private	long cost;
	private long pnum;
	private long inum;
	private long sale;
	private String gcode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public long getPnum() {
		return pnum;
	}
	public void setPnum(long pnum) {
		this.pnum = pnum;
	}
	public long getInum() {
		return inum;
	}
	public void setInum(long inum) {
		this.inum = inum;
	}
	public long getSale() {
		return sale;
	}
	public void setSale(long sale) {
		this.sale = sale;
	}
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	
	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", code=" + code + ", pname=" + pname + ", cost=" + cost + ", pnum=" + pnum
				+ ", inum=" + inum + ", sale=" + sale + ", gcode=" + gcode + "]";
	}
	
	
}
