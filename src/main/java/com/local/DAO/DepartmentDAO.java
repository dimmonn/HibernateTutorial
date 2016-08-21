package com.local.DAO;

import java.util.List;

import com.local.entity.Department;
import com.local.entity.Employee;

public interface DepartmentDAO {

	public int addDepartment(Department department);

	public int editDepartment(Department department);

	public int deleteDepartment(Integer department);
 
	public Department getDepartmentById(Integer department_id);

	public List<Department> getAllDepartments();

	public int addEmployee(Department department, Employee employee);

}