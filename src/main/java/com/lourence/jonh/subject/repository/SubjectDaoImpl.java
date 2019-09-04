package com.lourence.jonh.subject.repository;

import com.lourence.jonh.util.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl implements SubjectDao {
    @Override
    public void assignSubject(String subjectName,int employeeId) throws Exception {
        String insertSql = "INSERT INTO subject(subjectName,employeeId)VALUES(?,?)";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setString(1,subjectName);
        preparedStatement.setInt(2,employeeId);
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public void deleteSubjectAssignment(String subjectName) throws Exception {
        String insertSql = "DELETE FROM subject WHERE subjectName = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setString(1,subjectName);
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public void deleteAll() throws Exception {
        String insertSql = "DELETE FROM subject";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public void updateSubjectAssignment(Subject subject) throws Exception {
        String insertSql = "UPDATE subject SET subjectId = ?, subjectName = ?, employeeId = ? WHERE subjectId = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,subject.getSubjectCode());
        preparedStatement.setString(2,subject.getSubject());
        preparedStatement.setInt(3,subject.getEmployeeId());
        preparedStatement.setInt(4,subject.getSubjectCode());
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public List<Subject> getSubjectsByEmployeeId(int employeeId) throws Exception {
        List<Subject> subjectList = new ArrayList<Subject>();
        String insertSql = "select * from subject where employeeId = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1, employeeId);
        ResultSet resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
        while(resultSet.next()) {
            subjectList.add(generateSubject(resultSet));
        }
        return subjectList;
    }

    @Override
    public List<Subject> getAllSubjects() throws Exception {
        List<Subject> subjectList = new ArrayList<Subject>();
        String insertSql = "SELECT * FROM subject GROUP BY subjectId";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        ResultSet resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
        while(resultSet.next()) {
            subjectList.add(generateSubject(resultSet));
        }
        return subjectList;
    }

    private Subject generateSubject(ResultSet resultSet) throws Exception {
        Subject subject = new Subject();
        subject.setSubjectCode(resultSet.getInt("subjectId"));
        subject.setSubject(resultSet.getString("subjectName"));
        subject.setEmployeeId(resultSet.getInt("employeeId"));
        return subject;
    }
}
