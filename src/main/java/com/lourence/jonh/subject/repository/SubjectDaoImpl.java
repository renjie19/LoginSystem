package com.lourence.jonh.subject.repository;

import com.lourence.jonh.util.Hibernate;

import java.util.List;

public class SubjectDaoImpl implements SubjectDao {
    private static SubjectDaoImpl subjectDao;

    private SubjectDaoImpl() {
    }

    public static SubjectDaoImpl getInstance() {
        if(subjectDao==null) {
            subjectDao = new SubjectDaoImpl();
        }
        return subjectDao;
    }

    @Override
    public void assignSubject(Subject subject) {
        Hibernate hibernate = new Hibernate();
        hibernate.persist(subject);
    }

    @Override
    public void deleteSubjectAssignment(int subjectId) {
        Hibernate hibernate = new Hibernate();
        hibernate.remove(Subject.class,subjectId);
    }

    @Override
    public void deleteAll(){
        String insertSql = "Delete from subject";
        Hibernate hibernate = new Hibernate();
        hibernate.createNativeQuery(insertSql);
    }

    @Override
    public void updateSubjectAssignment(Subject subject) {
       Hibernate hibernate = new Hibernate();
       hibernate.merge(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        String insertSql = "Select s from Subject s";
        Hibernate hibernate = new Hibernate();
        return hibernate.createNamedQuery(insertSql);
    }
}
