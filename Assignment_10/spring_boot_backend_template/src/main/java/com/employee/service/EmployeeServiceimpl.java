package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.pojos.Employee;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceimpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;
	
	

	public EmployeeServiceimpl() {
		System.out.println("service");
	}

	@Override
	public String addEmployee(Employee e) {
		
		Employee emp = employeeDao.save(e);
		return "Haa bhai save ho gaya hai "+emp.getFirstName();
	}

	@Override
	public List<Employee> display() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	public String deleteEmployee(Long id) {
		if(employeeDao.existsById(id)) {
				employeeDao.deleteById(id);
				return "Employee belong to "+id+"is deleted successfully";
		}
		return "Invalid id or Unable to find the employee by this id";
	}

	@Override
	public String updateEmployee(Long emp) {
			
		Employee p = employeeDao.findById(emp).orElseThrow();
			Employee e = employeeDao.save(p);
		 
		 	employeeDao.save(e);
			
			return "Employee update successfully";
		}

}
