package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.employee.pojos.Employee;
import com.employee.service.EmployeeService;


@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	public EmployeeController() {
		System.out.println("COntroller");
	}

	@PostMapping("/")
	public ResponseEntity<?> InsetEmployee( @RequestBody Employee e) {
		System.out.println("in add Employee " + e);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(e));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> display(){
		System.out.println("in the display counter");
		List<Employee> list =  employeeService.display();
		if(list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();					
		}
		return  ResponseEntity.ok(list);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable Long id){
		
		System.out.println("in the update");
		
		return ResponseEntity.ok(employeeService.updateEmployee(id));
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
		
		System.out.println("In the delelte ");
		
		return ResponseEntity.ok(employeeService.deleteEmployee(id));
		
	}

}
