package com.lourence.jonh.controller;

import com.lourence.jonh.model.employeedao.Employee;
import com.lourence.jonh.model.timelogdao.TimeLog;
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
        TimeLog timeLog = new TimeLog();
        timeLog.setId(employee1.getEmployeeId());
        TimeLog timeLog1 = TimeLogController.getInstance().log(timeLog);
        assertEquals(timeLog1.getId(),timeLog.getId());
        assertEquals(timeLog1.getType(), StateEnum.IN);


    }
}