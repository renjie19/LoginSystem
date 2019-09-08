package com.lourence.jonh.subject.repository;

import java.util.List;

public interface SubjectDao {
    void assignSubject(Subject subject);
    void deleteSubjectAssignment(int subjectId);
    void deleteAll() throws Exception;
    void updateSubjectAssignment(Subject subject);
    List<Subject> getAllSubjects() throws Exception;
}
