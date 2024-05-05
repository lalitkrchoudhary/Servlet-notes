package in.lalit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/valid")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname= request.getParameter("username");
		String pass = request.getParameter("password");
		
		if(uname.equals("lalit" )&&pass.equals("kumar")) {
			
			// using context servlet also we can disapatched to another page
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/inbox.jsp");
			rd.forward(request, response);
			
		}else {
			RequestDispatcher rd= request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
	

}
