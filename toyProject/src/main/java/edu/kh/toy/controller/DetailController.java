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

@WebServlet("/student/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int stdNo = Integer.parseInt(req.getParameter("stdNo"));
			ToyProjectService service = new ToyProjectServiceImpl();
			
			String message;
			
			if( service.checkStdNo(stdNo)) {
				message = "존재치 않는 학생입니다";
				
				req.getSession().setAttribute("message", message);
				resp.sendRedirect("/");
				
				return;
			}
			
			Student std = service.detailStdNoSelect(stdNo);
			
			req.setAttribute("std", std);
			
			req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req, resp);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
