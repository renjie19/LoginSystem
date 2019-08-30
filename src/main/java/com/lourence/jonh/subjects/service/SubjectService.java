package com.lourence.jonh.subjects.service;

import com.lourence.jonh.subjects.repository.Subject;
import com.lourence.jonh.subjects.repository.SubjectDao;
import com.lourence.jonh.subjects.repository.SubjectDaoImpl;

import java.util.List;

public class SubjectService {
    private static SubjectService service;
    private SubjectDao repository;

    private SubjectService() {
        this.repository = new SubjectDaoImpl();
    }

    public static SubjectService getInstance() {
        if(service==null) {
            service = new SubjectService();
        }
        return service;
    }

    public void assignSubject(Subject subject) {
        try{
            repository.assignSubject(subject);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        try{
            repository.deleteAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSubject(Subject subject) {
        try {
            repository.updateSubjectAssignment(subject);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSubjectsByEmployee(int employeeId) {
        try {
            List<Subject> subjectList = repository.getSubjectsByEmployeeId(employeeId);
            System.out.println(subjectList.get(0).getEmployeeName());
            for(Subject subject : subjectList) {
                System.out.println(" > "+subject.getSubjectCode()+ " | "+ subject.getSubject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllSubjects() {
        try {
            List<Subject> subjectList = repository.getAllSubjects();
            for(Subject subject : subjectList) {
                System.out.println(subject.getSubjectCode() + " | " + subject.getSubject());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
