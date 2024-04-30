package in.lalit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/test"}, loadOnStartup = 10)
public class BrowserResponseApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	static {
		System.out.println("test is on loading..");
	}
    public BrowserResponseApp() {
        super();
        System.out.println("Test browser app INstantiation");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		System.out.println("Browser doGet method is started");
		response.setContentType("text/html");
		
		 PrintWriter out = response.getWriter();
		 
		 Enumeration<String> headerNames= request.getHeaderNames();		 
		 out.println("<html><head><title>Browser</title></head>");
		 out.println("<body> <h1> Request Header Information..</h1>");
		 out.println("<table border='1' align='center'>");
		 out.println("<tr> <th>Header Name</th> <th>Header Value</th><tr>");
		 
		 while(headerNames.hasMoreElements()) {
			 out.println("<tr>");
			 String headerName= headerNames.nextElement();
			 String headerValue=request.getHeader(headerName);
			 out.println("<td>"+headerName+"</td> <td>"+headerValue+ "</td>");
			 out.println("<tr>");
		 }
		 
		 out.println("</table> </body> </html>");
		 out.close();
		 
		 
	
	
	
	}

}
