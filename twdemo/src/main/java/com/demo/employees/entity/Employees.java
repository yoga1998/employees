package com.demo.employees.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@NoArgsConstructor
public class Employees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empNo;
	
	private Date birthDate;
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private Date hireDate;

	public Employees(Integer empNo, Date birthDate, String firstName, String lastName, String gender, Date hireDate) {
		
		this.empNo = empNo;
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.hireDate = hireDate;
	}
	
	

}
