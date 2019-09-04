package com.lourence.jonh.license.repository;

import java.util.Date;

public class License {
    private int licenseId;
    private int licenseNumber;
    private Date issueDate;
    private Date expiryDate;
    private int employeeId;

    public int getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    public void setLicenseNumber(int licenseNumber){
        this.licenseNumber = licenseNumber;
    }

    public int getLicenseNumber(){
        return licenseNumber;
    }

    public void setIssueDate(Date issueDate){
        this.issueDate = issueDate;
    }

    public Date getIssueDate(){
        return issueDate;
    }

    public void setExpiryDate(Date expiryDate){
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate(){
        return expiryDate;
    }

    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }

    public int getEmployeeId(){
        return employeeId;
    }
}
