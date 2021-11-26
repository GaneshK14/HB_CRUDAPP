package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.csi.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public void signUp(Employee employee) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(employee);
		transaction.commit();
	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub

		boolean status = false;

		Session session = factory.openSession();

		List<Employee> empList = session.createQuery("From Employee").list();

		for (Employee e : empList) {

			if (e.getEmpEmailId().equals(empEmailId) && e.getEmpPassword().equals(empPassword)) {
				status = true;
			}
		}
		return status;
	}

	@Override
	public Employee getEmpDataById(int empId) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();

		Employee employee = (Employee) session.get(Employee.class, empId);
		return employee;
	}

	@Override
	public List<Employee> getEmpAllData() {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		List<Employee> emplist = session.createQuery("From Employee").list();

		return emplist;
	}

	@Override
	public void updateEmpData(int empId, Employee employee) {
		// TODO Auto-generated method stub

		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		List<Employee> emplist=session.createQuery("From Employee").list();
		
		for(Employee e:emplist){
			
			if (e.getEmpId()==empId) {
				e.setEmpName(employee.getEmpName());
				e.setEmpContactNo(employee.getEmpContactNo());
				e.setEmpDob(employee.getEmpDob());
				e.setEmpEmailId(employee.getEmpEmailId());
				e.setEmpPassword(employee.getEmpPassword());
				
				session.update(e);
				transaction.commit();
			}
		}
	}

	@Override
	public void deleteEmpData(int empId) {
		// TODO Auto-generated method stub

		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		List<Employee> emplist=session.createQuery("From Employee").list();
		
		for(Employee e:emplist){
			
		if (e.getEmpId()==empId) {
			
			session.delete(e);
			transaction.commit();
		}
		}
	}

}
