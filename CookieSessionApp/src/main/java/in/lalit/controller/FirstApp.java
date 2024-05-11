package in.lalit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class FirstApp extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//calling paramaters from the the html form
		String cid=request.getParameter("pid");
		String cname = request.getParameter("pname");
		
		// creating cookie of each input
		Cookie c1= new Cookie("pid", cid);
		Cookie c2 = new Cookie("pname", cname);
		
		
		// sending the cookie in the response object
		response.addCookie(c1);
		response.addCookie(c2);
		
		//sending the page the to next form2
		RequestDispatcher fd= request.getRequestDispatcher("/form2.html");
		fd.forward(request, response);
		
		
	}

}
