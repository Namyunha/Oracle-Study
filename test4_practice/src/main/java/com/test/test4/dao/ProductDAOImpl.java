package com.test.test4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.test.test4.vo.ProductVO;

public class ProductDAOImpl extends DAOBase implements ProductDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public int create(ProductVO vo) throws SQLException {
		// TODO Auto-generated method stub
		con = getConnection();
		String sql = "insert into product values(?,?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getCode());
		pstmt.setString(2, vo.getPname());
		pstmt.setInt(3, vo.getCost());
		pstmt.setInt(4, vo.getPnum());
		pstmt.setInt(5, vo.getInum());
		pstmt.setInt(6, vo.getSale());
		pstmt.setString(7, vo.getGcode());
		int result = pstmt.executeUpdate();
		System.out.println("impl - rsult = " + result);
		closeDBResources(pstmt, con);
		return result;
	}

	@Override
	public ProductVO readOne(ProductVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductVO> readList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ProductVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ProductVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
