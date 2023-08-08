package com.test.test3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.test3.dto.MemberDTO;

public class VoteDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
    ResultSet rs = null;
    
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
		return con;
	}
	
	public List<MemberDTO> findAll() throws Exception {
		con = getConnection();
		String sql = "select m.m_no, m.m_name, p.p_name," +
				"        case when m.p_school=1 then '고졸'" +
				"             when m.p_school=2 then '학사'" +
				"             when m.p_school=3 then '석사'" +
				"             when m.p_school=4 then '박사'" +
				"             else '없음'"+
				"        end p_school, " +
				" substr(m.m_jumin, 1, 6) || '-' || substr(m.m_jumin, 7, 7) m_jumin, m.m_city, p.p_tel1 || '-' || p.p_tel2 || '-' || p.p_tel3 pTel " +  
				 "from tbl_member_202005 m, tbl_party_202005 p where m.p_code=p.p_code";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<MemberDTO> memberList = new ArrayList<>();
		while(rs.next()) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setmNo(rs.getString(1));
			memberDTO.setmName(rs.getString(2));
			memberDTO.setpName(rs.getString(3));
			memberDTO.setpSchool(rs.getString(4));
			memberDTO.setmJumin(rs.getString(5));
			memberDTO.setmCity(rs.getString(6));
			memberDTO.setpTel(rs.getString(7));
			memberList.add(memberDTO);
		}
		return memberList;
	}
	
	public int saveVote (String vJumin,String vName,String mNo,String vTime,String vArea, String vConfirm) throws Exception {
		con = getConnection();
		String sql = "insert into tbl_vote_202005 values (?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vJumin);
		pstmt.setString(2, vName);
		pstmt.setString(3, mNo);
		pstmt.setString(4, vTime);
		pstmt.setString(5, vArea);
		pstmt.setString(6, vConfirm);
		int result = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return result;
	}
}
