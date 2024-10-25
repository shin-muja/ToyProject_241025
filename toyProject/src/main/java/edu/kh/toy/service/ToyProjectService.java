package edu.kh.toy.service;

import java.util.List;

import edu.kh.toy.dto.Student;

public interface ToyProjectService {

	/** DB 전체 학생 목록
	 * @return stdList
	 */
	List<Student> stdFullSelect() throws Exception;

	/** 받은 stdNo를 사용하여 회원 1명 조회
	 * @param stdNo
	 * @return Student 객체
	 */
	Student detailStdNoSelect(int stdNo) throws Exception;

	/** 학생 제거
	 * @param stdNo
	 * @return
	 */
	int deleteStudent(int stdNo) throws Exception;

	/** 일치하는 학생 확인 dao.derailStdNoselect재활용
	 * @param stdNo
	 * @return
	 */
	boolean checkStdNo(int stdNo) throws Exception;

	/** 학생 추가
	 * @param std
	 * @return
	 */
	int addStudent(Student std) throws Exception;

	/** 학생 번호, 성별 제외 수정
	 * @param std
	 * @return
	 */
	int updateStudent(Student std) throws Exception;

	
	
	
}
