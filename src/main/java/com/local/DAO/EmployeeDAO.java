package com.local.DAO;

import com.local.logic.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeDAO {

	public int editEmployee(Employee employee);
	public List<Integer> deleteEmployeesByName(String name);
	public Set<Employee> getEmployeesByDepartment(Integer department);
}