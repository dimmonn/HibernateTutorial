package com.local.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.local.DAO.DepartmentDAO;
import com.local.entity.Department;
import com.local.entity.Employee;

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

    public int addDepartment(Department department) {
        return departmentDAO.addDepartment(department);

    }

    public int editDepartment(Department department) {
        return departmentDAO.editDepartment(department);
    }

    public int deleteDepartment(Integer department) {
        return departmentDAO.deleteDepartment(department);
    }

    public Department getDepartmentById(Integer department_id) {
        return departmentDAO.getDepartmentById(department_id);
    }

    public int addEmployee(Department department, Employee employee) {
        return departmentDAO.addEmployee(department, employee);
    }

}
