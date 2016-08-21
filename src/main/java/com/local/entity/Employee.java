package com.local.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.local.entity.Department;

@Entity
@Table(name = "employee")
public class Employee {

    private int employeeId;
    private String fio;

    private Department department;

    public Employee() {
    }

    public Employee(String fio) {
        this.fio = fio;
    }

    @Id
    @GeneratedValue
    @Column(name = "employee_id", unique = true, nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @ManyToOne
    @JoinColumn(name = "fk_department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return this.employeeId + " " + this.fio;
    }
}