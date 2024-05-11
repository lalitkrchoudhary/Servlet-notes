package in.lalit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test3")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//taking parameter from form using SecondServlet
		String dName = request.getParameter("dname");
		String dAmount = request.getParameter("damount");
		
		//taking out all the HttpSession which have been send through the servlet
		HttpSession session= request.getSession();
		Object aNo= session.getAttribute("anumber");
		Object aName= session.getAttribute("aname");
		Object aType= session.getAttribute("atype");
		Object aBranch= session.getAttribute("abranch");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='cyan'>");
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<tr><th>ACCOUT  NUMBER</th><td>" + aNo + "</td></tr>");
		out.println("<tr><th>ACCOUNT NAME</th><td>" + aName + "</td></tr>");
		out.println("<tr><th>ACCOUNT TYPE</th><td>" + aType + "</td></tr>");
		out.println("<tr><th>ACCOUNT BRANCH</th><td>" + aBranch + "</td></tr>");
		out.println("<tr><th>DEPT NAME</th><td>" + dName + "</td></tr>");
		out.println("<tr><th>DEPT AMOUNT</th><td>" + dAmount + "</td></tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		
		out.close();
		
		
	}

}
