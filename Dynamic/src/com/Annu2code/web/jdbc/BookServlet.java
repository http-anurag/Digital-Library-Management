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

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
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
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
       		
		try {
			Student theStudent=studentDbUtil.getStudentBook(username);
			 //boolean isAuthenticated = authenticate(username, password);
			request.setAttribute("Student",theStudent);
	            // Redirect to a welcome page or perform further act
	    		
	    		RequestDispatcher dispatcher=request.getRequestDispatcher("/student-login.jsp");
	    		
	    		dispatcher.forward(request,response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//doGet(request, response);
	}

}
