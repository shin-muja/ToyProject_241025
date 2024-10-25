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

@WebServlet("/student/updateView")
public class UpdateView extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			ToyProjectService service = new ToyProjectServiceImpl();
			
			Student std = service.detailStdNoSelect(Integer.parseInt(req.getParameter("stdNo")));
			
			req.setAttribute("std", std);
			
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
						
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
