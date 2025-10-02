package com.task.connectionProvider;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("Connected");
		Connection con;
		final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
		final String DB_USER = "akash";
		final String DB_PASS = "0000";
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String user = req.getParameter("username");
		String password = req.getParameter("password");
		String query = "select * from login where username=? and password=?";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd = req.getRequestDispatcher("index.html");
				rd.include(req, res);
			}
			else {
				out.println("<h3 style=\"color: rgb(226, 173, 173);\">Invalid Username or Password</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("Login.html");
				rd.forward(req, res);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
}