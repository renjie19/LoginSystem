package com.lourence.jonh.subjects.repository;

public class Subject {
    private int  subjectCode;
    private String subject;
    private int employeeId;

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
}
