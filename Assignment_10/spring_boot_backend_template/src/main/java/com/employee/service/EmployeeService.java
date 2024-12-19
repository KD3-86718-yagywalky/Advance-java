package com.employee.service;

import java.util.List;

import com.employee.pojos.Employee;

public interface EmployeeService {
	
	String addEmployee(Employee e);
	List<Employee> display();
	String updateEmployee(Long emp);
	String deleteEmployee(Long id);
	
	
}
