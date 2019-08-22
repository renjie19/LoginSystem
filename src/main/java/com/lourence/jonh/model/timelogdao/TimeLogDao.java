package com.lourence.jonh.model.timelogdao;

public interface TimeLogDao {
    int addLog(TimeLog log)throws Exception;
    TimeLog getLastLogById(int id)throws Exception;
    boolean hasEmployeeId(int employeeId)throws Exception;
    
}
