package com.lourence.jonh.classrecord.repository;

import java.util.List;

public interface ClassRecordDao {
    ClassRecord addClassRecord(int employeeId, int sectionId) throws Exception;
    void deleteClassRecord(int classId) throws Exception;
    ClassRecord updateClassRecord(ClassRecord classRecordHandled) throws Exception;
    List<ClassRecord> getClassRecordsByEmployeeId(int employeeId) throws Exception;
    ClassRecord getClassRecord(int employeeId, int sectionId) throws Exception;
}
