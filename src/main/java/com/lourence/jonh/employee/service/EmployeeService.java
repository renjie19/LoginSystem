package com.lourence.jonh.employee.service;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.repository.EmployeeDao;
import com.lourence.jonh.employee.repository.EmployeeDaoImpl;

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
        try {
            if (employee.getEmployeeId() != 0) {
                employeeDao.deleteEmployee(employee);
            } else {
                System.out.println("No Match");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateEmployee(Employee employee){
        try {
            employeeDao.updateEmployee(employee);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int viewEmployees(){
        try {
            List<Employee> employeeList = employeeDao.getAllEmployees();
            for(Employee employee: employeeList){
                System.out.println("[ "+employee.getName()+" | "+employee.getAge()+" | "+employee.getAddress()+"" +
                        " | "+employee.getPosition()+" ]");
            }
            return employeeList.size();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public Employee getEmployeeById(int employeeId){
        try {
            if (hasId(employeeId)) {
                return employeeDao.getEmployeeById(employeeId);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new Employee();
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

