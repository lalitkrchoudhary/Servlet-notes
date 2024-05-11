package in.lalit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test3")
public class ThirdApp extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//calling paramaters from the the html form
		String cmanu=request.getParameter("pmanu");
		String cdate = request.getParameter("pdate");
		
		// taking out all the cookie from the request object
	   Cookie[] cookie= request.getCookies();
	   
	    String cc1=cookie[0].getValue();
	    String cc2=cookie[1].getValue();
	    String cc3=cookie[2].getValue();
	    String cc4=cookie[3].getValue();
	    
	    
	  //response page
	  		response.setContentType("text/html");
	  		PrintWriter out= response.getWriter();
	  		out.println("<h1>RESULT</h1>");
	  		out.println("<table align='center' border='1px'>");
	  		out.println("<tr><th>ID</th><td>"+cc1+"</td></tr>");
	  		out.println("<tr><th>NAME</th><td>"+cc2+"</td></tr>");
	  		out.println("<tr><th>COST</th><td>"+cc3+"</td></tr>");
	  		out.println("<tr><th>QUANTITY</th><td>"+cc4+"</td></tr>");
	  		out.println("<tr><th>MANUFACTURE</th><td>"+cmanu+"</td></tr>");
	  		out.println("<tr><th>EXPIRY</th><td>"+cdate+"</td></tr>");
	  		out.println("</table>");
	  		out.close();
	    
		
	}

}
