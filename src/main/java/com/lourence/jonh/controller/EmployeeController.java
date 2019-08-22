package com.lourence.jonh.controller;

import com.lourence.jonh.model.employeedao.Employee;
import com.lourence.jonh.model.employeedao.EmployeeDaoImpl;
import com.lourence.jonh.view.EmployeeView;

import java.util.List;

public class EmployeeController {
    
    private Employee employee;
    private static EmployeeController employeeController;

    private EmployeeController(){
        
    }
    
    public static EmployeeController getInstance(){
        if(employeeController==null){
            employeeController = new EmployeeController();
        }
        return employeeController;
    }
    
    public void addEmployee(Employee employee){
        try {
            hasEmployeeName(employee.getName());
            int rowsAffected = EmployeeDaoImpl.getInstance().addEmployee(employee);
            employee = EmployeeDaoImpl.getInstance().getEmployeeByName(employee.getName());
            if(rowsAffected != 0){
                System.out.println("Added Successfully\nEmployee Id: "+employee.getEmployeeId());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteEmployee(Employee employee){
        try {
            if (employee.getEmployeeId() != 0) {
                EmployeeDaoImpl.getInstance().deleteEmployee(employee);
            } else {
                System.out.println("No Match");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void updateEmployee(Employee employee){
        try {
            EmployeeDaoImpl.getInstance().updateEmployee(employee);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void viewEmployees(){
        try {
            List<Employee> employeeList = EmployeeDaoImpl.getInstance().getAllEmployees();
            EmployeeView employeeView = new EmployeeView();
            for(Employee employee: employeeList){
                employeeView.printEmployees(employee.getName(),employee.getAge(),employee.getAddress(),employee.getPosition());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Employee getEmployeeById(int employeeId){
        try {
            if (hasId(employeeId)) {
                return EmployeeDaoImpl.getInstance().getEmployeeById(employeeId);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new Employee();
    }
    
    private boolean hasId(int id)throws Exception{
        return EmployeeDaoImpl.getInstance().getEmployeeById(id).getEmployeeId() == id;
    }
    
    private void hasEmployeeName(String employeeName) throws Exception{
        employee = EmployeeDaoImpl.getInstance().getEmployeeByName(employeeName);
        if ((employee.getName() != null) && (employee.getName().equals(employeeName))) {
            throw new Exception("Employee Already Exist");
        }
    }
    
}

