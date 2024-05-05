package in.lalit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/reg" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/apple"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "lalit")
		})
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection= null;
	public PreparedStatement pstmt=null;
	int row = 0;

	
	static{
		System.out.println("server is loading");
	}
	public TestApp() {
		System.out.println("server is initializng");
		
	}
	
	@Override
	public void init() throws ServletException {
	  ServletConfig config= getServletConfig();
	  String url= config.getInitParameter("url");
	  String user = config.getInitParameter("user");
	  String password = config.getInitParameter("password");
	  
	  try {
		  	Class.forName("com.mysql.cj.jdbc.Driver");
		 connection= DriverManager.getConnection(url, user, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//comming data from registeration page using parameter
		String rname=request.getParameter("username");
		String remail = request.getParameter("email");
		String rnumber = request.getParameter("number");
		String raddress = request.getParameter("address");
		
		String query = "insert into information(name,email,number,address) values(?,?,?,?)";
		try {
			if(connection != null) {
				
				pstmt=	connection.prepareStatement(query);
			}
			if(pstmt!=null) {
				
				pstmt.setString(1, rname);
				pstmt.setString(2, remail);
				pstmt.setString(3, rnumber);
				pstmt.setString(4, raddress);
				
				row= pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		out.println("<html><head><title>Database Connection using registeration page</title></head><body>");
		if(row==1) {
			out.println("<h1 style='color:green; text-align:center;'>Registration successful</h1>");
		}
		else {
			out.println("<h1 style='color:red; text-align:center;'>Registration Filed</h1>");
			
		}
		out.println("</body></html>	");		
		out.close();
		
		
		
		
	}

}
