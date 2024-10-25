package edu.kh.toy.dao;

import java.sql.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.toy.common.JDBCTemplate.*;

import edu.kh.toy.dto.Student;

public class ToyProjectDAOImpl implements ToyProjectDAO {
	
	private ResultSet rs;
	private Statement stmt;
	private PreparedStatement pstmt;
	
	private Properties prop;
	
	public ToyProjectDAOImpl() {
		
		try {
			String filePath = ToyProjectDAOImpl.class.getResource("/xml/sql.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> stdFullSelect(Connection conn) throws Exception {
		
		List<Student> stdList = new ArrayList<Student>();
		
		try {
			
			String sql = prop.getProperty("stdFullSelect");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Student std = new Student().builder()
								.stdNo(rs.getInt(1))
								.stdName(rs.getString(2))
								.stdAge(rs.getInt(3))
								.stdGender(rs.getString(4))
								.stdScore(rs.getString(5))
								.build();
				
				stdList.add(std);
				
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return stdList;
	}


	@Override
	public Student detailStdNoSelect(Connection conn, int stdNo) throws Exception {
		
		Student std = null;
		
		try {
			String sql = prop.getProperty("detailStdNoSelect");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, stdNo);
			
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {

				std = new Student().builder()
						.stdNo(rs.getInt(1))
						.stdName(rs.getString(2))
						.stdAge(rs.getInt(3))
						.stdGender(rs.getString(4))
						.stdScore(rs.getString(5))
						.build();
				
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return std;
	}


	@Override
	public int deleteStudent(Connection conn, int stdNo) throws Exception {
		
		int result = 0;

		try {
			
			String sql = prop.getProperty("deleteStudent");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, stdNo);

			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	@Override
	public int addStudent(Connection conn, Student std) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("addStudent");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, std.getStdName());
			pstmt.setInt(2, std.getStdAge());
			pstmt.setString(3, std.getStdGender());
			pstmt.setString(4, std.getStdScore());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	@Override
	public int updateStudent(Connection conn, Student std) throws Exception {
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateStudent");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, std.getStdName());
			pstmt.setInt(2, std.getStdAge());
			pstmt.setString(3, std.getStdScore());
			pstmt.setInt(4, std.getStdNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	
	
}

	