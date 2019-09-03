package com.lourence.jonh.classrecord.repository;

import com.lourence.jonh.util.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClassRecordDaoImpl implements ClassRecordDao {
    @Override
    public ClassRecord addClassRecord(int employeeId, int sectionId) throws Exception {
        ClassRecord classRecord = new ClassRecord();
        classRecord.setEmployeeId(employeeId);
        classRecord.setSectionId(sectionId);
        String insertSql = "INSERT INTO teacherSection(employeeId,sectionId)VALUES(?,?)";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,employeeId);
        preparedStatement.setInt(2,sectionId);
        MySqlConnector.getInstance().execute(preparedStatement);
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();
        classRecord.setClassId(resultSet.getInt(1));
        return classRecord;
    }

    @Override
    public void deleteClassRecord(int classId) throws Exception {
        String insertSql = "DELETE FROM teacherSection WHERE classId = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,classId);
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public ClassRecord updateClassRecord(ClassRecord classRecord) throws Exception {
        String insertSql = "UPDATE teacherSection SET employeeId = ?, sectionId = ? WHERE classId = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1, classRecord.getEmployeeId());
        preparedStatement.setInt(2, classRecord.getSectionId());
        preparedStatement.setInt(3, classRecord.getClassId());
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
        return getClassRecord(classRecord.getEmployeeId(), classRecord.getSectionId());
    }

    @Override
    public List<ClassRecord> getClassRecordsByEmployeeId(int employeeId) throws Exception {
        List<ClassRecord> aClasses = new ArrayList<ClassRecord>();
        String insertSql = "select classId,name,sectionName from employee inner join teacherSection on " +
                "employee.Id = teacherSection.employeeId inner join section " +
                "on teacherSection.sectionId = section.sectionId WHERE id = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,employeeId);
        ResultSet resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
        while(resultSet.next()){
            ClassRecord teacherSection = new ClassRecord();
            teacherSection.setClassId(resultSet.getInt("classId"));
            teacherSection.setTeacher(resultSet.getString("name"));
            teacherSection.setSection(resultSet.getString("sectionName"));
            aClasses.add(teacherSection);
        }
        return aClasses;
    }

    @Override
    public ClassRecord getClassRecord(int employeeId, int sectionId) throws Exception {
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

    private ClassRecord generateClasses(ResultSet resultSet) throws Exception{
        ClassRecord classRecord = new ClassRecord();
        classRecord.setClassId(resultSet.getInt("classId"));
        classRecord.setEmployeeId(resultSet.getInt("employeeId"));
        classRecord.setSectionId(resultSet.getInt("sectionId"));
        return classRecord;
    }
}
