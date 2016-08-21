package com.local.implement;

import com.local.DAO.EmployeeDAO;
import com.local.entity.Department;
import com.local.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ImplEmployee implements EmployeeDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int editEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.update(employee);
		return employee.getEmployeeId();

	}

	@Override
	public List<Integer> deleteEmployeesByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> employees = session.createCriteria(Employee.class).add(Restrictions.like("fio", name)).list();
		List<Integer> removed = new ArrayList<>();
		employees.stream().filter(e -> e.getFio().equals(name)).forEach(e -> {
			Department dept = (Department) session.load(Department.class, e.getDepartment().getDepartmentId());
			dept.getEmployees().remove(e);
			session.delete(session.load(Employee.class, e.getEmployeeId()));
			removed.add(e.getEmployeeId());
		});
		return removed;
	}

	@Override
	public Set<Employee> getEmployeesByDepartment(Integer department) {
		Set<Employee> employees = new HashSet<>();
		Session session = sessionFactory.getCurrentSession();
		List<Department> departments = session.createCriteria(Department.class).add(Restrictions.idEq(department))
				.list();
		departments.forEach(d -> employees.addAll(d.getEmployees()));
		return employees;
	}

}