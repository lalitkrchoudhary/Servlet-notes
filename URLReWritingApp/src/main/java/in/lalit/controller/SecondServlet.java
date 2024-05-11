package in.lalit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// taking parameter from FirstServlet
		String atype=request.getParameter("atype");
		String abranch = request.getParameter("abranch");
		
		//// create session 
		HttpSession session= request.getSession();
		session.setAttribute("atype", atype);
		session.setAttribute("abranch", abranch);
		
		
				
				// sending the session through url
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<body bgcolor='lightgreen'>");
				out.println("<center>");
				out.println("<form method='get' action='"+response.encodeURL("./test3")+"'>");
				out.println("<table>");
				out.println("<tr><th>Depositor-Name</th><td><input type='text' name='dname' /></td></tr>  ");
				out.println("<tr><th>Depositor-Amount</th> <td><input type='text' name='damount' /></td></tr>");
				
				out.println("<tr><th></th><td><input type='submit' value='Next'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
				out.close();
		
		
		
	}

}
