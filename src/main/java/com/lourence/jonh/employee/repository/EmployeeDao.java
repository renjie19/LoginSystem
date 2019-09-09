
package com.lourence.jonh.employee.repository;

import java.util.List;


public interface EmployeeDao {
    Employee addEmployee(Employee emp);
    void deleteEmployee(Employee emp);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int employeeID);
    Employee getEmployeeByName(String name);
    void updateEmployee(Employee emp);
    void deleteAllEmployee();
    
}
