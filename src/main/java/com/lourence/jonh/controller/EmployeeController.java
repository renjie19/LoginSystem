package com.lourence.jonh.controller;

import com.lourence.jonh.model.employeedao.Employee;
import com.lourence.jonh.model.employeedao.EmployeeDao;
import com.lourence.jonh.model.employeedao.EmployeeDaoImpl;
import com.lourence.jonh.view.EmployeeView;

import java.util.List;

public class EmployeeController {
    private static EmployeeController employeeController;
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    private EmployeeController(){

    }

    public static EmployeeController getInstance(){
        if(employeeController==null){
            employeeController = new EmployeeController();
        }
        return employeeController;
    }

    public Employee addEmployee(Employee employee){
        try {
            hasEmployeeName(employee.getName());
            employee.setEmployeeId(employeeDao.addEmployee(employee));
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
            EmployeeView employeeView = new EmployeeView();
            for(Employee employee: employeeList){
                employeeView.printEmployees(employee.getName(),employee.getAge(),employee.getAddress(),employee.getPosition());
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
        if(employeeDao.getEmployeeById(id).getEmployeeId() == id){
            return true;
        }else{
            throw new Exception("Id Does Not Exist");
        }
    }

    private void hasEmployeeName(String employeeName) throws Exception {
        Employee employee = employeeDao.getEmployeeByName(employeeName);
        if ((employee.getName() != null) && (employee.getName().equals(employeeName))) {
            throw new Exception("Employee Already Exist");
        }
    }

    public void deleteAllEmployee() {
        employeeDao.deleteAllEmployee();
    }
}

