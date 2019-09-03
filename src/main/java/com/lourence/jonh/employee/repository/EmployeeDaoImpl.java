package com.lourence.jonh.employee.repository;

import com.lourence.jonh.license.repository.License;
import com.lourence.jonh.section.repository.Section;
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
        String insertSql = "select * from employee left join employeeLicense e on employee.id = e.employeeId left join subjects s" +
                " on employee.id = s.employeeId left join teacherSection t on employee.id = t.employeeId left join section s2 on " +
                "t.sectionId = s2.sectionId";
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
        String insertSql = "select * from employee left join employeeLicense e on employee.id = e.employeeId left join subjects s " +
                "on employee.id = s.employeeId left join teacherSection t on employee.id = t.employeeId left join section s2 on " +
                "t.sectionId = s2.sectionId where id = ?";
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
        String insertSql = "select * from employee left join employeeLicense e on employee.id = e.employeeId left join subjects s " +
                "on employee.id = s.employeeId left join teacherSection t on employee.id = t.employeeId left join section s2 on" +
                "t.sectionId = s2.sectionId where id = ?";
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
        employee.setLicense(generateLicense(resultSet));

        List<Subject> subjectList = new ArrayList<Subject>();
        Subject subject = new Subject();
        List<Section> sectionList = new ArrayList<Section>();
        Section section = new Section();

        subject.setSubjectCode(resultSet.getInt("subjectId"));
        subject.setSubject(resultSet.getString("subjectName"));
        subjectList.add(subject);

        section.setSectionId(resultSet.getInt("sectionId"));
        section.setSectionName(resultSet.getString("sectionName"));
        section.setYearLevel(resultSet.getString("yearLevel"));

        while(resultSet.next() && employee.getName().equals(resultSet.getString("name"))) {
           subjectList = generateSubjectList(subjectList,resultSet);
           sectionList = generateSectionList(sectionList,resultSet);
        }
        employee.setSubjects(subjectList);
        employee.setSectionsHandled(sectionList);
        resultSet.previous();
        return employee;
    }
    private License generateLicense(ResultSet resultSet) throws Exception{
        License license = new License();
        license.setLicenseNumber(resultSet.getInt("licenseNumber"));
        license.setExpiryDate(resultSet.getDate("expirationDate"));
        license.setIssueDate(resultSet.getDate("dateIssued"));
        return license;
    }

    private List<Subject> generateSubjectList(List<Subject> subjectList,ResultSet resultSet) throws Exception{
        boolean matched = false;
        Subject subject1 = new Subject();
        subject1.setSubjectCode(resultSet.getInt("subjectId"));
        subject1.setSubject(resultSet.getString("subjectName"));
        for(Subject subject2 : subjectList) {
            if(subject2.getSubject().equals(subject1.getSubject())) {
                matched = true;
            }
        }
        if(!matched) {
            subjectList.add(subject1);
        }
        return subjectList;
    }

    private List<Section> generateSectionList(List<Section> sectionList,ResultSet resultSet) throws Exception{
        boolean hasSection = false;
        Section section1 = new Section();
        section1.setSectionId(resultSet.getInt("sectionId"));
        section1.setSectionName(resultSet.getString("sectionName"));
        section1.setYearLevel(resultSet.getString("yearLevel"));
        for(Section section2 : sectionList) {
            if(section2.getSectionName().equals(section1.getSectionName())) {
                hasSection = true;
            }
        }
        if(!hasSection) {
            sectionList.add(section1);
        }
        return sectionList;
    }
}
