package com.lourence.jonh.employee.repository;

import com.lourence.jonh.license.repository.License;
import com.lourence.jonh.subject.repository.Subject;
import com.lourence.jonh.util.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public Employee addEmployee(Employee employee)throws Exception {
        String insertSql = "INSERT INTO employee(name,age,address,position)VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setInt(2,employee.getAge());
        preparedStatement.setString(3,employee.getAddress());
        preparedStatement.setString(4,employee.getPosition());
        MySqlConnector.getInstance().execute(preparedStatement);
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();
        employee.setEmployeeId(resultSet.getInt(1));
        MySqlConnector.getInstance().closeConnection();
        return employee;
    }

    @Override
    public int deleteEmployee(Employee employee)throws Exception{
        String insertSql = "DELETE FROM employee WHERE id = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,employee.getEmployeeId());
        return MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public List<Employee> getAllEmployees() throws Exception{
        List<Employee> employeeList = new ArrayList<Employee>();
        String insertSql = "select employee.*,licenseNumber,subjectName from employee join employeelicense e on" +
                " employee.id = e.employeeId join subjects s on employee.id = s.employeeId";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        try {
            ResultSet resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
            while (resultSet.next()) {
                 Employee employee = generateEmployee(resultSet);
                employeeList.add(employee);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            MySqlConnector.getInstance().closeConnection();
        }
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int employeeId)throws Exception{
        Employee employee = new Employee();
        String insertSql = "select employee.*,licenseNumber,subjectName from employee join employeelicense e on " +
                "employee.id = e.employeeId join subjects s on employee.id = s.employeeId where id = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,employeeId);
        try {
            ResultSet resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
            if (resultSet.next()) {
                employee = generateEmployee(resultSet);
            }else{
                employee = new Employee();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            MySqlConnector.getInstance().closeConnection();
        }
        return employee;
    }

    @Override
    public Employee getEmployeeByName(String name)throws Exception{
        String insertSql = "select employee.*,licenseNumber,subjectName from employee join employeelicense e on " +
                "employee.id = e.employeeId join subjects s on employee.id = s.employeeId where name = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setString(1,name);
        Employee employee = new Employee();
        try {
            ResultSet resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
            if (resultSet.next()) {
                employee = generateEmployee(resultSet);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            MySqlConnector.getInstance().closeConnection();
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) throws Exception{
        String insertSql = "UPDATE employee SET name = ?, age = ?, address = ?,position = ? WHERE id = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setInt(2,employee.getAge());
        preparedStatement.setString(3,employee.getAddress());
        preparedStatement.setString(4,employee.getPosition());
        preparedStatement.setInt(5,employee.getEmployeeId());
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public void deleteAllEmployee(){
        try {
            String insertSql = "DELETE FROM employee";
            PreparedStatement prepareStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
            MySqlConnector.getInstance().executeUpdate(prepareStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private Employee generateEmployee(ResultSet resultSet)throws Exception{
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setAge(resultSet.getInt("age"));
        employee.setAddress(resultSet.getString("address"));
        employee.setPosition(resultSet.getString("position"));
        License license = new License();
        license.setLicenseNumber(resultSet.getInt("licenseNumber"));
        employee.setLicense(license);
        List<Subject> subjectList = new ArrayList<Subject>();
        Subject subject = new Subject();
        subject.setSubject(resultSet.getString("subjectName"));
        subjectList.add(subject);
        while(resultSet.next() && employee.getName().equals(resultSet.getString("name"))) {
            Subject subject1 = new Subject();
            subject1.setSubject(resultSet.getString("subjectName"));
            subjectList.add(subject1);
        }
        employee.setSubjects(subjectList);
        resultSet.previous();
        return employee;
    }
}
