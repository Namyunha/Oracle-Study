package com.test.test4.vo;

public class GroupCodeVO {
	private int id;
	private String gcode;
	private String gname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	
	@Override
	public String toString() {
		return "GroupCodeVO [id=" + id + ", gcode=" + gcode + ", gname=" + gname + "]";
	}
	
	
}
