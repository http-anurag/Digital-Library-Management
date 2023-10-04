package com.Annu2code.web.jdbc;
import java.io.IOException;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String theCommand=request.getParameter("command");
			if(theCommand == null){
			   theCommand="LIST";	
			}
			switch(theCommand){
			case "LIST":listStudents(request,response);
			             break;
			case "ADD":addStudent(request,response);
			           break;
			case "PROF":getStudent(request,response);
			         break;
			case "LOAD":loadStudent(request,response);
			           break;
			case "UPDATE":updateStudent(request,response);
				    break; 
			case "DELETE":deleteStudent(request,response);
			       break;
			case "PAGE":pageStudents(request,response);
			    break;
			 default:listStudents(request,response);          
			           
			}
			
		} catch (Exception exc) {
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}	
		
	}
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		String theStudentId=request.getParameter("studentId");
		
		studentDbUtil.deletStudent(theStudentId);
		
		listStudents(request,response);
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		
		// read student info from form data
				int id = Integer.parseInt(request.getParameter("studentId"));
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String email = request.getParameter("email");
				
				// create a new student object
				Student theStudent = new Student(id, firstName, lastName, email);
				
				// perform update on database
				studentDbUtil.updateStudent(theStudent);
				
				// send them back to the "list students" page
				listStudents(request, response);
		
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		String theStudentId=request.getParameter("studentId");
		
		
		
		Student theStudent=studentDbUtil.getStudent(theStudentId);
		
		
		
		request.setAttribute("THE_STUDENT",theStudent);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Update.jsp");
		
		
		dispatcher.forward(request,response);
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		Student theStudent=new Student(firstName,lastName,email);
		
		
		studentDbUtil.addStudent(theStudent);
		 
		listStudents(request,response);
		
		// TODO Auto-generated method stub
		
	}

	private void listStudents(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		List<Student> students=studentDbUtil.getStudents();
		 
		
		request.setAttribute("STUDENT_LIST",students);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/list-student.jsp");
		 
		
		dispatcher.forward(request,response);
		
		}
private void pageStudents(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		List<Student> students=studentDbUtil.getStudents();
		 
		
		request.setAttribute("STUDENT_LIST",students);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Student-page.jsp");
		 
		
		dispatcher.forward(request,response);
		
		}
	private void getStudent(HttpServletRequest request,HttpServletResponse response)throws Exception{
        
		//int id = Integer.parseInt(request.getParameter("studentId"));
		
		Student student=studentDbUtil.getStudent("studentId");
		 
		
		request.setAttribute("STUDENT_LIST",student);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/login-page.jsp");
		 
		
		dispatcher.forward(request,response);
	  }
		
	}











