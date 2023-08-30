package com.test.test4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.test4.vo.ProductionVO;

public class ProductionDAOImpl extends DAOBase implements ProductionDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	@Override
	public int create(ProductionVO vo) throws SQLException {
		// TODO Auto-generated method stub
		con = getConnection();
		String sql = "insert into product values(?,?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getCode());
		pstmt.setString(2, vo.getPname());
		pstmt.setLong(3, vo.getCost());
		pstmt.setLong(4, vo.getPnum());
		pstmt.setLong(5, vo.getInum());
		pstmt.setLong(6, vo.getSale());
		pstmt.setString(7, vo.getGcode());
		int result = pstmt.executeUpdate();
		return result;
	}

	@Override
	public ProductionVO readOne(String code) throws SQLException {
		// TODO Auto-generated method stub
		con = getConnection();
		String sql = "select code, pname, cost, pnum, inum, sale, "
				+ "case when gcode=\'A\' then \'컴퓨터\'"
				+ "when gcode=\'B\' then \'냉장고\'"
				+ "when gcode=\'C\' then \'냉장고소모품\' else \'없음\' end as gcode"
				+ " from product where code=?";
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
		closeDBResources(rs, pstmt, con);
		return productionVO;
	}

	@Override
	public List<ProductionVO> readList(String category) throws SQLException {
		// TODO Auto-generated method stub
		con = getConnection();
		List<ProductionVO> list = new ArrayList<>();
		String sql = null;
		if(category.equals("priority")) {
			sql = "select pnum - inum, pname from product where inum < (pnum * 0.2)";
		} else if(category.equals("profit")) {
			sql = "SELECT (inum * (sale - cost)), pname from product ORDER BY (inum * (sale - cost)) DESC";
		} else if(category.equals("group")) {
			sql = "SELECT case when gcode=\'A\' then \'컴퓨터\' "
					+ "when gcode=\'B\' then \'냉장고\' "
					+ "when gcode=\'C\' then \'냉장고소모품\' else \'없음\' end as gcode, pname from product group by gcode, pname";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductionVO productionVO = new ProductionVO();
				productionVO.setGcode(rs.getString(1));
				productionVO.setPname(rs.getString(2));
				list.add(productionVO);
			}
			closeDBResources(rs, pstmt, con);
			return list;
		}
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			ProductionVO productionVO = new ProductionVO();
			productionVO.setInum(rs.getLong(1));
			productionVO.setPname(rs.getString(2));
			list.add(productionVO);
		}
		closeDBResources(rs, pstmt, con);
		return list;
	}

	@Override
	public int upgrade(ProductionVO vo) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(vo.toString());
		con = getConnection();
		String sql = "update product set pname=?,cost=?,pnum=?,inum=?,sale=?,gcode=? where code=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getPname());
		pstmt.setLong(2, vo.getCost());
		pstmt.setLong(3, vo.getPnum());
		pstmt.setLong(4, vo.getInum());
		pstmt.setLong(5, vo.getSale());
		pstmt.setString(6, vo.getGcode());
		pstmt.setString(7, vo.getCode());
		int result = pstmt.executeUpdate();
		closeDBResources(pstmt, con);
		return result;
	}

	@Override
	public int delete(String code) throws SQLException {
		// TODO Auto-generated method stub
		con = getConnection();
		String sql = "delete from product where code=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, code);
		int result = pstmt.executeUpdate();
		closeDBResources(pstmt, con);
		return result;
	}
	
}










