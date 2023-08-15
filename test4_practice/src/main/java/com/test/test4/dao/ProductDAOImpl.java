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
	public ProductVO readOne(String code) throws SQLException {
		// TODO Auto-generated method stub
		con = getConnection();
		System.out.println("readOne = " + code);
		String sql = "select * from product where code=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, code);
		rs = pstmt.executeQuery();
		ProductVO productVO = new ProductVO();
		System.out.println(rs.getString(1));
		if(rs.next()) {
			productVO.setCode(rs.getString(1));
			productVO.setPname(rs.getString(2));
			productVO.setCost(rs.getInt(3));
			productVO.setPnum(rs.getInt(4));
			productVO.setInum(rs.getInt(5));
			productVO.setSale(rs.getInt(6));
			productVO.setGcode(rs.getString(7));
		}
		System.out.println(productVO.getPname());
		rs.close();
		closeDBResources(pstmt, con);
		return productVO;
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
