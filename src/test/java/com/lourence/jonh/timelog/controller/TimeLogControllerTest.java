package com.lourence.jonh.timelog.controller;

import com.lourence.jonh.employee.controller.EmployeeController;
import com.lourence.jonh.employee.dao.Employee;
import com.lourence.jonh.timelog.dao.TimeLog;
import com.lourence.jonh.util.StateEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeLogControllerTest {
    @BeforeEach
    void before(){
        TimeLogController.getInstance().deleteAllLogs();
        EmployeeController.getInstance().deleteAllEmployee();
    }
    @Test
    void log() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        Employee employee1 = EmployeeController.getInstance().addEmployee(employee);
        TimeLog timeLogIn = TimeLogController.getInstance().log(employee1.getEmployeeId());
        assertEquals(timeLogIn.getType(), StateEnum.IN);
        TimeLog timeLogOut = TimeLogController.getInstance().log(employee1.getEmployeeId());
        assertEquals(timeLogOut.getType(),StateEnum.OUT);
    }
}