package com.blogs.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.Repository.EmployeeRepository;
import com.blogs.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/employee")
	public Employee createNewEmployee(@RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
//		 "Employee Created In database";
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> list=new ArrayList<Employee>();
		employeeRepository.findAll().forEach(list::add);
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{empid}")  // Note: Use lower camel case for method parameter
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empid") Long empid) {
	    Optional<Employee> emp = employeeRepository.findById(empid);
	    
	    if (emp.isPresent()) {
	        return ResponseEntity.ok(emp.get());  // ResponseEntity.ok() is shorthand for returning 200 OK status
	    } 
	    else 
	    {
	        return ResponseEntity.notFound().build();  // Return 404 Not Found
	    }
	}
	
	@PutMapping("/{empid}")
	public ResponseEntity<String> updateByid(@PathVariable long empid ,@RequestBody Employee employee)
	{
	 Optional<Employee>emp=	employeeRepository.findById(empid);
	 if(emp.isPresent())
	 {
		 Employee existEmployee=emp.get();
		 existEmployee.setPerAge(existEmployee.getPerAge());
		 existEmployee.setPerName(existEmployee.getPerName());
		 existEmployee.setPerSalary(existEmployee.getPerSalary());
		 existEmployee.setPerCity(existEmployee.getPerCity());
		 employeeRepository.save(existEmployee);
		 return ResponseEntity.ok("details saved");
	 }
	 else {
		 return ResponseEntity.notFound().build();
	 }
	
	}
	
	@DeleteMapping("/{empid}")
	public String deletebyId(@PathVariable Long empid)
	{
		employeeRepository.deleteById(empid);
		return "employee deleted successfuullyy";
	}
	
//	@DeleteMapping("/{empid}")
//	public ResponseEntity<String> deletebyId(@PathVariable Long empid)
//	{
//		employeeRepository.deleteById(empid);
//		return ResponseEntity.ok("deleted");
//	}

	
	
	
	
}
