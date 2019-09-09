package com.lourence.jonh.subject.repository;

import java.util.List;

public interface SubjectDao {
    void assignSubject(Subject subject);
    void deleteSubjectAssignment(int subjectId);
    void deleteAll();
    void updateSubjectAssignment(Subject subject);
    List<Subject> getAllSubjects();
}
