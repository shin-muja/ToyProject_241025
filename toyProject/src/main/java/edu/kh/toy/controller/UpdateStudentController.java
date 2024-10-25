package edu.kh.toy.controller;

import java.io.IOException;

import edu.kh.toy.dto.Student;
import edu.kh.toy.service.ToyProjectService;
import edu.kh.toy.service.ToyProjectServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/update")
public class UpdateStudentController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int stdNo = Integer.parseInt(req.getParameter("stdNo"));
			String stdName = req.getParameter("stdName");
			int stdAge = Integer.parseInt(req.getParameter("stdAge"));
			String stdScore = req.getParameter("stdScore");
			String message;
			
			Student std = new Student().builder().stdNo(stdNo)
					.stdName(stdName).stdAge(stdAge)
					.stdScore(stdScore).build();
			
			ToyProjectService service = new ToyProjectServiceImpl();
			
			int result = service.updateStudent(std); 
			
			// 성공 시
			if( result > 0 ) {
				message = stdName + " 학생의 정보를 수정하였습니다";
				req.getSession().setAttribute("message", message);
				
				resp.sendRedirect("/");
				
				return;
			}
			
			// 실패 시
			message = "정보 수정에 실패하였습니다";
			req.setAttribute("std", std);
			req.getRequestDispatcher("/WEB-INF/viwes/update.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
