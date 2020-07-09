package com.demo.employees.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employees.entity.Employees;
import com.demo.employees.repository.EmployeeRepo;



@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo repo;
	
	@GetMapping("/get-employees")
	public List<Employees> getAllEmployees() {
		return repo.getAllEmployees();
	}
	
	
	@PostMapping("/save-employee")
	public Employees postEmployee(@Valid @RequestBody Employees emp) {
		return repo.save(emp);
	}
	
	@PutMapping("/update-employee/{id}")
	public String updateEmployee(@RequestParam Integer empNo,
			@Valid @RequestBody Employees empDetails)
	{
		Optional<Employees> op = repo.getEmpById(empNo);
		if(op.isPresent()) {
			Employees emp = op.get();
			String fn = empDetails.getFirstName();
			Date bd = empDetails.getBirthDate();
			String ln = empDetails.getLastName();
			String gn = empDetails.getGender();
			Date hd = empDetails.getHireDate();
			
			
			emp.setFirstName(fn !=null ? fn : emp.getFirstName());
			emp.setBirthDate(bd != null ? bd : emp.getBirthDate());
			emp.setLastName(ln != null ? ln : emp.getLastName());
			emp.setGender(gn != null ? gn : emp.getGender());
			emp.setHireDate(hd != null ? hd : emp.getHireDate());
			repo.save(emp);
			return "updated successfully"+ repo.save(emp) ;
		}
		else {
			return "Record not found";
		}
	}
	
	@DeleteMapping("/delete-employee/{id}")
	public String deleteEmployee(@RequestParam Integer empNo) {
		Optional<Employees> op = repo.findById(empNo);
		if(op.isPresent()) {
			Employees emp =op.get();
			repo.delete(emp);
			return "Record deleted successfully";
		} else {
			return "Record not found";
		}
	}

}
