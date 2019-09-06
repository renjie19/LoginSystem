package com.lourence.jonh.employee.repository;

import com.lourence.jonh.license.repository.License;
import com.lourence.jonh.section.repository.Section;
import com.lourence.jonh.subject.repository.Subject;

import javax.persistence.*;
import java.util.List;
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String name;
    private int age;
    private String address;
    private String position;
    @OneToOne
    @JoinColumn
    private License license;
    @OneToMany
    @JoinColumn
    private List<Subject> subjects;
    @ManyToMany
    @JoinTable
    private List<Section> sectionsHandled;

    public List<Section> getSectionsHandled() {
        return sectionsHandled;
    }

    public void setSectionsHandled(List<Section> sectionsHandled) {
        this.sectionsHandled = sectionsHandled;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

//    @Override
//    public String toString() {
//        String employee = "Employee Id:" + employeeId +
//                "\nName: "+ name+
//                "\nAge: "+ age +
//                "\nAddress: " + address +
//                "\nPosition: " + position +
//                "\nLicense: " + license.getLicenseNumber() +
//                "\nSubjects: ";
//        String sub ="";
//        for(Subject subj : subjects) {
//            sub = sub + subj.getSubject() + "  ";
//        }
//
//        String sections = "Sections: ";
//        for(Section section : sectionsHandled) {
//            sections = sections + section.getSectionName() + "  ";
//        }
//        return employee+sub+"\n"+sections+"\n";
//    }
}
