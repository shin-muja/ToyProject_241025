package edu.kh.toy.dao;

import java.sql.Connection;
import java.util.List;

import edu.kh.toy.dto.Student;

public interface ToyProjectDAO {

	List<Student> stdFullSelect(Connection conn) throws Exception;

	Student detailStdNoSelect(Connection conn, int stdNo) throws Exception;

	int deleteStudent(Connection conn, int stdNo) throws Exception;

	int addStudent(Connection conn, Student std) throws Exception;

	int updateStudent(Connection conn, Student std) throws Exception;

}
