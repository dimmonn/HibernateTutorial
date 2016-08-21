package com.local.DAO;

import com.local.logic.Department;
import com.local.logic.Employee;
import java.util.List;

public interface DepartmentDAO {

	public void addDepartment(Department department);

	public void editDepartment(Department department);

	public void deleteDepartment(Integer department);
 
	public Department getDepartmentById(Integer department_id);

	public List<Department> getAllDepartments();

	public void addEmployee(Department department, Employee employee);

}