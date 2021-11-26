package com.csi.service;

import java.util.List;

import com.csi.dao.EmployeeDao;
import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();

	@Override
	public void signUp(Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.signUp(employee);
	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.signIn(empEmailId, empPassword);
	}

	@Override
	public Employee getEmpDataById(int empId) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.getEmpDataById(empId);
	}

	@Override
	public List<Employee> getEmpAllData() {
		// TODO Auto-generated method stub
		return employeeDaoImpl.getEmpAllData();
	}

	@Override
	public void updateEmpData(int empId, Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.updateEmpData(empId, employee);
	}

	@Override
	public void deleteEmpData(int empId) {
		// TODO Auto-generated method stub
		employeeDaoImpl.deleteEmpData(empId);
	}

}
