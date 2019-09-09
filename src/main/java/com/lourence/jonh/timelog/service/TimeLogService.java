package com.lourence.jonh.timelog.service;

import com.lourence.jonh.timelog.repository.TimeLog;
import com.lourence.jonh.timelog.repository.TimeLogDao;
import com.lourence.jonh.timelog.repository.TimeLogDaoImpl;
import com.lourence.jonh.util.StateEnum;

import java.util.Date;

public class TimeLogService {
    private TimeLogDao timeLogDao;
    
    public TimeLogService(){
        timeLogDao = TimeLogDaoImpl.getInstance();
    }

    
    public TimeLog log(int employeeId){
        TimeLog timeLog = new TimeLog();
        timeLog.setEmployeeId(employeeId);
        timeLog.setDate(new Date());
        timeLog.setTime(System.currentTimeMillis());
        TimeLog lastLog = timeLogDao.getLastLogById(employeeId);
        if(lastLog==null || lastLog.getType()==StateEnum.OUT) {
            timeLog.setType(StateEnum.IN);
        } else {
            timeLog.setType(StateEnum.OUT);
        }
        timeLogDao.addLog(timeLog);
        return timeLog;
    }

    public void deleteAllLogs(){
        timeLogDao.deleteAllLogs();
    }
}




