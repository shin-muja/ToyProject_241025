package edu.kh.toy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.toy.dto.Student;
import edu.kh.toy.service.ToyProjectService;
import edu.kh.toy.service.ToyProjectServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainController extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			ToyProjectService service = new ToyProjectServiceImpl();
			
			List<Student> stdList = new ArrayList<Student>();
			
			stdList = service.stdFullSelect();
			
			req.setAttribute("stdList", stdList);
			req.setAttribute("totalStudent", stdList.size());
			
			
			req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
