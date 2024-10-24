package edu.kh.toy.service;

import java.util.List;

import edu.kh.toy.dto.Student;

public interface ToyProjectService {

	/** DB 전체 학생 목록
	 * @return stdList
	 */
	List<Student> stdFullSelect() throws Exception;
	
	
}
