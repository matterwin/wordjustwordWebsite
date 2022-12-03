package com.prog;


import java.io.IOException;


import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class postWord
 */
public class post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public post() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Cookie[] ck = request.getCookies();
		
		if(ck == null)
		{
			response.sendRedirect("main/Components/UserAuth/Login.html");
		}else {
		
			String title, lang, desc;
			title 	= request.getParameter("title");
			lang 	= request.getParameter("language");
			desc 	= request.getParameter("desc");
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
				String sql = "INSERT INTO posts (wordTitle, language, description, username) " +
							 "VALUES (\'" + title + "\', \'" + lang + "\', \'" + desc + "\', \'" + ck[0].getValue() + "\');";
				//sql = "SELECT * FROM student";
				System.out.println(sql);
				stmt.executeUpdate(sql);
				
				/*
				 * CREATE TABLE Posts(
						postId int NOT NULL AUTO_INCREMENT,
						wordTitle VARCHAR(255) NOT NULL,
						description VARCHAR(255) NOT NULL,
						language VARCHAR(255),
						likes int,
						comments int,
						PRIMARY KEY (postId)
					);
					ALTER TABLE Posts AUTO_INCREMENT=1;
				*/
	
			} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////////////////////////////////////
			
			response.setContentType("text/html;charset=UTF-8");
			final PrintWriter out = response.getWriter();
			
			response.sendRedirect("main/index.html");
			
			out.println("<script type=\"text/javascript\">");
			out.println("location='main/index.html");
			out.println("alert('You have successfully made a post!');");
			out.println("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
