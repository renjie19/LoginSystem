package com.lourence.jonh.subject.service;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubjectServiceTest {
    @BeforeEach
    void before() {
        EmployeeService.getInstance().deleteAllEmployee();
    }

    @Test
    void getSubjectsByEmployee() {
        try{
            Employee employee = new Employee();
            employee.setName("Rosana Rose");
            employee.setAge(26);
            employee.setAddress("Iloilo");
            employee.setPosition("Teacher 1");
            employee = EmployeeService.getInstance().addEmployee(employee);
            SubjectService.getInstance().assignSubject("Math",employee.getEmployeeId());
            SubjectService.getInstance().assignSubject("Science",employee.getEmployeeId());
            SubjectService.getInstance().getSubjectsByEmployee(employee.getEmployeeId());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}