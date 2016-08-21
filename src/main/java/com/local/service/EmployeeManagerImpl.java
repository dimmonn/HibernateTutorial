package com.local.service;

import java.util.List;
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

    public int editEmployee(Employee employee) {
        return employeeDAO.editEmployee(employee);

    }

    public List<Integer> deleteEmployeesByName(String name) {
        return employeeDAO.deleteEmployeesByName(name);
    }

    public Set<Employee> getEmployeesByDepartment(Integer department) {
        return employeeDAO.getEmployeesByDepartment(department);
    }

}