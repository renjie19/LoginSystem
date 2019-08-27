
package com.lourence.jonh.model.employeedao;

import java.util.List;


public interface EmployeeDao {
    Employee createEmployee(Employee emp) throws Exception;
    int addEmployee(Employee emp) throws Exception;
    int deleteEmployee(Employee emp)throws Exception;
    List<Employee> getAllEmployees()throws Exception;
    Employee getEmployeeById(int employeeID)throws Exception;
    Employee getEmployeeByName(String name)throws Exception;
    void updateEmployee(Employee emp)throws Exception;
    void deleteAllEmployee();
    
}
