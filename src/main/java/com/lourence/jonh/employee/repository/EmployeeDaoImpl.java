package com.lourence.jonh.employee.repository;

import com.lourence.jonh.util.Hibernate;
import com.lourence.jonh.util.MySqlConnector;

import java.sql.PreparedStatement;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private static EmployeeDaoImpl employeeDao;
    private List<Employee> employeeList;

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
        try{
            Hibernate hibernate = new Hibernate();
            hibernate.persist(employee);
            return getEmployeeByName(employee.getName());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteEmployee(Employee employee)throws Exception{
        String insertSql = "DELETE FROM employee WHERE id = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,employee.getEmployeeId());
        return MySqlConnector.getInstance().executeUpdate(preparedStatement);
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
    public void updateEmployee(Employee employee) throws Exception{
        Hibernate hibernate = new Hibernate();
        hibernate.merge(employee);
    }

    @Override
    public void deleteAllEmployee(){
        String insertSql = "DELETE FROM employee";
        Hibernate hibernate = new Hibernate();
        hibernate.createNativeQuery(insertSql);
    }

    public boolean employeeNameExists(String employeeName) throws Exception{
        if(getEmployeeByName(employeeName)==null) {
            throw new Exception("Employee name does not exist");
        }
        return true;
    }
}
