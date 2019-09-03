package com.lourence.jonh.classrecord.service;

import com.lourence.jonh.classrecord.repository.ClassRecord;
import com.lourence.jonh.classrecord.repository.ClassRecordDao;
import com.lourence.jonh.classrecord.repository.ClassRecordDaoImpl;

import java.util.List;

public class ClassRecordService {
    private static ClassRecordService service;
    private ClassRecordDao repository;

    private ClassRecordService() {
        repository = new ClassRecordDaoImpl();
    }

    public static ClassRecordService getInstance() {
        if(service==null) {
            service = new ClassRecordService();
        }
        return service;
    }

    public void addClassRecord(int employeeId, int sectionId) {
        try{
            repository.addClassRecord(employeeId,sectionId);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteClassRecord(int classId) {
        try{
            repository.deleteClassRecord(classId);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClassRecord updateClassRecord(ClassRecord classRecord) {
        try{
            return repository.updateClassRecord(classRecord);
        }catch (Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    public ClassRecord getClassRecord(int employeeId, int sectionId) {
        try{
            return repository.getClassRecord(employeeId,sectionId);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void viewClassRecordsByEmployee(int employeeId) {
        try{
            List<ClassRecord> records = repository.getClassRecordsByEmployeeId(employeeId);
            System.out.println(records.get(0).getTeacher());
            System.out.println("   Class Id  |  Section Name");
            for(ClassRecord classes : records) {
                System.out.println(" > "+classes.getClassId()+ " | "+classes.getSection());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
