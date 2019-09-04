package com.lourence.jonh.subject.repository;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        try{
            SubjectDao subjectDao = new SubjectDaoImpl();
            subjectDao.assignSubject("Science",employee.getEmployeeId());
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

            SubjectDao subjectDao = new SubjectDaoImpl();
            subjectDao.assignSubject("Math",employee.getEmployeeId());
            subjectDao.assignSubject("Science",employee.getEmployeeId());

//            List<Subject> subjectList = subjectDao.getSubjectsByEmployeeId(employee.getEmployeeId());
//            System.out.println(subjectList.get(1).getEmployeeId());
//            for (Subject subject2 : subjectList) {
//                System.out.println("[ "+subject2.getSubjectCode()+" | "+subject2.getSubject()+" ]");
//            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}