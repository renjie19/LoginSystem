package com.lourence.jonh.license.repository;

import com.lourence.jonh.util.MySqlConnector;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LicenseDaoImpl implements LicenseDao {
    @Override
    public void addLicenseDetails(License teachingLicense) throws  Exception {
        String insertSql = "INSERT INTO employeeLicense(licenseNumber,dateIssued,expirationDate,employeeId) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,teachingLicense.getLicenseNumber());
        preparedStatement.setDate(2,new Date(teachingLicense.getIssueDate().getTime()));
        preparedStatement.setDate(3,new Date(teachingLicense.getExpiryDate().getTime()));
        preparedStatement.setInt(4,teachingLicense.getEmployeeId());
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public License getLicenseDetails(int employeeId) throws  Exception {
        String insertSql = "SELECT * FROM employeeLicense WHERE employeeId = ?";
        PreparedStatement  preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,employeeId);
        ResultSet resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
        License license = new License();
        if(resultSet.next()){
            license = generateLicense(resultSet);
        }
        return license;
    }

    @Override
    public void deleteAllLicense() throws Exception {
        String insertSql = "DELETE FROM employeeLicense";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public void updateLicense(License license) throws Exception {
        String insertSql = "UPDATE employeeLicense SET dateIssued = ?, expirationDate = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setString(1,license.getIssueDate().toString());
        preparedStatement.setString(2,license.getExpiryDate().toString());
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public void deleteLicenseByEmployeeId(int employeeId) throws Exception {
        String insertSql = "DELETE FROM employeeLicense WHERE employeeId = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1, employeeId);
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    private License generateLicense(ResultSet resultSet) throws  Exception {
        License license = new License();
        license.setLicenseId(resultSet.getInt("licenseId"));
        license.setLicenseNumber(resultSet.getInt("licenseNumber"));
        license.setIssueDate(resultSet.getDate("dateIssued"));
        license.setExpiryDate(resultSet.getDate("expirationDate"));
        license.setEmployeeId(resultSet.getInt("employeeId"));
        return license;
    }
}
