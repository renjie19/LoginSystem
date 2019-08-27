package com.lourence.jonh.model.employeedao;

import com.lourence.jonh.controller.EmployeeController;
import com.lourence.jonh.controller.TimeLogController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeDaoTest {
    @BeforeEach
    void before(){
        EmployeeController.getInstance().deleteAllEmployee();
        TimeLogController.getInstance().deleteAllLogs();
    }
    @Test
    void createEmployee() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee emp = new Employee();
        try {
            emp = employeeDao.createEmployee(employee);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(emp.getEmployeeId());
    }

    @Test
    void addEmployee() {
    }

    @Test
    void deleteEmployee() {
    }

    @Test
    void getAllEmployees() {
    }

    @Test
    void getEmployeeById() {
    }

    @Test
    void getEmployeeByName() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteAllEmployee() {
    }
}