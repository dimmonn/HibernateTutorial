package com.local.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.local.DAO.DepartmentDAO;
import com.local.logic.Department;
import com.local.logic.Employee;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentManagerImpl {

    private DepartmentDAO departmentDAO;

    public List<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    @Autowired
    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public void addDepartment(Department department) {
        departmentDAO.addDepartment(department);

    }

    public void editDepartment(Department department) {
        departmentDAO.editDepartment(department);
    }

    public void deleteDepartment(Integer department) {
        departmentDAO.deleteDepartment(department);
    }

    public Department getDepartmentById(Integer department_id) {
        return departmentDAO.getDepartmentById(department_id);
    }

    public void addEmployee(Department department, Employee employee) {
        departmentDAO.addEmployee(department, employee);
    }

}
