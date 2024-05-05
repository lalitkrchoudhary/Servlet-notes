package in.lalit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//if we want to connect with another module then we have to do "crossContext="true" in contex.xml file"
		ServletContext context= getServletContext();
		ServletContext fc= context.getContext("/PhonePapp");
		RequestDispatcher fcd= fc.getRequestDispatcher("/test2");
		fcd.forward(request, response);
		
		
	}

}
