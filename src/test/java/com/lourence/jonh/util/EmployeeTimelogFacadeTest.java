package com.lourence.jonh.util;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.service.EmployeeService;
import com.lourence.jonh.teachinglicense.service.LicenseService;
import com.lourence.jonh.timelog.repository.TimeLog;
import com.lourence.jonh.timelog.service.TimeLogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTimelogFacadeTest {
    @BeforeEach
    void before(){
        LicenseService.getInstance().deleteAll();
        EmployeeService.getInstance().deleteAllEmployee();
        TimeLogService.getInstance().deleteAllLogs();
    }

    @Test
    void log() {
        Employee employee = new Employee();
        employee.setName("Rick and Morty");
        employee.setAge(25);
        employee.setAddress("USA");
        employee.setPosition("Trainer");
        Employee employee1 = EmployeeService.getInstance().addEmployee(employee);

        EmployeeTimelogFacade facade= new EmployeeTimelogFacade();
        TimeLog timelog = facade.log(employee1.getEmployeeId());
        assertEquals(timelog.getId(),employee1.getEmployeeId());
        assertEquals(timelog.getType(),StateEnum.IN);
        TimeLog timelog1 = facade.log(employee1.getEmployeeId());
        assertEquals(timelog1.getType(),StateEnum.OUT);
        facade.log(100);
    }
}