package com.slashcode.home;

import java.io.IOException;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class loadInFeed
 */

public class loadInFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadInFeed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String title="", desc="", lang="", user="", likesStry="";
		int postId = 0;
		int likesInty = 0;
		
		HashMap<Integer, List<String>> postList = new HashMap<>();
		
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
			 sql = "SELECT * FROM posts ORDER BY postId ASC;";
			 System.out.println(sql);
			 ResultSet rs = (ResultSet) stmt.executeQuery(sql);
			 
		 	//STEP 5: Extract data from result set
			 while(rs.next()){
				 //Retrieve by column name
				 postId = rs.getInt("postId");
				 likesInty = rs.getInt("likesTotal");
				 title = rs.getString("wordTitle");
				 desc = rs.getString("description");
				 lang = rs.getString("language");
				 user = rs.getString("username");
				 
				 likesStry = String.valueOf(likesInty);
				 
				 if(desc.equals("null")) desc = "(User has left description empty, what a weirdo)";
				 
				 postList.put(postId, Arrays.asList(title, desc, lang, user, likesStry));
			 }
			 
			 
		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block		
			e.printStackTrace();
			return;
		}
		
		System.out.println(Arrays.asList(postList));
		 
		request.setAttribute("listOfPosts", postList);
		
		RequestDispatcher rd = request.getRequestDispatcher("./main/Components/Forums/dynamicFeed.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
