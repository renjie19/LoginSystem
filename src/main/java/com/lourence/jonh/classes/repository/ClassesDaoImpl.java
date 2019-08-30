package com.lourence.jonh.classes.repository;

import com.lourence.jonh.util.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClassesDaoImpl implements ClassesDao {
    @Override
    public Classes addClassHandled(int employeeId, int sectionId) throws Exception {
        Classes classes = new Classes();
        classes.setEmployeeId(employeeId);
        classes.setSectionId(sectionId);
        String insertSql = "INSERT INTO teacherSection(employeeId,sectionId)VALUES(?,?)";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,employeeId);
        preparedStatement.setInt(2,sectionId);
        MySqlConnector.getInstance().execute(preparedStatement);
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();
        classes.setClassId(resultSet.getInt(1));
        return classes;
    }

    @Override
    public void deleteClassHandled(int classId) throws Exception {
        String insertSql = "DELETE FROM teacherSection WHERE classId = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,classId);
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public Classes updateClassHandled(Classes classes) throws Exception {
        String insertSql = "UPDATE teacherSection SET employeeId = ?, sectionId = ? WHERE classId = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1, classes.getEmployeeId());
        preparedStatement.setInt(2, classes.getSectionId());
        preparedStatement.setInt(3, classes.getClassId());
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
        return getClass(classes.getEmployeeId(),classes.getSectionId());
    }

    @Override
    public List<Classes> getClassesByEmployeeId(int employeeId) throws Exception {
        List<Classes> classes = new ArrayList<Classes>();
        String insertSql = "select classId,name,sectionName from employee inner join teacherSection on " +
                "employee.Id = teacherSection.employeeId inner join section " +
                "on teacherSection.sectionId = section.sectionId WHERE id = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,employeeId);
        ResultSet resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
        while(resultSet.next()){
            Classes teacherSection = new Classes();
            teacherSection.setClassId(resultSet.getInt("classId"));
            teacherSection.setTeacher(resultSet.getString("name"));
            teacherSection.setSection(resultSet.getString("sectionName"));
            classes.add(teacherSection);
        }
        return classes;
    }

    @Override
    public Classes getClass(int employeeId, int sectionId) throws Exception {
        String insertSql = "SELECT * FROM teacherSection WHERE employeeId = ? AND sectionId = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,employeeId);
        preparedStatement.setInt(2,sectionId);
        ResultSet resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
        if(resultSet.next()) {
            return generateClasses(resultSet);
        }
        return null;
    }

    private Classes generateClasses(ResultSet resultSet) throws Exception{
        Classes classes = new Classes();
        classes.setClassId(resultSet.getInt("classId"));
        classes.setEmployeeId(resultSet.getInt("employeeId"));
        classes.setSectionId(resultSet.getInt("sectionId"));
        return classes;
    }
}
