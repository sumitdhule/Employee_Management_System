package com.task.EmployeeUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.task.implimentation.EmployeeServiceImplimentation;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		try {
			String adhar = req.getParameter("adhar");
			EmployeeServiceImplimentation e1=new EmployeeServiceImplimentation();
			boolean status = e1.deleteUser(adhar);
			if(status) {
				out.println("<h2>Data Deleted successfully</h2>");
				req.getRequestDispatcher("index.html")
		    	.include(req, res);
			}
			else {
				out.println("<h2>No data deleted</h2>");
				req.getRequestDispatcher("index.html")
		    	.include(req, res);
			}	
		} catch (Exception e) {
			out.println("Error");
			e.printStackTrace();
		}	
	}
}
