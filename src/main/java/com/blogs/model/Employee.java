package com.blogs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Emplo")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	private String perName;
	private Float perSalary;
	private int perAge;
	private String perCity;
//---------------------------------------------------------
	public Employee(Long empId, String perName, Float perSalary, int perAge, String perCity) {
		super();
		this.empId = empId;
		this.perName = perName;
		this.perSalary = perSalary;
		this.perAge = perAge;
		this.perCity = perCity;
	}
//-------------------------------------------------------------
	public Employee()
	{
		
	}
//--------------------------------------------------------------
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getPerName() {
		return perName;
	}
	public void setPerName(String perName) {
		this.perName = perName;
	}
	public Float getPerSalary() {
		return perSalary;
	}
	public void setPerSalary(Float perSalary) {
		this.perSalary = perSalary;
	}
	public int getPerAge() {
		return perAge;
	}
	public void setPerAge(int perAge) {
		this.perAge = perAge;
	}
	public String getPerCity() {
		return perCity;
	}
	public void setPerCity(String perCity) {
		this.perCity = perCity;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", perName=" + perName + ", perSalary=" + perSalary + ", perAge=" + perAge
				+ ", perCity=" + perCity + "]";
	}
	
//----------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
}

