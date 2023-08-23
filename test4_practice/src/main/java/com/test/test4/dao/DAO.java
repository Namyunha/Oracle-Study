package com.test.test4.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DAO {
	public Connection getConnection() throws SQLException; 
}
