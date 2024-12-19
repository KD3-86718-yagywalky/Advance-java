package com.employee.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Employee extends BaseEntity{
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	private String location;
	private String department;
	@Column(name = "join_date")
	private LocalDate joinDate;
	private Double salary;

}
