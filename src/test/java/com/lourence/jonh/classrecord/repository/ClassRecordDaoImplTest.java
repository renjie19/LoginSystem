package com.lourence.jonh.classrecord.repository;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.service.EmployeeService;
import com.lourence.jonh.section.repository.Section;
import com.lourence.jonh.section.service.SectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassRecordDaoImplTest {
    @BeforeEach
    void before() {
        EmployeeService.getInstance().deleteAllEmployee();
        SectionService.getInstance().deleteAll();

    }

    Employee createEmployee(){
        Employee employee = new Employee();
        employee.setName("Mrs. Rosa");
        employee.setAge(28);
        employee.setAddress("Iloilo");
        employee.setPosition("Teacher I");
        return EmployeeService.getInstance().addEmployee(employee);
    }

    Section createSection() {
        Section section = new Section();
        section.setSectionName("Rose");
        section.setYearLevel("Grade 8");
        return SectionService.getInstance().addSection(section);
    }

    ClassRecord createClasses() {
        try {
            Employee employee = createEmployee();
            Section section = createSection();
            ClassRecordDao classRecordDao = new ClassRecordDaoImpl();
            return classRecordDao.addClassRecord(employee.getEmployeeId(),section.getSectionId());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    void addClassHandled() {
        try {
            Employee employee = createEmployee();
            Section section = createSection();
            ClassRecordDao classRecordDao = new ClassRecordDaoImpl();
            ClassRecord classRecord = classRecordDao.addClassRecord(employee.getEmployeeId(),section.getSectionId());
            assertEquals(classRecord.getEmployeeId(),employee.getEmployeeId());
            assertEquals(classRecord.getSectionId(),section.getSectionId());
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void updateClassHandled() {
        try {
            ClassRecordDao classRecordDao = new ClassRecordDaoImpl();
            ClassRecord classRecord = createClasses();
            Employee employee = new Employee();
            employee.setName("Mikey");
            employee.setAge(26);
            employee.setAddress("Roxas");
            employee.setPosition("Teacher II");
            employee = EmployeeService.getInstance().addEmployee(employee);
            classRecord.setEmployeeId(employee.getEmployeeId());
            ClassRecord testClass = classRecordDao.updateClassRecord(classRecord);
            assertEquals(classRecord.getEmployeeId(),testClass.getEmployeeId());
            assertEquals(classRecord.getSectionId(),testClass.getSectionId());
            assertEquals(classRecord.getClassId(),testClass.getClassId());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetClass() {
        try {
            ClassRecordDao classRecordDao = new ClassRecordDaoImpl();
            Employee employee = createEmployee();
            Section section = createSection();
            ClassRecord classRecord = createClasses();
            ClassRecord testClass = classRecordDao.getClassRecord(classRecord.getEmployeeId(), classRecord.getSectionId());
            assertEquals(testClass.getSectionId(), classRecord.getSectionId());
            assertEquals(testClass.getEmployeeId(), classRecord.getEmployeeId());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}