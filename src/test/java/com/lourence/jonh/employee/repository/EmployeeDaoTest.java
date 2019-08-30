package com.lourence.jonh.employee.repository;

import com.lourence.jonh.employee.service.EmployeeService;
import com.lourence.jonh.timelog.service.TimeLogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeDaoTest {
    @BeforeEach
    void before(){
        EmployeeService.getInstance().deleteAllEmployee();
        TimeLogService.getInstance().deleteAllLogs();
    }

    @Test
    void addEmployee() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee savedEmployee = new Employee();
        try {
            savedEmployee = employeeDao.getEmployeeById(employeeDao.addEmployee(employee));
        }catch(Exception e){
            e.printStackTrace();
        }
        assertEquals(employee.getName(),savedEmployee.getName());
        assertEquals(employee.getAge(), savedEmployee.getAge());
        assertEquals(employee.getAddress(),savedEmployee.getAddress());
        assertEquals(employee.getPosition(),savedEmployee.getPosition());
    }

    @Test
    void deleteEmployee() {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        Employee savedEmployee = new Employee();
        try {
            savedEmployee = employeeDao.getEmployeeById(employeeDao.addEmployee(employee));
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            employeeList = employeeDao.getAllEmployees();
            assertEquals(employeeList.size(),1);

            employeeDao.deleteEmployee(savedEmployee);
            employeeList = employeeDao.getAllEmployees();
            assertEquals(0,employeeList.size());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void updateEmployee() {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        Employee savedEmployee = new Employee();
        try {
            savedEmployee = employeeDao.getEmployeeById(employeeDao.addEmployee(employee));
        }catch(Exception e){
            e.printStackTrace();
        }
        savedEmployee.setName("Rodrigo Roa Duterte");
        Employee updatedEmployee = new Employee();
        try {
            employeeDao.updateEmployee(savedEmployee);
            savedEmployee = employeeDao.getEmployeeById(employee.getEmployeeId());
            updatedEmployee = employeeDao.getEmployeeById(savedEmployee.getEmployeeId());
        }catch(Exception e){
            e.printStackTrace();
        }
        assertEquals(savedEmployee.getEmployeeId(),updatedEmployee.getEmployeeId());
        assertEquals(savedEmployee.getName(),updatedEmployee.getName());
        assertEquals(savedEmployee.getAge(),updatedEmployee.getAge());
        assertEquals(savedEmployee.getAddress(),updatedEmployee.getAddress());
        assertEquals(savedEmployee.getPosition(),updatedEmployee.getPosition());
    }
}