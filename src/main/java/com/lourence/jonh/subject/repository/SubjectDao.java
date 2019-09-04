package com.lourence.jonh.subject.repository;

import java.util.List;

public interface SubjectDao {
    void assignSubject(String subject,int employeeId) throws Exception;
    void deleteSubjectAssignment(String subjectName) throws Exception;
    void deleteAll() throws Exception;
    void updateSubjectAssignment(Subject subject) throws Exception;
    List<Subject> getSubjectsByEmployeeId(int employeeId) throws Exception;
    List<Subject> getAllSubjects() throws Exception;
}
