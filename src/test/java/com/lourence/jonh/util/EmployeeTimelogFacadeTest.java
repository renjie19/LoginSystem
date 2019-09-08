package com.lourence.jonh.util;

import com.lourence.jonh.timelog.repository.TimeLog;
import org.junit.jupiter.api.Test;

class EmployeeTimelogFacadeTest {

    @Test
    void log() {
//        Employee employee = new Employee();
//        employee.setName("Rick and Morty");
//        employee.setAge(25);
//        employee.setAddress("USA");
//        employee.setPosition("Trainer");
//        Employee employee1 = EmployeeService.getInstance().addEmployee(employee);

        EmployeeTimelogFacade facade= new EmployeeTimelogFacade();
        TimeLog timelog = facade.log(7);
    }
}