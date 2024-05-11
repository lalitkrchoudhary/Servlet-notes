package in.lalit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//taking parameter from html page
		 String anumber =request.getParameter("anumber");
		 String aname = request.getParameter("aname");
		 
		// create session 
		HttpSession session= request.getSession();
		session.setAttribute("anumber", anumber);
		session.setAttribute("aname", aname);
		
		// sending the session through url
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='lightgreen'>");
		out.println("<center>");
		out.println("<form method='get' action='"+response.encodeURL("./test2")+"'>");
		out.println("<table>");
		out.println("<tr><th>Account-Type</th><td><input type='text' name='atype' /></td></tr>  ");
		out.println("<tr><th>Account-Branch</th> <td><input type='text' name='abranch' /></td></tr>");
		
		out.println("<tr><th></th><td><input type='submit' value='Next'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.close();
	}

}
