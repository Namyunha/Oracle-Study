package com.test.test4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.test.test4.vo.ProductionVO;

public class ProductionDAOImpl extends DAOBase implements ProductionDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	@Override
	public int create(ProductionVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductionVO readOne(String code) throws SQLException {
		// TODO Auto-generated method stub
		con = getConnection();
		String sql = "select * from product where code=?";
		pstmt = con.prepareStatement(sql);
		System.out.println("Code = " + code);
		pstmt.setString(1, code);
		rs = pstmt.executeQuery();
		
		ProductionVO productionVO = new ProductionVO();
		while(rs.next()) {
			System.out.println( "rs.getString(1) = " + rs.getString(1));
			productionVO.setCode(rs.getString(1));
			productionVO.setPname(rs.getString(2));
			productionVO.setCost(rs.getLong(3));
			productionVO.setPnum(rs.getLong(4));
			productionVO.setInum(rs.getLong(5));
			productionVO.setSale(rs.getLong(6));
			productionVO.setGcode(rs.getString(7));
		}
		closeDBResources(pstmt, con);
		return productionVO;
	}

	@Override
	public List<ProductionVO> readList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int upgrade(ProductionVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ProductionVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
