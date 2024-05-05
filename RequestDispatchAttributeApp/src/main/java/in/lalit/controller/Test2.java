package in.lalit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test2")
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		Enumeration<String> attributeNames= request.getAttributeNames();
		out.println("<h1>hello to the attribute App");
		out.println("<table border='1'><tr><th>Name</th><th>Value</th>");
		
		
		while(attributeNames.hasMoreElements()) {
			String name=(String) attributeNames.nextElement();
			 Object value=request.getAttribute(name);
			out.println("<tr><td>"+name+"</td><td>"+value+"</td><tr>");
		}
		out.println("</table>");
		
		out.close();
		
	}

}
