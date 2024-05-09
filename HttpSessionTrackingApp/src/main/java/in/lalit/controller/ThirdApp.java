package in.lalit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstApp
 */
@WebServlet("/test3")
public class ThirdApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//collect request parameter data from the HTML page
		String email= request.getParameter("userEmail");
		String mobile= request.getParameter("userMobile");
		
		//creating a session object and store these request parameter data in the obect
		HttpSession session= request.getSession();
		session.setAttribute("userEmail", email);
		session.setAttribute("userMobile", mobile);
		
		// taking the data from the session object
		Object sname=session.getAttribute("userName");
		Object sage= session.getAttribute("userAge");
		Object squal=session.getAttribute("userQual");
		Object sdeg=session.getAttribute("userDeg");
		Object semail=session.getAttribute("userEmail");
		Object smobile=session.getAttribute("userMobile");
		
		//response page
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("<h1>Welcome to the data page</h1>");
		out.println("<table align='center' border='1px'>");
		out.println("<tr><th>Name</th><td>"+sname+"</td></tr>");
		out.println("<tr><th>Age</th><td>"+sage+"</td></tr>");
		out.println("<tr><th>Qualification</th><td>"+squal+"</td></tr>");
		out.println("<tr><th>Designation</th><td>"+sdeg+"</td></tr>");
		out.println("<tr><th>Email</th><td>"+semail+"</td></tr>");
		out.println("<tr><th>Mobile</th><td>"+smobile+"</td></tr>");
		out.println("</table>");
		out.close();
	}

}
