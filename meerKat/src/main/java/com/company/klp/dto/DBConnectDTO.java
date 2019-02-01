package com.company.klp.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectDTO {

	private String db_Url;
	private String db_User;
	private String db_Pwd;
	
	private Connection conn;
	
	public DBConnectDTO() {
		db_Url = "jdbc:mariadb://192.168.2.21:3306/meerkat";
		db_User = "root";
		db_Pwd = "klp!@#$5988";
		
		conn = null;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(db_Url, db_User, db_Pwd);
			
			if(conn != null) {
				System.out.println("Database Access Success");
			}else {
				System.out.println("Database Access Fail");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return conn;
	}
	
	/*
	 * 	Connection 종료 성공 : return true
	 * 	Connection 종료 실패 : return false
	 */
	public boolean closeConnection(ResultSet rs, PreparedStatement pstmt, Connection conn) {

		try {
			if(rs != null) 		{ rs.close();		}
			if(pstmt != null)	{ pstmt.close();	}
			if(conn != null) 	{ conn.close(); 	}	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
