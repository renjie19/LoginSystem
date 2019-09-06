package com.lourence.jonh.employee.repository;

import com.lourence.jonh.license.repository.License;
import com.lourence.jonh.license.repository.LicenseDaoImpl;
import com.lourence.jonh.section.repository.Section;
import com.lourence.jonh.section.repository.SectionDaoImpl;
import com.lourence.jonh.subject.repository.Subject;
import com.lourence.jonh.subject.repository.SubjectDaoImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeDaoTest {


    @Test
    void addEmployee() {
        Employee employee = new Employee();
        employee.setName("Rodrigo Duterte");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("President");

        License license = new License();
        license.setLicenseCode(445533);
        LicenseDaoImpl.getInstance().addLicense(license);
        employee.setLicense(license);

        Subject subject = new Subject();
        subject.setSubject("Math");
        SubjectDaoImpl.getInstance().assignSubject(subject);
        List<Subject> subjectList = new ArrayList<Subject>();
        subjectList.add(subject);
        employee.setSubjects(subjectList);

        List<Section> sectionList = new ArrayList<Section>();
        Section section = new Section();
        section.setSectionName("Rose");
        section.setYearLevel("Grade 11");
        SectionDaoImpl.getInstance().addSection(section);
        Section section1 = new Section();
        section1.setSectionName("Lily");
        section1.setYearLevel("Grade 12");
        SectionDaoImpl.getInstance().addSection(section1);
        sectionList.add(section);
        sectionList.add(section1);
        employee.setSectionsHandled(sectionList);
        EmployeeDaoImpl.getInstance().addEmployee(employee);
    }

    @Test
    void deleteEmployee() {
        EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        Employee savedEmployee = new Employee();
        try {
            savedEmployee = employeeDao.getEmployeeById(employeeDao.addEmployee(employee).getEmployeeId());
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            employeeList = employeeDao.getAllEmployees();
            assertEquals(employeeList.size(),1);

            employeeDao.deleteEmployee(savedEmployee);
            employeeList = employeeDao.getAllEmployees();
            assertEquals(0,employeeList.size());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void updateEmployee() {
        EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        Employee savedEmployee = new Employee();
        try {
            //savedEmployee = employeeDao.getEmployeeById(employeeDao.addEmployee(employee));
        }catch(Exception e){
            e.printStackTrace();
        }
        savedEmployee.setName("Rodrigo Roa Duterte");
        Employee updatedEmployee = new Employee();
        try {
            employeeDao.updateEmployee(savedEmployee);
            savedEmployee = employeeDao.getEmployeeById(employee.getEmployeeId());
            updatedEmployee = employeeDao.getEmployeeById(savedEmployee.getEmployeeId());
        }catch(Exception e){
            e.printStackTrace();
        }
        assertEquals(savedEmployee.getEmployeeId(),updatedEmployee.getEmployeeId());
        assertEquals(savedEmployee.getName(),updatedEmployee.getName());
        assertEquals(savedEmployee.getAge(),updatedEmployee.getAge());
        assertEquals(savedEmployee.getAddress(),updatedEmployee.getAddress());
        assertEquals(savedEmployee.getPosition(),updatedEmployee.getPosition());
    }

    @Test
    void getEmployeeTest() {
        Employee employee = EmployeeDaoImpl.getInstance().getEmployeeById(3);
        List<Subject> subjectList = employee.getSubjects();
    }

    @Test
    void deleteAll() {
        EmployeeDaoImpl.getInstance().deleteAllEmployee();
    }

    @Test
    void getAllEmployees() {
        List<Employee> employees = EmployeeDaoImpl.getInstance().getAllEmployees();
    }
}