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
	
	
}
