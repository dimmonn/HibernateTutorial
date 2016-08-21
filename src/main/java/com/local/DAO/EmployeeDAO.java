package com.local.DAO;

import java.util.List;
import java.util.Set;

import com.local.entity.Employee;

public interface EmployeeDAO {

	public int editEmployee(Employee employee);
	public List<Integer> deleteEmployeesByName(String name);
	public Set<Employee> getEmployeesByDepartment(Integer department);
}