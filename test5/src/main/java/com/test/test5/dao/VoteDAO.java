package com.test.test5.dao;

import java.sql.SQLException;
import java.util.List;

import com.test.test5.dto.MemberDTO;
import com.test.test5.dto.RecordDTO;
import com.test.test5.dto.VoteDTO;

public interface VoteDAO {
	List<MemberDTO> memberList() throws SQLException;
	int saveVote(VoteDTO dto) throws SQLException;
	List<VoteDTO> voteList() throws SQLException;
	List<RecordDTO> recordList() throws SQLException;
}
