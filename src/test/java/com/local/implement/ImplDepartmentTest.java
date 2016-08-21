package com.local.implement;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import com.local.logic.Department;
import com.local.service.DepartmentManagerImpl;

import util.AppContextHolder;

public class ImplDepartmentTest {

    @Test
    public void testAddDepartment() {
        int c = 0;
        DepartmentManagerImpl dept = AppContextHolder.getBean("departmentManagerImpl");
        int current = dept.getAllDepartments().size();
        System.out.println(current);
        for (int i = 0; i < 1000; i++) {
            Department department = new Department();
            int random = 50 + new Random().nextInt(1000);
            department.setCaption("dept" + String.valueOf(random));
            dept.addDepartment(department);
            c = i;
            System.out.println(i);
        }
        assertEquals(c + current, dept.getAllDepartments().size() - 1);
    }

    @Test
    public void testEditDepartment() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteDepartment() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetDepartmentById() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetAllDepartments() {
        fail("Not yet implemented");
    }

    @Test
    public void testAddEmployee() {
        fail("Not yet implemented");
    }

}
