package com.test.test4.dao;

import java.sql.SQLException;
import java.util.List;

import com.test.test4.vo.ProductionVO;

public interface ProductionDAO {
	int create(ProductionVO vo) throws SQLException;
	ProductionVO readOne(String code) throws SQLException;
	List<ProductionVO> readList(String category) throws SQLException;
	int upgrade(ProductionVO vo) throws SQLException;
	int delete(String code) throws SQLException;	
}
