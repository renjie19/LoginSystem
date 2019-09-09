package com.lourence.jonh.employee.service;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.repository.EmployeeDao;
import com.lourence.jonh.employee.repository.EmployeeDaoImpl;
import com.lourence.jonh.util.Hibernate;

import java.util.List;

public class EmployeeService {
    private static EmployeeService employeeService;
    private EmployeeDao employeeDao;

    private EmployeeService(){
        employeeDao = EmployeeDaoImpl.getInstance();
    }

    public static EmployeeService getInstance(){
        if(employeeService ==null){
            employeeService = new EmployeeService();
        }
        return employeeService;
    }

    public Employee addEmployee(Employee employee){
        try {
            hasEmployeeName(employee.getName());
            employee = employeeDao.addEmployee(employee);
            if(employee.getEmployeeId() != 0){
                System.out.println("Added Successfully\nEmployee Id: "+employee.getEmployeeId());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return employee;
    }

    public void deleteEmployee(Employee employee){
        employeeDao.deleteEmployee(employee);
    }

    public void updateEmployee(Employee employee){
        employeeDao.updateEmployee(employee);
    }

    public void viewEmployees(){
        List<Employee> employeeList = employeeDao.getAllEmployees();
        for(Employee employee: employeeList){
            System.out.println("[ "+employee.getName()+" | "+employee.getAge()+" | "+employee.getAddress()+"" +
                    " | "+employee.getPosition()+" ]");
        }
    }

    public Employee getEmployeeById(int employeeId){
        Hibernate hibernate = new Hibernate();
        return (Employee)hibernate.find(Employee.class,employeeId);
    }

    public boolean hasId(int id)throws Exception{
        if(employeeDao.getEmployeeById(id)!=null){
           return true;
        }
        throw new Exception("Id does not Exist");
    }

    private void hasEmployeeName(String employeeName) throws Exception {
        Employee employee = employeeDao.getEmployeeByName(employeeName);
        if(employee != null) {
            throw new Exception("Employee Already Exists");
        }
    }

    public void deleteAllEmployee() {
        employeeDao.deleteAllEmployee();
    }
}

