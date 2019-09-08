
package com.lourence.jonh.employee.repository;

import java.util.List;


public interface EmployeeDao {
    Employee addEmployee(Employee emp);
    int deleteEmployee(Employee emp)throws Exception;
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int employeeID);
    Employee getEmployeeByName(String name);
    void updateEmployee(Employee emp)throws Exception;
    void deleteAllEmployee();
    
}
