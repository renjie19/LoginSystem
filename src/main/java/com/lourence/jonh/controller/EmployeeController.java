package com.lourence.jonh.controller;

import com.lourence.jonh.model.employeedao.Employee;
import com.lourence.jonh.model.employeedao.EmployeeDaoImp;
import com.lourence.jonh.view.EmployeeView;

import java.util.List;

public class EmployeeController {
    
    private Employee employee;
    private EmployeeView employeeView = new EmployeeView();
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
            checkIfEmployeeNameExist(employee.getName());
            int rowsAffected = EmployeeDaoImp.getInstance().addEmployee(employee);
            if(rowsAffected != 0){
                System.out.println("Successful");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void removeEmployee(Employee employee){
        try {
            if (employee.getEmployeeId() != 0) {
                EmployeeDaoImp.getInstance().deleteEmployee(employee);
            } else {
                System.out.println("No Match");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void updateEmployee(Employee employee){
        try {
            EmployeeDaoImp.getInstance().updateEmployee(employee);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void viewEmployees(){
        try {
            List<Employee> employeeList = EmployeeDaoImp.getInstance().getAllEmployees();
            for(Employee employee: employeeList){
                employeeView.printEmployees(employee.getName(),employee.getAge(),employee.getAddress(),employee.getPosition());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Employee getEmployeeByID(int employeeId){
        try {
            if (checkIfIdExists(employeeId)) {
                return EmployeeDaoImp.getInstance().getEmployeeByID(employeeId);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new Employee();
    }
    
    private boolean checkIfIdExists(int id)throws Exception{
        return EmployeeDaoImp.getInstance().getEmployeeByID(id).getEmployeeId() == id;
    }
    
    private void checkIfEmployeeNameExist(String employeeName) throws Exception{
        employee = EmployeeDaoImp.getInstance().getEmployeeByName(employeeName);
        if ((employee.getName() != null) && (employee.getName().equals(employeeName))) {
            throw new Exception("Employee Already Exist");
        }
    }
    
}

