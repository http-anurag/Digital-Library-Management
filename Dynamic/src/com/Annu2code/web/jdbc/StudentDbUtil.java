package com.Annu2code.web.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class StudentDbUtil {

	private DataSource dataSource;

	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Student> getStudents() throws Exception {
		
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from student order by id";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				// create new student object
				Student tempStudent = new Student(id, firstName, lastName, email);
				
				// add it to the list of students
				students.add(tempStudent);				
			} 
			
			return students;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}	
	}

	public void addStudent(Student theStudent)throws Exception {
     		
		 Connection myConn=null;
		 PreparedStatement myStmt=null;
				 try {
					 myConn=dataSource.getConnection();
					 String sql="insert into student"+"(first_name,last_name,email)"+"values(?,?,?)";
				     
					 myStmt=myConn.prepareStatement(sql);
					 
					 myStmt.setString(1,theStudent.getFirstName());
					 myStmt.setString(2,theStudent.getLastName());
					 myStmt.setString(3,theStudent.getEmail());
					 
					 myStmt.execute(); 
				 }
		 finally {
			 close(myConn,myStmt,null);
		 }
		// TODO Auto-generated method stub
		
	}

	public void regStudent(Student theStudent)throws Exception {
 		
		 Connection myConn=null;
		 PreparedStatement myStmt=null;
				 try {
					 myConn=dataSource.getConnection();
					 String sql="insert into student"+"(first_name,last_name,email,userid,password)"+"values(?,?,?,?,?)";
				     
					 myStmt=myConn.prepareStatement(sql);
					 
					 myStmt.setString(1,theStudent.getFirstName());
					 myStmt.setString(2,theStudent.getLastName());
					 myStmt.setString(3,theStudent.getEmail());
					 myStmt.setString(4,theStudent.getUserid());
					 myStmt.setString(5,theStudent.getPassword());
					 
					 myStmt.execute(); 
				 }
		 finally {
			 close(myConn,myStmt,null);
		 }
		// TODO Auto-generated method stub
		
	}

	
	public Student getStudent(String theStudentId)throws Exception{
		// TODO Auto-generated method stub
		Student theStudent=null;
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		int studentId;
		try{
			studentId=Integer.parseInt(theStudentId);
			
			myConn=dataSource.getConnection();
			
			String sql="select *from student where id=?";
			
			
		myStmt=myConn.prepareStatement(sql);
		
		myStmt.setInt(1,studentId);
		
		myRs=myStmt.executeQuery();
		
		if(myRs.next()) {
			
			String firstName=myRs.getString("first_name");
			String lastName=myRs.getString("last_name");
			String email=myRs.getString("email");
			
			theStudent=new Student(studentId,firstName,lastName,email);
		}else
		{
			throw new Exception("Could Not Find Student ID :"+studentId);
		}
			
		return theStudent;
		
		}finally {
		
		close(myConn,myStmt,myRs);
		}
		
	}


	public void updateStudent(Student theStudent)throws Exception{
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update student "
						+ "set first_name=?, last_name=?, email=? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());
			myStmt.setInt(4, theStudent.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deletStudent(String theStudentId)throws Exception{
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement myStmt=null;
		try {
		
		 int studentId=Integer.parseInt(theStudentId);
		 
		 conn=dataSource.getConnection();
		 
		 String sql="delete from student where id=?";
		 
		 
		 myStmt=conn.prepareStatement(sql);
		 
		 myStmt.setInt(1,studentId);
		 
		 myStmt.execute();
		}
		finally {
         close(conn,myStmt,null);
		}
	}

	public Student getStudentBook(String username) throws Exception {
		// TODO Auto-generated method stub
		Student theStudent=null;
		Connection myConn=null;
		PreparedStatement myStmt=null;
		PreparedStatement myStmt1=null;
		ResultSet myRs=null;
		int studentId;
		try{
			studentId=Integer.parseInt(username);
			
			myConn=dataSource.getConnection();

			String sql="update Student set a_book = a_book + 1 where id = ?";
			
			
		   myStmt=myConn.prepareStatement(sql);
		
		   myStmt.setInt(1,studentId);
		   myRs=myStmt.executeQuery();
			
			String sql1="select *from student where id=?";
			
		    myStmt1=myConn.prepareStatement(sql1);
		
		   myRs=myStmt1.executeQuery();
		
		if(myRs.next()) {
			
			String firstName=myRs.getString("first_name");
			String lastName=myRs.getString("last_name");
			String email=myRs.getString("email");
			
			theStudent=new Student(studentId,firstName,lastName,email);
		}else
		{
			throw new Exception("Could Not Find Student ID :"+studentId);
		}
			
		return theStudent;
		
		}finally {
		
		close(myConn,myStmt,myRs);
		}
	}
}		














