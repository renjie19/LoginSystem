package com.lourence.jonh.timelog.service;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.service.EmployeeService;
import com.lourence.jonh.timelog.repository.TimeLog;
import com.lourence.jonh.util.StateEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeLogServiceTest {
    @BeforeEach
    void before(){
        TimeLogService.getInstance().deleteAllLogs();
        EmployeeService.getInstance().deleteAllEmployee();
    }
    @Test
    void log() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        Employee employee1 = EmployeeService.getInstance().addEmployee(employee);
        TimeLog timeLogIn = TimeLogService.getInstance().log(employee1.getEmployeeId());
        assertEquals(timeLogIn.getType(), StateEnum.IN);
        TimeLog timeLogOut = TimeLogService.getInstance().log(employee1.getEmployeeId());
        assertEquals(timeLogOut.getType(),StateEnum.OUT);
    }
}