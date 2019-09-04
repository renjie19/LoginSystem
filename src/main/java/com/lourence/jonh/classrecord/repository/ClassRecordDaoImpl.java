package com.lourence.jonh.classrecord.repository;

import com.lourence.jonh.util.MySqlConnector;

import java.sql.PreparedStatement;

public class ClassRecordDaoImpl implements ClassRecordDao {
    @Override
    public void addClassRecord(int employeeId, int sectionId) throws Exception {
        String insertSql = "INSERT INTO teacherSection(employeeId,sectionId)VALUES(?,?)";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,employeeId);
        preparedStatement.setInt(2,sectionId);
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }
}
