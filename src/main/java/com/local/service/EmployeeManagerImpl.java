package com.local.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.local.DAO.EmployeeDAO;
import com.local.logic.Employee;

@Service
@Transactional
public class EmployeeManagerImpl {

    private EmployeeDAO employeeDAO;

    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void editEmployee(Employee employee) {
        employeeDAO.editEmployee(employee);

    }

    public void deleteEmployeesByName(String name) {
        employeeDAO.deleteEmployeesByName(name);
    }

    public Set<Employee> getEmployeesByDepartment(Integer department) {
        return employeeDAO.getEmployeesByDepartment(department);
    }

}