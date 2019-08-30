package com.lourence.jonh.classes.repository;

import java.util.List;

public interface ClassesDao {
    Classes addClassHandled(int employeeId, int sectionId) throws Exception;
    void deleteClassHandled(int classId) throws Exception;
    Classes updateClassHandled(Classes classesHandled) throws Exception;
    List<Classes> getClassesByEmployeeId(int employeeId) throws Exception;
    Classes getClass(int employeeId, int sectionId) throws Exception;
}
