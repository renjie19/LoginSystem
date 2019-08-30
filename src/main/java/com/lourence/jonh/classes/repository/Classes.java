package com.lourence.jonh.classes.repository;

public class Classes {
    private int classId;
    private int employeeId;
    private int sectionId;
    private String teacher;
    private String section;
    private String yearLevel;

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setTeacher(String teacherName) {
        this.teacher = teacherName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setSection(String sectionName) {
        this.section = sectionName;
    }

    public String getSection() {
        return section;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getYearLevel() {
        return yearLevel;
    }
}
