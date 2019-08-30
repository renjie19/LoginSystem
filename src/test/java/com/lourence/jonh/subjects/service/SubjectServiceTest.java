package com.lourence.jonh.subjects.service;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.service.EmployeeService;
import com.lourence.jonh.subjects.repository.Subject;
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

            Subject subject = new Subject();
            subject.setSubjectCode(101);
            subject.setSubject("Math");
            subject.setEmployeeId(employee.getEmployeeId());
            Subject subject1 = new Subject();
            subject1.setSubjectCode(102);
            subject1.setSubject("Science");
            subject1.setEmployeeId(employee.getEmployeeId());

            SubjectService.getInstance().assignSubject(subject);
            SubjectService.getInstance().assignSubject(subject1);
            SubjectService.getInstance().getSubjectsByEmployee(employee.getEmployeeId());
        }catch (Exception e) {

        }

    }

    @Test
    void getAllSubjects() {

    }
}