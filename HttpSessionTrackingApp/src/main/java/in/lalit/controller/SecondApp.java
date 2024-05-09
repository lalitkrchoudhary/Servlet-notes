package in.lalit.controller;

import java.io.IOException;

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
@WebServlet("/test2")
public class SecondApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//collect request parameter data from the HTML page
				String qual= request.getParameter("userQual");
				String deg= request.getParameter("userDeg");
				
				//creating a session object and store these request parameter data in the obect
				HttpSession session= request.getSession();
				session.setAttribute("userQual", qual);
				session.setAttribute("userDeg", deg);
				
				//forward the page using dispatcher
				RequestDispatcher fd= request.getRequestDispatcher("form3.html");
				fd.forward(request, response);
	}

}
