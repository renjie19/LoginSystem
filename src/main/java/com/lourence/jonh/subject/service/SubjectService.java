package com.lourence.jonh.subject.service;

import com.lourence.jonh.subject.repository.Subject;
import com.lourence.jonh.subject.repository.SubjectDao;
import com.lourence.jonh.subject.repository.SubjectDaoImpl;

import java.util.List;

public class SubjectService {
    private static SubjectService subjectService;
    private SubjectDao subjectDao;

    public SubjectService() {
        this.subjectDao = SubjectDaoImpl.getInstance();
    }

    public void assignSubject(int subjectCode,String subjectName) {
        Subject subject = new Subject();
        subject.setSubject(subjectName);
        subject.setSubjectCode(subjectCode);
        subjectDao.assignSubject(subject);
    }

    public void deleteAll() {
        subjectDao.deleteAll();
    }

    public void updateSubject(Subject subject) {
        subjectDao.updateSubjectAssignment(subject);
    }

    public void getAllSubjects() {
        List<Subject> subjectList = subjectDao.getAllSubjects();
        for(Subject subject : subjectList) {
            System.out.println(subject.getSubjectCode() + " | " + subject.getSubject());
        }
    }

}
