package com.csi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
// updated by shubham
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int empId;
	private String empName;
	//@Column(unique=true)
	private long empContactNo;
	@Temporal(TemporalType.DATE)
	private Date empDob;
	@Column(unique=true)
	private String empEmailId;
	private String empPassword;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public long getEmpContactNo() {
		return empContactNo;
	}
	public void setEmpContactNo(long empContactNo) {
		this.empContactNo = empContactNo;
	}
	public Date getEmpDob() {
		return empDob;
	}
	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}
	public String getEmpEmailId() {
		return empEmailId;
	}
	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	
}
