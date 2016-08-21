package com.local.DAO;

import com.local.logic.Employee;
import java.util.Set;

public interface EmployeeDAO {

	public void editEmployee(Employee employee);
	public void deleteEmployeesByName(String name);
	public Set<Employee> getEmployeesByDepartment(Integer department);
}