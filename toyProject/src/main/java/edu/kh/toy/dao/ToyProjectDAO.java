package edu.kh.toy.dao;

import java.sql.Connection;
import java.util.List;

import edu.kh.toy.dto.Student;

public interface ToyProjectDAO {

	List<Student> stdFullSelect(Connection conn) throws Exception;

}
