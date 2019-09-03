package com.lourence.jonh.report.service;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.service.EmployeeService;
import com.lourence.jonh.timelog.service.TimeLogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportServiceTest {
    @BeforeEach
    void before(){
        EmployeeService.getInstance().deleteAllEmployee();
        TimeLogService.getInstance().deleteAllLogs();
    }
    @Test
    void viewEmployeeReportPerDate() {
        Employee employee = new Employee();
        employee.setName("Spiderman");
        employee.setAge(18);
        employee.setAddress("America");
        employee.setPosition("Trainee");
        Employee employeeResult = EmployeeService.getInstance().addEmployee(employee);


        TimeLogService.getInstance().log(employeeResult.getEmployeeId());
        TimeLogService.getInstance().log(employeeResult.getEmployeeId());

        String startDate = "2019-08-19";
        String endDate = "2019-09-28";
        int employeeId = employeeResult.getEmployeeId();
        ReportService.getInstance().viewEmployeeReportPerDate(employeeId,startDate,endDate);
    }
}