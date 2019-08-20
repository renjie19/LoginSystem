package com.lourence.jonh.model.timelogdao;

public interface TimeLogDAO {
    int addLog(TimeLog log)throws Exception;
    TimeLog getLastLogById(int id)throws Exception;
    boolean checkIfEmployeeIdExist(int employeeId)throws Exception;
    
}
