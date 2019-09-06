package com.lourence.jonh.subject.repository;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;

class SubjectDaoImplTest {

    @Test
    void assignSubject() {
        Subject subject = new Subject();
        subject.setSubject("Math");
        SubjectDaoImpl.getInstance().assignSubject(subject);
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