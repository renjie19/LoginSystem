package com.lourence.jonh.controller;

import com.lourence.jonh.model.employeedao.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EmployeeControllerTest {


    @BeforeEach
    void before(){
        EmployeeController.getInstance().deleteAllEmployee();
    }

    @Test
    void addEmployee() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");

        Employee savedEmployee = EmployeeController.getInstance().addEmployee(employee);
        System.out.println(savedEmployee.getEmployeeId());
        assertEquals(employee.getName(), savedEmployee.getName());
        assertEquals(employee.getAge (), savedEmployee.getAge());
        assertEquals(employee.getAddress(), savedEmployee.getAddress());
        assertEquals(employee.getPosition(), savedEmployee.getPosition());
    }

    @Test
    void deleteEmployee() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        Employee employee1 = EmployeeController.getInstance().addEmployee(employee);
        int numberOfEmployees = EmployeeController.getInstance().viewEmployees();
        EmployeeController.getInstance().deleteEmployee(employee1);
        int numberafterDelete = EmployeeController.getInstance().viewEmployees();
        assertEquals(numberOfEmployees-1,numberafterDelete);
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        Employee employee1 = EmployeeController.getInstance().addEmployee(employee);
        employee1.setName("Name Changed");
        EmployeeController.getInstance().updateEmployee(employee1);
        assertEquals(employee1.getName(),"Name Changed");
        assertEquals(employee1.getAge(),employee.getAge());
        assertEquals(employee1.getAddress(),employee.getAddress());
        assertEquals(employee1.getPosition(),employee.getPosition());
    }

    @Test
    void viewEmployees() {
    }

    @Test
    void getEmployeeById() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        Employee employee1 = EmployeeController.getInstance().addEmployee(employee);
        Employee nonExistingEmployee = EmployeeController.getInstance().getEmployeeById(1);
        Employee existingEmployee = EmployeeController.getInstance().getEmployeeById(employee1.getEmployeeId());
        assertNotEquals(nonExistingEmployee.getEmployeeId(),1);
        assertEquals(existingEmployee.getEmployeeId(),employee1.getEmployeeId());
    }
}