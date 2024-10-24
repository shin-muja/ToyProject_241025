package edu.kh.toy.common;

import java.sql.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCTemplate {
	
	private static Connection conn = null;

	public static Connection getConnection() {
		
		try {
			
			if(conn != null && !conn.isClosed() ) {
				return conn;
			}
			
			Properties prop = new Properties();
			
			String filePath = JDBCTemplate.class.getResource("/xml/driver.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"),
											   prop.getProperty("userName"),
											   prop.getProperty("password"));
			
			conn.setAutoCommit(false);
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void commit(Connection conn) {
		try {
			
			if( conn != null && !conn.isClosed()) conn.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			
			if( conn != null && !conn.isClosed()) conn.rollback();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//---------------------------------------------------------------
	
	public static void close(Connection conn) {
		try {
			
			if( conn != null && !conn.isClosed()) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			
			if( stmt != null && stmt.isClosed()) stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			
			if( rs != null && !rs.isClosed()) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
