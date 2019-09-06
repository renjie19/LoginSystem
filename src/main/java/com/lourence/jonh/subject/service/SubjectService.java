package com.lourence.jonh.subject.service;

import com.lourence.jonh.subject.repository.Subject;
import com.lourence.jonh.subject.repository.SubjectDao;
import com.lourence.jonh.subject.repository.SubjectDaoImpl;

import java.util.List;

public class SubjectService {
    private static SubjectService service;
    private SubjectDao repository;

    private SubjectService() {
        this.repository = SubjectDaoImpl.getInstance();
    }

    public static SubjectService getInstance() {
        if(service==null) {
            service = new SubjectService();
        }
        return service;
    }

    public void assignSubject(String subjectName,int employeeId) {

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
