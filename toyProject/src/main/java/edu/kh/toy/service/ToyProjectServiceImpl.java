package edu.kh.toy.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.toy.dao.ToyProjectDAO;
import edu.kh.toy.dao.ToyProjectDAOImpl;
import edu.kh.toy.dto.Student;

import static edu.kh.toy.common.JDBCTemplate.*;

public class ToyProjectServiceImpl implements ToyProjectService {
	
	private ToyProjectDAO dao = new ToyProjectDAOImpl();

	@Override
	public List<Student> stdFullSelect() throws Exception {
		
		Connection conn = getConnection();
		
		List<Student> stdList = dao.stdFullSelect(conn);
		
		close(conn);
		
		return stdList;
	}

	@Override
	public Student detailStdNoSelect(int stdNo) throws Exception {
		
		Connection conn = getConnection();
		
		Student std = dao.detailStdNoSelect(conn, stdNo);
		
		close(conn);
				
		return std;
	}

	@Override
	public int deleteStudent(int stdNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteStudent(conn, stdNo);
		
		if(result > 0 ) commit(conn);
		else			rollback(conn);

		close(conn);
		
		return result;
	}

	
	public boolean checkStdNo(int stdNo) throws Exception {
		
		Connection conn = getConnection();
		
		if( dao.detailStdNoSelect(conn, stdNo) == null ) return true;
		
		return false;
	}

	@Override
	public int addStudent(Student std) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.addStudent(conn, std);
		
		if( result > 0 ) commit(conn);
		else			 rollback(conn);
		
		close(conn);
		
		return result;
	}

	@Override
	public int updateStudent(Student std) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.updateStudent(conn, std);
		
		close(conn);
		
		return result;
		
	}

	
	
}
