package com.lourence.jonh.controller;

import com.lourence.jonh.model.employeedao.Employee;
import com.lourence.jonh.model.timelogdao.TimeLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportControllerTest {
    @BeforeEach
    void before(){
        EmployeeController.getInstance().deleteAllEmployee();
        TimeLogController.getInstance().deleteAllLogs();
    }
    @Test
    void viewEmployeeReportPerDate() {
        Employee employee = new Employee();
        employee.setName("Spiderman");
        employee.setAge(18);
        employee.setAddress("America");
        employee.setPosition("Trainee");
        Employee employeeResult = EmployeeController.getInstance().addEmployee(employee);

        TimeLog timeLog = new TimeLog();
        timeLog.setId(employeeResult.getEmployeeId());
        TimeLogController.getInstance().log(timeLog);
        TimeLogController.getInstance().log(timeLog);

        String startDate = "2019-08-19";
        String endDate = "2019-08-23";
        int employeeId = employeeResult.getEmployeeId();
        ReportController.getInstance().viewEmployeeReportPerDate(employeeId,startDate,endDate);
    }
}