package com.test.test3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.test3.dto.MemberDTO;
import com.test.test3.dto.RankingDTO;
import com.test.test3.dto.VoteDTO;

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
	
	public int saveVote (String vJumin, String vName,String mNo, String vTime,String vArea, String vConfirm) throws Exception {
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
	
	public List<VoteDTO> findVoteAll() throws Exception {
		con = getConnection();
		String sql = "select v_name as vName," + 
					"TO_CHAR((case when substr(v_jumin, 7, 1) =  '1' or substr(v_jumin, 7, 1) = '2'  then TO_DATE( '19' || substr(v_jumin, 1, 6))" +
								" when substr(v_jumin, 7, 1) = '3' or substr(v_jumin, 7, 1) = '4' then TO_DATE( '20' || substr(v_jumin, 1, 6))"+
					"end), 'YYYY\"년\" MM\"월\" DD\"일생\"') as vJumin," +
					"'만'||(" +
					"TO_NUMBER(TO_CHAR(SYSDATE, 'yyyy')) - " + 
					"TO_NUMBER(TO_CHAR(case when substr(v_jumin, 7, 1) =  '1' or substr(v_jumin, 7, 1) = '2' then '19' || substr(v_jumin, 1, 2)"+ 
											"when substr(v_jumin, 7, 1) = '3' or substr(v_jumin, 7, 1) = '4' then '20' || substr(v_jumin, 1, 2) else '없음' end " + 
										"))) || '세' as vAge," +
					"case when substr(v_jumin, 7, 1) =  '1' or substr(v_jumin, 7, 1) = '3' then '남'" + 
						"when substr(v_jumin, 7, 1) = '2' or substr(v_jumin, 7, 1) = '4' then '여' else '없음' end as vGender," +
					"m_no as mNo, substr(v_time, 1, 2) || ':' || substr(v_time, 3, 4) as vTime," +  
					"case when v_confirm = 'Y' then '확인' when v_confirm = 'N' then '미확인' else '없음' end as vConfirm from tbl_vote_202005";    
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<VoteDTO> voteList = new ArrayList<>();
		while(rs.next()) {
			VoteDTO voteDTO = new VoteDTO();
			voteDTO.setvName(rs.getString(1));
			voteDTO.setvJumin(rs.getString(2));
			voteDTO.setvAge(rs.getString(3));
			voteDTO.setvGender(rs.getString(4));
			voteDTO.setmNo(rs.getString(5));
			voteDTO.setvTime(rs.getString(6));
			voteDTO.setvConfirm(rs.getString(7));
			voteList.add(voteDTO);
		}
		rs.close();
		pstmt.close();
		con.close();
		return voteList;
	}
	
	public List<RankingDTO> findAllRanking() throws Exception {
		con = getConnection();
		String sql = "select m.m_no, m.m_name, count(v.m_no) as v_sum " +
					"from tbl_member_202005 m, tbl_vote_202005 v " +
					"where m.m_no=v.m_no and v.v_confirm='Y' " + 
					"group by m.m_no, m.m_name order by v_sum desc";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<RankingDTO> rankingList = new ArrayList<>();
		while(rs.next()) {
			RankingDTO rankingDTO = new RankingDTO();
			rankingDTO.setM_no(rs.getString(1));
			rankingDTO.setM_name(rs.getString(2));
			rankingDTO.setV_sum(rs.getString(3));
			rankingList.add(rankingDTO);
		}
		rs.close();
		pstmt.close();
		con.close();
		return rankingList;
	}
	
}






