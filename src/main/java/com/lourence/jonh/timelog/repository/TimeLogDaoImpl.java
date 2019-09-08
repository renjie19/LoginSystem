package com.lourence.jonh.timelog.repository;

import com.lourence.jonh.util.Hibernate;

import java.util.List;

public class TimeLogDaoImpl implements TimeLogDao {
    private static TimeLogDaoImpl timeLogDao;

    private TimeLogDaoImpl() {

    }

    public static TimeLogDaoImpl getInstance() {
        if(timeLogDao==null) {
            timeLogDao = new TimeLogDaoImpl();
        }
        return timeLogDao;
    }
    
    @Override
    public int addLog(TimeLog log) {
        Hibernate hibernate = new Hibernate();
        hibernate.persist(log);
        return 0;
    }

    @Override
    public TimeLog getLastLogById(int id) {
        String insertSql = "SELECT t from TimeLog t where employeeId = "+id+" order by t DESC";
        Hibernate hibernate = new Hibernate();
        List<TimeLog> timeLogList = hibernate.createNamedQuery(insertSql);
        if(!timeLogList.isEmpty()) {
            return timeLogList.get(0);
        }
        return null;
    }

    @Override
    public void deleteAllLogs(){
        String insertSql = "DELETE FROM timelog";
        Hibernate hibernate = new Hibernate();
        hibernate.createNativeQuery(insertSql);
    }
}
