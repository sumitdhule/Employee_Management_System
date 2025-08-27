package com.task.EmployeeUser;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.task.beans.EmployeeData;
import com.task.implimentation.EmployeeServiceImplimentation;


@WebServlet("/getUser")
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		try {
			
			
			EmployeeServiceImplimentation e1 = new EmployeeServiceImplimentation();
			
			List<EmployeeData> viewData = e1.getAllUser();
			
//			out.println("<h2>User List </h2><table border='1'><tr><th>ID</th><th>Name </th><th>AdharNumber</th></tr>");
//			out.println("<table border='1'>");
//			out.println("<tr>");
//			out.println("<th>ID</th>");
//			out.println("<th>Name</th>");
//			out.println("<th>AdharNumber</th>");
//			out.println("</tr>");
			
//			for(EmployeeData u : viewData) {
//				out.println("<tr><td>" + u.getId() + "</td><td>" + u.getName() + "</td><td>" + u.getAdharNumber() + "</td></tr>");
//			}
//			
//			out.println("</table><br><a href='index.html'>Back</a>");
			
			req.setAttribute("userList", viewData);
			
			req.getRequestDispatcher("userList.jsp").forward(req,res);

			
			
		} catch (Exception e) {
			out.println("Error");
			e.printStackTrace();
			res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Error loading users");
		}
	}

}
