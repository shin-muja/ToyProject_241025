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
}
