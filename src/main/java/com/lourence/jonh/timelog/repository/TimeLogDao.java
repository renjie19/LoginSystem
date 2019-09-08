package com.lourence.jonh.timelog.repository;

public interface TimeLogDao {
    int addLog(TimeLog log);
    TimeLog getLastLogById(int id);
    void deleteAllLogs();
}
