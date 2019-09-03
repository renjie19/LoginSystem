package com.lourence.jonh.section.repository;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.util.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SectionDaoImpl implements SectionDao {
    @Override
    public Section addSection(Section section) throws Exception {
        String insertSql = "INSERT INTO section(sectionName,yearLevel) VALUES(?,?)";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setString(1,section.getSectionName());
        preparedStatement.setString(2,section.getYearLevel());
        MySqlConnector.getInstance().execute(preparedStatement);
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();
        section.setSectionId(resultSet.getInt(1));
        return section;
    }

    @Override
    public void deleteSection(int sectionId) throws Exception {
        String insertSql = "DELETE FROM section WHERE sectionId = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,sectionId);
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public void updateSection(Section section) throws Exception {
        String insertSql = "UPDATE section SET sectionName = ?, yearLevel = ? WHERE sectionId = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setString(1,section.getSectionName());
        preparedStatement.setString(2,section.getYearLevel());
        preparedStatement.setInt(3,section.getSectionId());
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public void deleteAll() throws Exception {
        String insertSql = "DELETE FROM section";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public Section getSectionById(int sectionId) throws Exception {
        String insertSql = "select * from section left join teacherSection t on section.sectionId = t.sectionId " +
                " left join employee e on t.employeeId = e.id  where section.sectionId = ? order by sectionName";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,sectionId);
        ResultSet resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
        if(resultSet.next()){
            return generateSection(resultSet);
        }
        return null;
    }

    @Override
    public List<Section> getAllSections() throws Exception {
        List<Section> sectionList = new ArrayList<Section>();
        String insertSql = "select * from section left join teachersection t on section.sectionId = t.sectionId " +
                "left join employee e on t.employeeId = e.id order by sectionName";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        ResultSet resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
        while(resultSet.next()){
            sectionList.add(generateSection(resultSet));
        }
        return sectionList;
    }

    private Section generateSection(ResultSet resultSet) throws Exception {
        Section section = new Section();
        section.setSectionId(resultSet.getInt("sectionId"));
        section.setSectionName(resultSet.getString("sectionName"));
        section.setYearLevel(resultSet.getString("yearLevel"));
        List<Employee> teacherList = new ArrayList<Employee>();
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setAge(resultSet.getInt("age"));
        employee.setAddress(resultSet.getString("address"));
        employee.setPosition(resultSet.getString("position"));
        teacherList.add(employee);
        while(resultSet.next() && resultSet.getString("sectionName").equals(section.getSectionName())){
            employee = new Employee();
            employee.setEmployeeId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setAge(resultSet.getInt("age"));
            employee.setAddress(resultSet.getString("address"));
            employee.setPosition(resultSet.getString("position"));
            teacherList.add(employee);
        }
        resultSet.previous();
        section.setTeachers(teacherList);
        return section;
    }
}
