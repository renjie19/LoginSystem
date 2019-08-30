package com.lourence.jonh.subjects.repository;

import java.util.List;

public interface SubjectDao {
    void assignSubject(Subject subject) throws Exception;
    void deleteSubjectAssignment(int subjectCode) throws Exception;
    void deleteAll() throws Exception;
    void updateSubjectAssignment(Subject subject) throws Exception;
    List<Subject> getSubjectsByEmployeeId(int employeeId) throws Exception;
    List<Subject> getAllSubjects() throws Exception;
}
