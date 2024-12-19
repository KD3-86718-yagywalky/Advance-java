package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.pojos.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>{

}
