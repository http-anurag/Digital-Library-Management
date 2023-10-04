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

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDbUtil studentDbUtil;    
    /**
     * @see HttpServlet#HttpServlet()
     * 
     * 
     */
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
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String first_name=request.getParameter("firstname");
		String last_name=request.getParameter("lastname");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Student student= new Student(first_name,last_name,email,username,password);
		
		try {
			studentDbUtil.regStudent(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/login-page.jsp");
		
		dispatcher.forward(request,response);
		//listStudents(request,response)
	}

}
