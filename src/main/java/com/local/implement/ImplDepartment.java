package com.local.implement;

import com.local.DAO.DepartmentDAO;
import com.local.entity.Department;
import com.local.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ImplDepartment implements DepartmentDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int addDepartment(Department department) {
		Session session = sessionFactory.getCurrentSession();
		session.save(department);
		return department.getDepartmentId();
	}

	@Override
	public int editDepartment(Department department) {
		Session session = sessionFactory.getCurrentSession();
		session.update(department);
		return department.getDepartmentId();
	}

	@Override
	public int deleteDepartment(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Department department = (Department) session.load(Department.class, id);
		session.delete(department);
		return department.getDepartmentId();

	}

	@Override
	public Department getDepartmentById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Department department = (Department) session.load(Department.class, id);
		return department;
	}

	@Override
	public List<Department> getAllDepartments() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Department.class).list();
	}

	@Override
	public int addEmployee(Department department, Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		department.getEmployees().add(employee);
		employee.setDepartment(department);
		session.saveOrUpdate(department);
		session.saveOrUpdate(employee);
		return employee.getEmployeeId();
	}

}
