package com.test.test2.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.test2.dto.MemberDTO;
import com.test.test2.dto.SaleDTO;

public class MemberDAO {
	// Connection, PreparedStatement, ResultSet 객체는 ojdbc11.jar 라이브러리가 있어야만 사용가능.
    Connection con = null; // DB 접속을 위한 객체
    PreparedStatement pstmt = null; // 쿼리문 전송을 위한 객체
    ResultSet rs = null; // select 쿼리 등을 수행했을 때 select 결과를 담는 객체
	
	public static Connection getConnection() throws Exception{
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
	
		return con;
	}
	
	
	public int getCustNo() throws Exception {
        con = getConnection();
        String sql = "SELECT COUNT(CUSTNO) FROM member_tbl_02";
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery();
        int result = 100001;
        if (rs.next()) {
            int memberCount = rs.getInt(1);
            result = result + memberCount;
        }
        rs.close();
        pstmt.close();
        con.close();
        return result;
    }
	
	
	public int save(String custno, String custname, String phone, String address,String joindate, String grade, String city) throws Exception {
		con = getConnection();
		String sql = "INSERT INTO member_tbl_02 values(?,?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, custno);
		pstmt.setString(2, custname);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, joindate);
		pstmt.setString(6, grade);
		pstmt.setString(7, city);
		int result = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return result;
	}
	
	public List<MemberDTO> findAll() throws Exception {
		con = getConnection();
		String sql = "select custno, custname, phone, address, to_char(joindate, 'YYYY-MM-DD'), " +
					 "case 	when grade='A' then 'VIP'" +
					 "	 	when grade='B' then '일반'" +
					 "		when grade='C' then '직원'" +
					 " 		else '없음' \n" +
					 "	end as grade, city from member_tbl_02";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<MemberDTO> memberList = new ArrayList();
		while(rs.next()) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setCustno(rs.getString(1));
		memberDTO.setCustname(rs.getString(2));
		memberDTO.setPhone(rs.getString(3));
		memberDTO.setAddress(rs.getString(4));
		memberDTO.setJoindate(rs.getString(5));
		memberDTO.setGrade(rs.getString(6));
		memberDTO.setCity(rs.getString(7));
		memberList.add(memberDTO);
		}
		rs.close();
		pstmt.close();
		con.close();
		return memberList;
	}
	
	 public MemberDTO findById(String custno) throws Exception {
	        con = getConnection();
	        String sql = "select custno, custname, phone, address, to_char(joindate, 'YYYY-MM-DD' ), grade, city from member_tbl_02 where custno=?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, custno);
	        rs = pstmt.executeQuery();
	        MemberDTO memberDTO = null;
	        if (rs.next()) {
	            memberDTO = new MemberDTO();
	            memberDTO.setCustno(rs.getString(1));
	            memberDTO.setCustname(rs.getString(2));
	            memberDTO.setPhone(rs.getString(3));
	            memberDTO.setAddress(rs.getString(4));
	            memberDTO.setJoindate(rs.getString(5));
	            memberDTO.setGrade(rs.getString(6));
	            memberDTO.setCity(rs.getString(7));
	        }
	        return memberDTO;
	    }
	 
	public List<SaleDTO> saleList() throws Exception{
		con = getConnection();
		String sql = "select m.custno, m.custname, " +
				 "case    when m.grade='A' then 'VIP'" +
				 "        when m.grade='B' then '일반'" +
				 "        when m.grade='C' then '직원'" +
				 "            else '없음'" +
				 "    end as grade," +
				 "    sum(mo.price) as total " +
				 "    from member_tbl_02 m, money_tbl_02 mo" +
				 "        where m.custno=mo.custno" +
				 "            group by m.custno, m.custname, m.grade" +
				 "                order by total desc"; 
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<SaleDTO> salesList = new ArrayList<>();
		while(rs.next()) {
			SaleDTO saleDTO = new SaleDTO();
			saleDTO.setCustno(rs.getInt(1));
			saleDTO.setCustname(rs.getString(2));
			saleDTO.setGrade(rs.getString(3));
			saleDTO.setSaleamount(rs.getInt(4));
			System.out.println("dao에있는 " + rs.getString(2));
			salesList.add(saleDTO);
		}
		return salesList;
	}
}
