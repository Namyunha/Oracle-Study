package com.test.test5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.test5.dto.MemberDTO;
import com.test.test5.dto.RecordDTO;
import com.test.test5.dto.VoteDTO;

public class VoteDAOImpl extends DAOBase implements VoteDAO{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public List<MemberDTO> memberList() throws SQLException {
		con = getConnection();
		String sql = "select m.m_no,m.m_name,p.p_name,"
				+ "case when m.p_school=\'1\' then \'고졸\' when m.p_school=\'2\' then \'학사\' when m.p_school=\'3\' then \'석사\' when m.p_school=\'4\' then \'박사\'"
				+ "else \'없음\' end as p_school, m.m_city,"
				+ "(p.p_tel1 || \'-\' || p.p_tel2 || \'-\' || p.p_tel3) as p_tel,"
				+ "substr(m.m_jumin, 1, 6) || \'-\' || substr(m.m_jumin, 7, 7) as m_jumin from tbl_member_202005 m, tbl_party_202005 p where m.p_code=p.p_code";
		pstmt = con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		List<MemberDTO> memberList = new ArrayList<>();
		while(rs.next()) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setM_no(rs.getString(1));
			memberDTO.setM_name(rs.getString(2));
			memberDTO.setP_name(rs.getString(3));
			memberDTO.setP_school(rs.getString(4));
			memberDTO.setM_city(rs.getString(5));
			memberDTO.setP_tel(rs.getString(6));
			memberDTO.setM_jumin(rs.getString(7));
			memberList.add(memberDTO);
		}
		System.out.println("Impl 후보자 리스트");
		for(MemberDTO m : memberList) {
			System.out.println(m.toString());
		}
		closeDBResources(rs, pstmt, con);
		return memberList;
	}

	@Override
	public int saveVote(VoteDTO dto) throws SQLException {
		con = getConnection();
		String sql = "insert into tbl_vote_202005 values(?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getV_jumin());
		pstmt.setString(2, dto.getV_name());
		pstmt.setString(3, dto.getM_no());
		pstmt.setString(4, dto.getV_time());
		pstmt.setString(5, dto.getV_area());
		pstmt.setString(6, dto.getV_confirm());
		int result = pstmt.executeUpdate();
		closeDBResources(pstmt, con);
		return result;
	}

	@Override
	public List<VoteDTO> voteList() throws SQLException {
		con = getConnection();
		String sql = "select v_name,"
				+ "((case when substr(v_jumin, 7, 1)=\'1\' or substr(v_jumin, 7, 1)=\'2\' then \'19\' || substr(v_jumin, 1, 2)"
				+ "when substr(v_jumin, 7, 1)=\'3\' or substr(v_jumin, 7, 1)=\'4\' then \'20\' || substr(v_jumin, 1, 2) else \'없음\' end) || \'년\')"
				+ "|| (substr(v_jumin, 3, 2) || \'월\') || (substr(v_jumin, 5, 2) || \'일생\') as v_jumin, "
				+ "\'만\' || (to_number(to_char(sysdate, \'yyyy\')) - to_number("
				+ "to_char(case when substr(v_jumin, 7, 1)=\'1\' or substr(v_jumin, 7, 1)=\'2\' then \'19\' || substr(v_jumin, 1, 2)"
				+ "when substr(v_jumin, 7, 1)=\'3\' or substr(v_jumin, 7, 1)=\'4\' then \'20\' || substr(v_jumin, 1, 2)else \'없음\' end)))  || \'세\' as v_age,"
				+ "case when substr(v_jumin, 7, 1)=\'1\' or substr(v_jumin, 7, 1)=\'3\' then \'남\'"
				+ "when substr(v_jumin, 7, 2)=\'2\' or substr(v_jumin, 7, 4)=\'4\' then \'여\' else \'없음\' end as v_gender,m_no,"
				+ "substr(v_time, 1, 2) || \':\' || substr(v_time, 3, 2) as v_time,"
				+ "case when v_confirm=\'Y\' then \'확인\' when v_confirm=\'N\' then \'미확인\' else \'없음\' end as v_confirm " 
				+ " from tbl_vote_202005";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<VoteDTO> voteList = new ArrayList<>();
		while(rs.next()) {
			VoteDTO voteDTO = new VoteDTO();
			voteDTO.setV_name(rs.getString(1));
			voteDTO.setV_jumin(rs.getString(2));
			voteDTO.setV_age(rs.getString(3));
			voteDTO.setV_gender(rs.getString(4));
			voteDTO.setM_no(rs.getString(5));
			voteDTO.setV_time(rs.getString(6));
			voteDTO.setV_confirm(rs.getString(7));
			voteList.add(voteDTO);
		}
		closeDBResources(rs, pstmt, con);
		return voteList;
	}

	@Override
	public List<RecordDTO> recordList() throws SQLException {
		// TODO Auto-generated method stub
		con = getConnection();
		String sql ="select m.m_no, m.m_name, count(v.m_no) "
				+ "from tbl_member_202005 m, tbl_vote_202005 v where v.m_no=m.m_no group by m.m_no, m.m_name order by count(v.m_no) desc";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<RecordDTO> recordList = new ArrayList<>();
		while(rs.next()) {
			RecordDTO recordDTO = new RecordDTO();
			recordDTO.setM_no(rs.getString(1));
			recordDTO.setM_name(rs.getString(2));
			recordDTO.setV_sum(rs.getString(3));
			recordList.add(recordDTO);
		}
		closeDBResources(rs, pstmt, con);
		return recordList;
	}
	
}
