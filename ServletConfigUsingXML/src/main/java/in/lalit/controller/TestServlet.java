package in.lalit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ServletConfig config=	getServletConfig();
	
	response.setContentType("text/html");
	PrintWriter out= response.getWriter();
	out.println("<html><head><title>ServletConfig</title></head><body>");
	
	out.println("<table border='1' align='center'><tr><th>ParameterName</th><th>ParameterValue</th><tr>");
	Enumeration<String> parameterNames= config.getInitParameterNames();
	
	while(parameterNames.hasMoreElements()) {
	String parameterName=(String)	parameterNames.nextElement();
	String parameterValue= config.getInitParameter(parameterName);
	out.println("<tr><td>"+parameterName+"</td><td>"+parameterValue+"</td><tr>");
	}
	out.println("</table");
	
	out.println("</body></html>");
	
	
	
	
	out.close();
	
	
	}

}
