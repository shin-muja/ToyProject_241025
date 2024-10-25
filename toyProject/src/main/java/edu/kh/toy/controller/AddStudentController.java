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
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/addStudent")
public class AddStudentController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String stdName = req.getParameter("stdName");
			int stdAge = Integer.parseInt(req.getParameter("stdAge"));
			String stdGender = req.getParameter("stdGender");
			String stdScore = req.getParameter("stdScore");
			String message;
			HttpSession session = req.getSession();
			
			ToyProjectService service = new ToyProjectServiceImpl();
			
			Student std = new Student().builder().stdName(stdName)
								.stdAge(stdAge).stdGender(stdGender)
								.stdScore(stdScore).build();
			
			int result = service.addStudent(std);
			
			if( result > 0 ) {
				message = "추가 성공";
				session.setAttribute("message", message);
				resp.sendRedirect("/");
				
				return;
			}
			

			message = "추가 실패 다시 입력 해주세요";
			session.setAttribute("message", message);
			
			resp.sendRedirect(message);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
