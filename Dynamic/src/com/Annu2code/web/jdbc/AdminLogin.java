package com.Annu2code.web.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password from the request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform your authentication logic here (e.g., check username and password against a database)
        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
            // Redirect to a welcome page or perform further actions
            response.sendRedirect("StudentControllerServlet");
        } else {
            // Redirect back to the login page with an error message
            response.sendRedirect("login-page.jsp?error=true");
        }
    }

    private boolean authenticate(String username, String password) {
        // Implement your authentication logic here (e.g., check against a database)
        // For simplicity, you can hardcode credentials for testing.
        return "amartiwarirewa".equals(username) && "708936@com".equals(password);
    }
}
