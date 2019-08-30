package com.lourence.jonh.subjects.repository;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SubjectDaoImplTest {
    @BeforeEach
    void before() {
        try {
            EmployeeService.getInstance().deleteAllEmployee();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void assignSubject() {
        Employee employee = new Employee();
        try{
            employee.setName("Gloria Arroyo");
            employee.setAge(45);
            employee.setAddress("Manila");
            employee.setPosition("Cha-Cha Queen");
            employee = EmployeeService.getInstance().addEmployee(employee);
        }catch (Exception e){
            e.printStackTrace();
        }

        Subject subject = new Subject();
        subject.setSubjectCode(102);
        subject.setSubject("Science");
        subject.setEmployeeId(employee.getEmployeeId());
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
        try{
            Employee employee = new Employee();
            employee.setName("Gloria Arroyo");
            employee.setAge(45);
            employee.setAddress("Manila");
            employee.setPosition("Cha-Cha Queen");
            employee = EmployeeService.getInstance().addEmployee(employee);

            Subject subject = new Subject();
            subject.setSubjectCode(101);
            subject.setSubject("Math");
            subject.setEmployeeId(employee.getEmployeeId());
            Subject subject1 = new Subject();
            subject1.setSubjectCode(102);
            subject1.setSubject("Science");
            subject1.setEmployeeId(employee.getEmployeeId());

            SubjectDao subjectDao = new SubjectDaoImpl();
            subjectDao.assignSubject(subject);
            subjectDao.assignSubject(subject1);

            List<Subject> subjectList = subjectDao.getSubjectsByEmployeeId(employee.getEmployeeId());
            System.out.println(subjectList.get(1).getEmployeeName());
            for (Subject subject2 : subjectList) {
                System.out.println("[ "+subject2.getSubjectCode()+" | "+subject2.getSubject()+" ]");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}