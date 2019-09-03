package com.lourence.jonh.classrecord.service;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.service.EmployeeService;
import com.lourence.jonh.section.service.SectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassRecordServiceTest {
    @BeforeEach
    void before() {
        EmployeeService.getInstance().deleteAllEmployee();
        SectionService.getInstance().deleteAll();
    }

    Employee createEmployee() {
        Employee employee = new Employee();
        employee.setName("George");
        employee.setAge(30);
        employee.setAddress("Cebu");
        employee.setPosition("Teacher III");
        employee = EmployeeService.getInstance().addEmployee(employee);
        return employee;
    }


    @Test
    void viewClassRecordsByEmployee() {
    }
}