package com.lourence.jonh.employee.repository;

import com.lourence.jonh.classrecord.repository.ClassRecordDao;
import com.lourence.jonh.classrecord.repository.ClassRecordDaoImpl;
import com.lourence.jonh.employee.service.EmployeeService;
import com.lourence.jonh.license.repository.License;
import com.lourence.jonh.license.service.LicenseService;
import com.lourence.jonh.section.repository.Section;
import com.lourence.jonh.section.service.SectionService;
import com.lourence.jonh.subject.service.SubjectService;
import com.lourence.jonh.timelog.service.TimeLogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeDaoTest {
    @BeforeEach
    void before(){
        EmployeeService.getInstance().deleteAllEmployee();
        TimeLogService.getInstance().deleteAllLogs();
        SectionService.getInstance().deleteAll();
    }

    @Test
    void addEmployee() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee savedEmployee = new Employee();
        try {
            savedEmployee = employeeDao.addEmployee(employee);
        }catch(Exception e){
            e.printStackTrace();
        }
        assertEquals(employee.getName(),savedEmployee.getName());
        assertEquals(employee.getAge(), savedEmployee.getAge());
        assertEquals(employee.getAddress(),savedEmployee.getAddress());
        assertEquals(employee.getPosition(),savedEmployee.getPosition());
    }

    @Test
    void deleteEmployee() {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        List<Employee> employeeList = new ArrayList<Employee>();
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
        EmployeeDao employeeDao = new EmployeeDaoImpl();
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
    public void getEmployeeTest() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        try {
            employee = employeeDao.addEmployee(employee);

            License license = new License();
            license.setLicenseNumber(1234798);
            license.setEmployeeId(employee.getEmployeeId());
            license.setIssueDate(new Date());
            license.setExpiryDate(new Date());
            LicenseService.getInstance().addLicenseDetails(license);


            SubjectService.getInstance().assignSubject("Math",employee.getEmployeeId());
            SubjectService.getInstance().assignSubject("Science",employee.getEmployeeId());
            SubjectService.getInstance().assignSubject("Filipino",employee.getEmployeeId());

            Section section = new Section();
            section.setSectionName("Rose");
            section.setYearLevel("Grade 11");
            section.setSectionId(employee.getEmployeeId());
            Section section1 = new Section();
            section1.setSectionName("Lily");
            section1.setYearLevel("Grade 11");
            section1.setSectionId(employee.getEmployeeId());
            SectionService.getInstance().addSection(section);
            SectionService.getInstance().addSection(section1);
            ClassRecordDao classRecordDao = new ClassRecordDaoImpl();
            classRecordDao.addClassRecord(employee.getEmployeeId(),section.getSectionId());
            classRecordDao.addClassRecord(employee.getEmployeeId(),section1.getSectionId());

            Employee result = employeeDao.getEmployeeById(employee.getEmployeeId());
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAllEmployees() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");

        Employee employee1 = new Employee();
        employee1.setName("Rodrigo Duterte");
        employee1.setAge(55);
        employee1.setAddress("Manila");
        employee1.setPosition("President");

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        try {
            employee = employeeDao.addEmployee(employee);
            employee1 = employeeDao.addEmployee(employee1);

            License license = new License();
            license.setLicenseNumber(1234798);
            license.setEmployeeId(employee.getEmployeeId());
            license.setIssueDate(new Date());
            license.setExpiryDate(new Date());
            LicenseService.getInstance().addLicenseDetails(license);

            License license1 = new License();
            license1.setLicenseNumber(987654);
            license1.setEmployeeId(employee1.getEmployeeId());
            license1.setIssueDate(new Date());
            license1.setExpiryDate(new Date());
            LicenseService.getInstance().addLicenseDetails(license1);

            SubjectService.getInstance().assignSubject("Math",employee.getEmployeeId());
            SubjectService.getInstance().assignSubject("Science",employee.getEmployeeId());
            SubjectService.getInstance().assignSubject("Filipino",employee1.getEmployeeId());
            SubjectService.getInstance().assignSubject("PE",employee1.getEmployeeId());

            Section section = new Section();
            section.setSectionName("Rose");
            section.setYearLevel("Grade 11");
            Section section1 = new Section();
            section1.setSectionName("Lily");
            section1.setYearLevel("Grade 11");
            SectionService.getInstance().addSection(section);
            SectionService.getInstance().addSection(section1);

            ClassRecordDao classRecordDao = new ClassRecordDaoImpl();
            classRecordDao.addClassRecord(employee.getEmployeeId(),section.getSectionId());
            classRecordDao.addClassRecord(employee.getEmployeeId(),section1.getSectionId());
            classRecordDao.addClassRecord(employee1.getEmployeeId(),section.getSectionId());
            classRecordDao.addClassRecord(employee1.getEmployeeId(),section1.getSectionId());

            List<Employee> result = employeeDao.getAllEmployees();
            for (Employee employee2 : result) {
                System.out.println(employee2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}