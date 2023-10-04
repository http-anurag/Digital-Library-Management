package com.Annu2code.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
      private StudentDbUtil studentDbUtil;
	
	@Resource(name="jdbc/anurag")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
			
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password from the request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       		
		try {
			Student theStudent=studentDbUtil.getStudent(username);
			 //boolean isAuthenticated = authenticate(username, password);
			if ((theStudent.getIdS().equals(username)) && (theStudent.getFirstName()).equals(password)) {
	    		
	    		request.setAttribute("Student",theStudent);
	            // Redirect to a welcome page or perform further act
	    		
	    		RequestDispatcher dispatcher=request.getRequestDispatcher("/student-login.jsp");
	    		
	    		dispatcher.forward(request,response);
	        } else {
	            // Redirect back to the login page with an error message
	            response.sendRedirect("login-page.jsp?error=true");
	        }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Perform your authentication logic here (e.g., check username and password against a database)
       

    }   
}
