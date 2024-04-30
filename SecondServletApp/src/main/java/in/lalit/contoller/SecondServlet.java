package in.lalit.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class SecondServlet extends HttpServlet {
	static {
		System.out.println("Servlet loading.......");
	}
	
	public SecondServlet() {
		System.out.println("Servlet instationous......");
	}
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ServletConfig config= getServletConfig();
		System.out.println("config object available :"+config);
	}
	
  @Override
public void init(ServletConfig config) throws ServletException {
	System.out.println("init is called with parameter");
}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Set the response type
		response.setContentType("text/html");
		
		//2. Getting the PrintWriter object to send the response
		PrintWriter out = response.getWriter();
		
		//3. Setting the HTML Page to write the response
		out.println("<html> <head> <title> OUTPUT </title> <head>");
		out.println("<body>");
		out.println("<h1> I am resposne from the get </h1>");
		out.println("</body></html>");
		
		//4. Close the response object
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		        //1. Set the response type
				response.setContentType("text/html");
				
				//2. Getting the PrintWriter object to send the response
				PrintWriter out = response.getWriter();
				
				//3. Setting the HTML Page to write the response
				out.println("<html> <head> <title> OUTPUT </title> <head>");
				out.println("<body>");
				out.println("<h1> I am resposne from the post </h1>");
				out.println("</body></html>");
				
				//4. Close the response object
				out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet is destroy and recreateds");
	}

}
