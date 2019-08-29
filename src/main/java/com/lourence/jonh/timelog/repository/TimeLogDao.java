package com.lourence.jonh.timelog.repository;

public interface TimeLogDao {
    int addLog(TimeLog log)throws Exception;
    TimeLog getLastLogById(int id)throws Exception;
    void deleteAllLogs();
}
