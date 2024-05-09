package in.lalit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test1")
public class FirstApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//collect request parameter data from the HTML page
		String name= request.getParameter("userName");
		String age= request.getParameter("userAge");
		
		//creating a session object and store these request parameter data in the obect
		HttpSession session= request.getSession();
		session.setAttribute("userName", name);
		session.setAttribute("userAge", age);
		
		//forward the page using dispatcher
		RequestDispatcher fd= request.getRequestDispatcher("form2.html");
		fd.forward(request, response);
		
	}

}
