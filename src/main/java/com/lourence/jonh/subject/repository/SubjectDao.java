package com.lourence.jonh.subject.repository;

import java.util.List;

public interface SubjectDao {
    void assignSubject(Subject subject);
    void deleteSubjectAssignment(String subjectName) throws Exception;
    void deleteAll() throws Exception;
    void updateSubjectAssignment(Subject subject) throws Exception;
    List<Subject> getSubjectsByEmployeeId(int employeeId) throws Exception;
    List<Subject> getAllSubjects() throws Exception;
}
