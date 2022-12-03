

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class userSignUp
 */
public class userSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username, email, password;
		username 	= request.getParameter("username");
		email 		= request.getParameter("email");
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
			String sql = "INSERT INTO users (userName, email, password) " +
						 "VALUES (\'" + username + "\', \'" + email + "\', \'" + password + "\');";
			//sql = "SELECT * FROM student";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			
			/*
			 * CREATE TABLE Users(
				userName VARCHAR(255) NOT NULL,
				password VARCHAR(255) NOT NULL,
				email VARCHAR(255) NOT NULL,
				name VARCHAR(255),
				country VARCHAR(255),
				language VARCHAR(255),
				PRIMARY KEY (userName)
			);
			*/

		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
			
			response.setContentType("text/html;charset=UTF-8");
			final PrintWriter out = response.getWriter();
			
			System.err.println("Error case: userName is already registered or you didn't input anything++++++++++++++++");
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Choose another username; come on be original!');");
			out.println("</script>"); 
		
			response.sendRedirect("main/Components/UserAuth/Signup.html");
			
			return;
		}
		////////////////////////////////////
		
		response.setContentType("text/html;charset=UTF-8");
		final PrintWriter out = response.getWriter();
		
		
		out.println("<script type=\"text/javascript\">");
		response.sendRedirect("main/Components/UserAuth/Login.html");
		out.println("</script>"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
