package com.lourence.jonh.subjects.repository;

import com.lourence.jonh.util.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl implements SubjectDao {
    @Override
    public void assignSubject(Subject subject) throws Exception {
        String insertSql = "INSERT INTO subjects VALUES(?,?,?)";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,subject.getSubjectCode());
        preparedStatement.setString(2,subject.getSubject());
        preparedStatement.setInt(3,subject.getEmployeeId());
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public void deleteSubjectAssignment(int subjectCode) throws Exception {
        String insertSql = "DELETE FROM subjects WHERE subjectId = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,subjectCode);
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public void deleteAll() throws Exception {
        String insertSql = "DELETE FROM subjects";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public void updateSubjectAssignment(Subject subject) throws Exception {
        String insertSql = "UPDATE subjects SET subjectId = ?, subjectName = ?, employeeId = ? WHERE subjectId = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,subject.getSubjectCode());
        preparedStatement.setString(2,subject.getSubject());
        preparedStatement.setInt(3,subject.getEmployeeId());
        preparedStatement.setInt(4,subject.getSubjectCode());
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public List<Subject> getEmployeeSubjects(int employeeId) throws Exception {
        List<Subject> subjectList = new ArrayList<Subject>();
        String insertSql = "SELECT * FROM subjects WHERE employeeId = ?";
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
