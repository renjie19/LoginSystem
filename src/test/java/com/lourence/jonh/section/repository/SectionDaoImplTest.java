package com.lourence.jonh.section.repository;

import com.lourence.jonh.classrecord.repository.ClassRecordDao;
import com.lourence.jonh.classrecord.repository.ClassRecordDaoImpl;
import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.service.EmployeeService;
import com.lourence.jonh.section.service.SectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SectionDaoImplTest {

    @BeforeEach
    void before() {
        try {
            EmployeeService.getInstance().deleteAllEmployee();
            SectionDao sectionDao = SectionDaoImpl.getInstance();
            sectionDao.deleteAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    Employee createEmployee1() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        return EmployeeService.getInstance().addEmployee(employee);
    }

    Employee createEmployee2() {
        Employee employee = new Employee();
        employee.setName("Rodrigo Duterte");
        employee.setAge(55);
        employee.setAddress("Manila");
        employee.setPosition("President");
        return EmployeeService.getInstance().addEmployee(employee);
    }

    Section createSection1() {
        Section section = new Section();
        section.setSectionName("Rose");
        section.setYearLevel("Grade 7");
        return SectionService.getInstance().addSection(section);
    }

    Section createSection2() {
        Section section = new Section();
        section.setSectionName("Lily");
        section.setYearLevel("Grade 7");
        return SectionService.getInstance().addSection(section);
    }

    @Test
    void addSection() {
        try {
            Section section = new Section();
            section.setSectionName("Rose");
            section.setYearLevel("Grade 7");
            SectionDao sectionDao = SectionDaoImpl.getInstance();
            Section savedSection = sectionDao.addSection(section);
            assertEquals(section.getSectionName(),savedSection.getSectionName());
            assertEquals(section.getYearLevel(),savedSection.getYearLevel());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void deleteSection() {
        try {
            Section section = new Section();
            section.setSectionName("Rose");
            SectionDao sectionDao = SectionDaoImpl.getInstance();
            Section savedSection = sectionDao.addSection(section);
            sectionDao.deleteSection(savedSection.getSectionId());
            Section afterDelete = sectionDao.getSectionById(savedSection.getSectionId());
            assertNull(afterDelete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateSection() {
        try {
            Section section = new Section();
            section.setSectionName("Rose");
            section.setYearLevel("Grade 7");
            SectionDao sectionDao = SectionDaoImpl.getInstance();
            Section savedSection = sectionDao.addSection(section);
           savedSection.setSectionName("Lily");
           sectionDao.updateSection(savedSection);
           assertEquals("Lily",savedSection.getSectionName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getSectionById() {
        Employee employee1 = createEmployee1();
        Employee employee2 = createEmployee2();
        Section section1 = createSection1();
        Section section2 = createSection2();
        ClassRecordDao classRecordDao = new ClassRecordDaoImpl();
        try {
            classRecordDao.addClassRecord(employee1.getEmployeeId(),section1.getSectionId());
            classRecordDao.addClassRecord(employee1.getEmployeeId(),section2.getSectionId());
            classRecordDao.addClassRecord(employee2.getEmployeeId(),section1.getSectionId());
            classRecordDao.addClassRecord(employee2.getEmployeeId(),section2.getSectionId());
            SectionDao repository = SectionDaoImpl.getInstance();
            Section result = repository.getSectionById(section1.getSectionId());
            System.out.println(result);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAllSections() {
        Employee employee1 = createEmployee1();
        Employee employee2 = createEmployee2();
        Section section1 = createSection1();
        Section section2 = createSection2();

        ClassRecordDao classRecordDao = new ClassRecordDaoImpl();
        try {
            classRecordDao.addClassRecord(employee1.getEmployeeId(),section1.getSectionId());
            classRecordDao.addClassRecord(employee1.getEmployeeId(),section2.getSectionId());
            classRecordDao.addClassRecord(employee2.getEmployeeId(),section1.getSectionId());
            classRecordDao.addClassRecord(employee2.getEmployeeId(),section2.getSectionId());
            SectionDao repository = SectionDaoImpl.getInstance();
            List<Section> sectionList = repository.getAllSections();
            for(Section section : sectionList) {
                System.out.println(section);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}