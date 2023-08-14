package com.test.test4.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOBase implements DAO{
	public Connection getConnection() throws SQLException {
		String jdbc_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			Class.forName(jdbc_driver);
			Connection conn = DriverManager.getConnection(db_url,"system","1234");
			return conn;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeDBResources(PreparedStatement pstmt, Connection conn) {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
