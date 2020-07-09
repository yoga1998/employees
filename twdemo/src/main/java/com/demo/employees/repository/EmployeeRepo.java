package com.demo.employees.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.employees.entity.Employees;



public interface EmployeeRepo extends JpaRepository<Employees, Integer> {
	
	@Query(value="select * from employees ORDER BY emp_no ",nativeQuery=true)
	public List<Employees> getAllEmployees();
	
	@Query("select new com.demo.employees.entity.Employees(e.empNo as empNo, e.birthDate as birthDate, e.firstName as firstName , e.lastName as lastName, e.gender as gender, e.hireDate as hireDate) from Employees e where e.empNo=:empNo")
	public Optional<Employees> getEmpById(@Param("empNo") Integer empNo);

}
