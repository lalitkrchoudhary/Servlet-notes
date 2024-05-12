package in.lalit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	static {
		System.out.println("servelt is loading");
	}
    public TargetServlet() {
       System.out.println("servelt is intantions ");
    }
    @Override
    public void init() throws ServletException {
    	System.out.println("servlet is init");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("<h1>SERVLET IS EXECUTED AND RETURN TO FILTER</H1>");
		
		
	}

}
