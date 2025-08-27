package com.task.implimentation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.task.beans.EmployeeData;
import com.task.connectionProvider.DBConnection;
import com.task.requirement.EmployeeService;

public class EmployeeServiceImplimentation implements EmployeeService{

	@Override
	public boolean addUser(EmployeeData emp) {
		
			boolean status = false;
		try {
			
			Connection conn  = DBConnection.getConnection();
			String query = "Insert into EmployeeData values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, emp.getName());
			ps.setInt(2, emp.getId());
			ps.setString(3, emp.getAdharNumber());
			
			int rows = ps.executeUpdate();
			 
			status = rows > 0;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public boolean deleteUser(String adharNumber) {
		
		boolean status = false;
		try {
			Connection conn  = DBConnection.getConnection();
			String query = "Delete from employeeData where adharNo = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1,adharNumber);
			
			int rows = ps.executeUpdate();
			status = rows > 0;
//			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return status;
	}

	@Override
	public boolean updateUser(String adharNumber, EmployeeData data) {
		
		boolean status = false;
		try {
			Connection conn = DBConnection.getConnection();
			String query = "Update Employeedata set name=? , id=? where adharno=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, data.getName());
			ps.setInt(2, data.getId());
			ps.setString(3, adharNumber);
			
			int rows = ps.executeUpdate();
			status = rows >0;
//			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return status;
	}

	@Override
	public List<EmployeeData> getAllUser() {
		
		List<EmployeeData> list = new ArrayList<>();
		
		try {
			Connection conn = DBConnection.getConnection();
			String query = "Select * from employeedata";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				int id = rs.getInt("id");
				String adhar = rs.getString("adharno");
				EmployeeData emp = new EmployeeData(name, id, adhar);
					
				list.add(emp);
				
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}

}
