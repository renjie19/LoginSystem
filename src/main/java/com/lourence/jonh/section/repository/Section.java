package com.lourence.jonh.section.repository;

import com.lourence.jonh.employee.repository.Employee;

import java.util.List;

public class Section {
    private int sectionId;
    private String sectionName;
    private String yearLevel;
    private List<Employee> employees;

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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        String section = "Section" +
                "\nSection Id: " + sectionId +
                "\nSection Name: " + sectionName +
                "\nYear Level: " + yearLevel ;
        String teacher="Teachers: ";
        for (Employee employee : employees) {
            teacher = teacher + employee.getName() + "  ";
        }
        return section +"\n"+ teacher+"\n";
    }
}
