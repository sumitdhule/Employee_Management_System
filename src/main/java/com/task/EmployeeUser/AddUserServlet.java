package com.task.EmployeeUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.task.beans.EmployeeData;
import com.task.implimentation.EmployeeServiceImplimentation;



@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		try {
			String name = req.getParameter("name");
			int id = Integer.parseInt(req.getParameter("id"));
			String adhar = req.getParameter("adhar");
			
			EmployeeData emp = new EmployeeData(name, id, adhar);
			
			EmployeeServiceImplimentation e1 = new EmployeeServiceImplimentation();
			
			boolean status = e1.addUser(emp);
			if(status) {
				out.println("<h2>Inserted data successfully</h2>");
				req.getRequestDispatcher("index.html")
		    	.include(req, res);
			}
			else {
				out.println("<h2>No data inserted</h2>");
				req.getRequestDispatcher("index.html")
		    	.include(req, res);
			}
			
			
			
		} catch (Exception e) {
			out.println("Error");
			e.printStackTrace();
			}
	}

}
