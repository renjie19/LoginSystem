package com.lourence.jonh;

import com.lourence.jonh.controller.EmployeeController;
import com.lourence.jonh.controller.ReportController;
import com.lourence.jonh.controller.TimeLogController;
import com.lourence.jonh.model.employeedao.Employee;


public class Logintest {
    public static void main(String[] args) {
        EmployeeController employeeController = EmployeeController.getInstance();
        TimeLogController timelogController = TimeLogController.getInstance();
        ReportController reportController = ReportController.getInstance();

        Employee employee = new Employee();
        employee.setName("General Bato");
        employee.setAge(30);
        employee.setAddress("Mindanao");
        employee.setPosition("Head Chief");
        //employeeController.addEmployee(employee);

        employeeController.getEmployeeById(90);





    }
}
