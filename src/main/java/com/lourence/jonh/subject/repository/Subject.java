package com.lourence.jonh.subject.repository;

public class Subject {
    private int  subjectCode;
    private String subject;
    private int employeeId;
    private String employeeName;

    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}
