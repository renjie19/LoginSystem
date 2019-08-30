package com.lourence.jonh.classes.repository;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.service.EmployeeService;
import com.lourence.jonh.section.repository.Section;
import com.lourence.jonh.section.service.SectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassesDaoImplTest {
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

    Classes createClasses() {
        try {
            Employee employee = createEmployee();
            Section section = createSection();
            ClassesDao classesDao = new ClassesDaoImpl();
            return classesDao.addClassHandled(employee.getEmployeeId(),section.getSectionId());
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
            ClassesDao classesDao = new ClassesDaoImpl();
            Classes classes = classesDao.addClassHandled(employee.getEmployeeId(),section.getSectionId());
            assertEquals(classes.getEmployeeId(),employee.getEmployeeId());
            assertEquals(classes.getSectionId(),section.getSectionId());
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void updateClassHandled() {
        try {
            ClassesDao classesDao = new ClassesDaoImpl();
            Classes classes = createClasses();
            Employee employee = new Employee();
            employee.setName("Mikey");
            employee.setAge(26);
            employee.setAddress("Roxas");
            employee.setPosition("Teacher II");
            employee = EmployeeService.getInstance().addEmployee(employee);
            classes.setEmployeeId(employee.getEmployeeId());
            Classes testClass = classesDao.updateClassHandled(classes);
            assertEquals(classes.getEmployeeId(),testClass.getEmployeeId());
            assertEquals(classes.getSectionId(),testClass.getSectionId());
            assertEquals(classes.getClassId(),testClass.getClassId());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetClass() {
        try {
            ClassesDao classesDao = new ClassesDaoImpl();
            Employee employee = createEmployee();
            Section section = createSection();
            Classes classes = createClasses();
            Classes testClass = classesDao.getClass(classes.getEmployeeId(), classes.getSectionId());
            assertEquals(testClass.getSectionId(),classes.getSectionId());
            assertEquals(testClass.getEmployeeId(),classes.getEmployeeId());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}