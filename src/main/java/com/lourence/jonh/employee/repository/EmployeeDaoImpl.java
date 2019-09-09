package com.lourence.jonh.employee.repository;

import com.lourence.jonh.util.Hibernate;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private static EmployeeDaoImpl employeeDao;

    private EmployeeDaoImpl() {
    }

    public static EmployeeDaoImpl getInstance() {
        if(employeeDao==null) {
            employeeDao = new EmployeeDaoImpl();
        }
        return employeeDao;
    }

    @Override
    public Employee addEmployee(Employee employee){
        Hibernate hibernate = new Hibernate();
        hibernate.persist(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Hibernate hibernate = new Hibernate();
        hibernate.remove(Employee.class,employee.getEmployeeId());
    }

    @Override
    public List<Employee> getAllEmployees() {
        String insertSql = "Select e from Employee e";
        Hibernate hibernate = new Hibernate();
        return hibernate.createNamedQuery(insertSql);
    }

    @Override
    public Employee getEmployeeById(int employeeId){
        Hibernate hibernate = new Hibernate();
        return (Employee)hibernate.find(Employee.class,employeeId);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        String insertSql = "from Employee e where e.name = '"+name+"'";
        Hibernate hibernate = new Hibernate();
        return (Employee)hibernate.getObjectNamedQuery(insertSql);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Hibernate hibernate = new Hibernate();
        hibernate.merge(employee);
    }

    @Override
    public void deleteAllEmployee(){
        String insertSql = "DELETE FROM employee";
        Hibernate hibernate = new Hibernate();
        hibernate.createNativeQuery(insertSql);
    }
}
