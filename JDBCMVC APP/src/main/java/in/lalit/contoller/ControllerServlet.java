package in.lalit.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.lalit.dto.Student;
import in.lalit.factory.StudentServiceFactory;
import in.lalit.service.IStudentService;


@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
	 IStudentService stdService=	StudentServiceFactory.getStudentService();
		
		String requestURI= request.getRequestURI();
		System.out.println(requestURI);
		
		RequestDispatcher rd=null;
		if(requestURI.endsWith("layout")) {
			rd =request.getRequestDispatcher("../layout.html");
			rd.forward(request, response);
			}
		
		if(requestURI.endsWith("addform")) {
			
			//taking the data from the form
			String sname=request.getParameter("sname"); 
			String sage = request.getParameter("sage");
			String sadd = request.getParameter("sadd");
			
			// printing the data in the console
			System.out.println(sname);
			System.out.println(sage);
			System.out.println(sadd);
			
			// sendding the data to the service layer through student object
			Student student= new Student();
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));
			student.setSadd(sadd);
			
			String status= stdService.save(student);
			System.out.println(status);
			
			if(status.equals("success")) {
				 rd = request.getRequestDispatcher("../success.html");
				 rd.forward(request, response);
				}else {
					rd =request.getRequestDispatcher("../failure.html");
				    rd.forward(request, response);
				}
			
		}
		
		
		// search logic
		if(requestURI.endsWith("searchform")) {
			String sid=request.getParameter("sid");
			 Student student=stdService.findById(Integer.parseInt(sid));
			 
			 if(student!=null) {
				 response.setContentType("text/html");
				 PrintWriter out = response.getWriter();
				 out.println("<html><head><title> Student Data</title></head>");
				 out.println("<body bgcolor='lightblue'>");
				 out.println("<table align='center' border='1'>");
				 out.println("<tr>");
				 out.println("<th>SID</th><td>"+student.getSid()+"</td </tr>");
				 out.println("<tr><th>SNAME</th><td>"+student.getSname()+"</td </tr>");
				 out.println("<tr><th>SAGE</th><td>"+student.getSage()+"</td </tr>");
				 out.println("<tr><th>SADD</th><td>"+student.getSadd()+"</td </tr>");
				 
				 out.println("</table>");
				 out.println("</body>");
				 out.println("</html>");
				 out.close();
				 
				 
				 
				 
			 }else {
				 rd =request.getRequestDispatcher("../notfound.html");
				 rd.forward(request, response);
				 
			 }
		}
		
		
	if(requestURI.endsWith("deleteform")) {
			String sid=request.getParameter("sid");
			String status= stdService.deleteById(Integer.parseInt(sid));
		
			
			if(status.equals("success")) {
				 rd = request.getRequestDispatcher("../success.html");
				 rd.forward(request, response);
				}else if(status.equals("failure")) {
					rd =request.getRequestDispatcher("../failure.html");
				    rd.forward(request, response);
				}else {
					rd =request.getRequestDispatcher("../notfound.html");
					rd.forward(request, response);
					
				}
			
		}
	
	
	if(requestURI.endsWith("editform")) {
		
		String sid =request.getParameter("sid");
		 Student student=stdService.findById(Integer.parseInt(sid));
		 if(student!=null) {
			 response.setContentType("text/html");
			 PrintWriter out= response.getWriter();	
			 
			 out.println("<html><head><title> Student Data Update</title></head>");
			 out.println("<body bgcolor='lightblue'>");
			 out.println("<form method='post' action='./controller/update'>");
			 out.println("<table align='center' border='1'>");
			 out.println("<tr> <th>ID </th> <td>"+student.getSid() +"</td></tr>");
			 out.println("<input type='hidden' name='sid' value='"+ student.getSid()  +"'/>");
			 
			 out.println("<tr> <th>Name </th> <td><input type='text' name='sname' value='"+ student.getSname()+"' /></td></tr>");
			 out.println("<tr> <th>Age </th> <td><input type='text' name='sage' value='"+ student.getSage()+"' /></td></tr>");
			 out.println("<tr> <th>Address </th> <td><input type='text' name='sadd' value='"+ student.getSadd()+"' /></td></tr>");
			 out.println("<tr> <th>Address </th> <td><input type='submit'  value='update' /></td></tr>");

			 

			 
			 
			 out.println("</table>");
			 out.println("</form>");
			 out.println("</body>");
			 out.println("</html>");
			 out.close();
			 
			 
		 }else {
			rd= request.getRequestDispatcher("../notfound.html");
			rd.forward(request, response);
		 }
		 
		
	}
	
	if(requestURI.endsWith("update")) {
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String sadd = request.getParameter("sadd");
		
//		System.out.println(sid);
//		System.out.println(sname);
//		System.out.println(sage);
//		System.out.println(sadd);
		
		Student student= new Student();
		student.setSid(Integer.parseInt(sid));
		student.setSname(sname);
		student.setSage(Integer.parseInt(sage));
		student.setSadd(sadd);
		
		String status=stdService.updateById(student);
		
		if(status.equals("success")) {
			 rd = request.getRequestDispatcher("/success.html");
			 rd.forward(request, response);
			}else if(status.equals("failure")) {
				rd =request.getRequestDispatcher("/failure.html");
			    rd.forward(request, response);
			}
	}
	
	
	
	
	
		
	}
	


}
