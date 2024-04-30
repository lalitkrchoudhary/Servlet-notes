package in.lalit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServletApp
 */
@WebServlet("/demo")
public class DemoServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	static {
		System.out.println("demo servlet is loading..");
	}
    public DemoServletApp() {
        System.out.println("demo servlet is INstantiation");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("demo doGet method is running");
		System.out.println("RequestProcessing for GET Request Type");
		System.out.println("Client IP address :"+request.getRemoteAddr());
		System.out.println("Client Host :" + request.getRemoteHost());
		System.out.println("Client Port :"+ request.getRemotePort());
		System.out.println("Server Name :"+ request.getServerName());
		System.out.println("Server Port :"+request.getServerPort());
		
	}

}
