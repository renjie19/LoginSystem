package com.lourence.jonh.classrecord.repository;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.service.EmployeeService;
import com.lourence.jonh.section.repository.Section;
import com.lourence.jonh.section.service.SectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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


    @Test
    void addClassHandled() {
        try {
            Employee employee = createEmployee();
            Section section = createSection();
            ClassRecordDao classRecordDao = new ClassRecordDaoImpl();
            classRecordDao.addClassRecord(employee.getEmployeeId(),section.getSectionId());
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

}