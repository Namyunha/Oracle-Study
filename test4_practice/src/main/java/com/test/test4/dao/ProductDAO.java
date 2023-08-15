package com.test.test4.dao;

import java.sql.SQLException;
import java.util.List;

import com.test.test4.vo.ProductVO;

public interface ProductDAO {
	int create(ProductVO vo) throws SQLException;
	ProductVO readOne(String vo) throws SQLException;
	List<ProductVO> readList() throws SQLException;
	int update(ProductVO vo) throws SQLException;
	int delete(ProductVO vo) throws SQLException;
}
