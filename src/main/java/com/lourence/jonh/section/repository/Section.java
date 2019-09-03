package com.lourence.jonh.section.repository;

import com.lourence.jonh.employee.repository.Employee;

import java.util.List;

public class Section {
    private int sectionId;
    private String sectionName;
    private String yearLevel;
    private List<Employee> teachers;

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    public List<Employee> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Employee> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        String section = "Section" +
                "\nSection Id: " + sectionId +
                "\nSection Name: " + sectionName +
                "\nYear Level: " + yearLevel ;
        String teacher="Teachers: ";
        for (Employee employee : teachers) {
            teacher = teacher + employee.getName() + "  ";
        }
        return section +"\n"+ teacher+"\n";
    }
}
