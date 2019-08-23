package com.lourence.jonh.util;

import com.lourence.jonh.controller.EmployeeController;
import com.lourence.jonh.controller.TimeLogController;
import com.lourence.jonh.model.employeedao.Employee;
import com.lourence.jonh.model.timelogdao.TimeLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTimelogFacadeTest {
    @BeforeEach
    void before(){
        EmployeeController.getInstance().deleteAllEmployee();
        TimeLogController.getInstance().deleteAllLogs();
    }

    @Test
    void log() {
        Employee employee = new Employee();
        employee.setName("Rick and Morty");
        employee.setAge(25);
        employee.setAddress("USA");
        employee.setPosition("Trainer");
        Employee employee1 = EmployeeController.getInstance().addEmployee(employee);

        EmployeeTimelogFacade facade= new EmployeeTimelogFacade();
        TimeLog timelog = facade.log(employee1.getEmployeeId());
        assertEquals(timelog.getId(),employee1.getEmployeeId());
        assertEquals(timelog.getType(),StateEnum.IN);
        TimeLog timelog1 = facade.log(employee1.getEmployeeId());
        assertEquals(timelog1.getType(),StateEnum.OUT);
        facade.log(100);
    }
}