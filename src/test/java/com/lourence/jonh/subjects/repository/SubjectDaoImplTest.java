package com.lourence.jonh.subjects.repository;

import com.lourence.jonh.section.service.SectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubjectDaoImplTest {
    @BeforeEach
    void before() {
        try {
            SubjectDao subjectDao = new SubjectDaoImpl();
            //subjectDao.deleteAll();
            SectionService.getInstance().deleteAll();
            //EmployeeService.getInstance().deleteAllEmployee();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void assignSubject() {
        /**Employee employee = new Employee();
        try{
            employee.setName("Gloria Arroyo");
            employee.setAge(45);
            employee.setAddress("Manila");
            employee.setPosition("Cha-Cha Queen");
            employee = EmployeeService.getInstance().addEmployee(employee);
        }catch (Exception e){
            e.printStackTrace();
        }**/
        Subject subject = new Subject();
        subject.setSubjectCode(102);
        subject.setSubject("Science");
        subject.setEmployeeId(70);
        try{
            SubjectDao subjectDao = new SubjectDaoImpl();
            subjectDao.assignSubject(subject);
        } catch (Exception e ) {
            System.out.println(e);
        }
    }

    @Test
    void deleteSubjectAssignment() {
    }

    @Test
    void updateSubjectAssignment() {
    }

    @Test
    void getEmployeeSubjects() {
    }
}