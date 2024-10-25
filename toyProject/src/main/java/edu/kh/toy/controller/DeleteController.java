package edu.kh.toy.controller;

import java.io.IOException;

import edu.kh.toy.service.ToyProjectService;
import edu.kh.toy.service.ToyProjectServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/delete")
public class DeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			ToyProjectService service = new ToyProjectServiceImpl();
			int stdNo = Integer.parseInt(req.getParameter("stdNo"));
			String message;
			
			// url창 쿼리스트림 /student/delete?stdNo=? 문제 해결
			if( service.checkStdNo(stdNo)) {
				message = "존재치 않는 학생입니다";
				
				req.getSession().setAttribute("message", message);
				resp.sendRedirect("/");
				
				return;
			}
			
			
			int result = service.deleteStudent(stdNo);
			
			if( result > 0 ) {
				
				message = "삭제 성공";
				
				req.getSession().setAttribute("message", message);
				resp.sendRedirect("/");
				
				return;
			}
			
			message = "삭제 실패";
			
			req.getSession().setAttribute("message", message);
			resp.sendRedirect("/WEB-INF/views/detail?stdNo=" + stdNo);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
