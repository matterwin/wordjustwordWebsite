package com.prog;

import java.io.IOException;


import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Logger
 */
public class Logger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String loggedUser = null;
	private String loggedUserPassword = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username, password;
		username 	= request.getParameter("username");
		password 	= request.getParameter("password");
		
		///////////////////////////////
		// JDBC driver name and database URL
		 String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		 //String DB_URL = "jdbc:mysql://52.26.86.130:3306/student";
		 String DB_URL = "jdbc:mysql://localhost:3306/wordDB";

		 // Database credentials
		 String USER = "root";
		 String PASS = "";

		 Connection conn = null;
		 Statement stmt = null;
		 //STEP 2: Register JDBC driver
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 //STEP 3: Open a connection
			 System.out.println("Connecting to database...");
			 conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
			 //STEP 4: Execute a query
			 System.out.println("Creating statement...");
			 stmt = (Statement) conn.createStatement();
			 String sql;
			 sql = "SELECT * FROM users WHERE userName=\'"+ username + "\' and password=\'"+ password + "\';";
			 System.out.println(sql);
			 ResultSet rs = (ResultSet) stmt.executeQuery(sql);
			 
		 	//STEP 5: Extract data from result set
			 while(rs.next()){
				 //Retrieve by column name
				 loggedUser = rs.getString("userName");
				 loggedUserPassword = rs.getString("password");
				 System.out.println("Username: " + loggedUser + " && Password: " + loggedUserPassword);
			 }			 
			 
		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block		
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		
		if(loggedUser == null || loggedUserPassword == null){
			response.setContentType("text/html;charset=UTF-8");
			
			System.err.println("ERROR: Your credentials did not match what's in our system!");

			response.sendRedirect("main/Components/UserAuth/Login.html");
			return;
		}
		
		System.out.println("User successfully logged in!");
		
		Cookie ck = new Cookie("username", loggedUser);
		Cookie ck2 = new Cookie("password", loggedUserPassword);
		
		response.addCookie(ck);
		response.addCookie(ck2);
		
		response.sendRedirect("main/index.html");
		
	}

}
