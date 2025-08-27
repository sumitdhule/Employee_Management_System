package com.task.requirement;

import java.util.List;

import com.task.beans.EmployeeData;

public interface EmployeeService {
	  boolean addUser(EmployeeData emp);
	   boolean deleteUser(String adharNumber);
	   boolean updateUser(String adharNumber, EmployeeData data);
	   List<EmployeeData> getAllUser();
	}
