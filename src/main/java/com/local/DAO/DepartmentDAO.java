package com.local.DAO;

import com.local.logic.Department;
import com.local.logic.Employee;
import java.util.List;

public interface DepartmentDAO {

	public int addDepartment(Department department);

	public int editDepartment(Department department);

	public int deleteDepartment(Integer department);
 
	public Department getDepartmentById(Integer department_id);

	public List<Department> getAllDepartments();

	public int addEmployee(Department department, Employee employee);

}