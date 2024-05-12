package in.lalit.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/test")
public class DemoFilter extends HttpFilter implements Filter {
       
   
    public DemoFilter() {
        System.out.println("FIlter is loading");
    }

    public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("filter is instantions");
    }
	

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		// First will call if we call the /test
		PrintWriter  out = response.getWriter();
		out.println("<h1>Filter is calling first</h1>");
		

		// pass the request along the filter chain
		chain.doFilter(request, response); // this line will call the servlet page
		
		//this will call after servlet will call
		out.println("<h1>After servlet the filter is called</h1>");
		
		out.close();
	}

	public void destroy() {
		System.out.println("fileter is de-instantions");
	}
	

}
