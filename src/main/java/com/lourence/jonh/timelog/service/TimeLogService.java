package com.lourence.jonh.timelog.service;

import com.lourence.jonh.timelog.repository.TimeLog;
import com.lourence.jonh.timelog.repository.TimeLogDao;
import com.lourence.jonh.timelog.repository.TimeLogDaoImpl;
import com.lourence.jonh.util.StateEnum;

import java.util.Date;

public class TimeLogService {
    private static TimeLogService timeLogService;
    private TimeLogDao timeLogDao;
    
    private TimeLogService(){
        timeLogDao = TimeLogDaoImpl.getInstance();
    }
    
    public static TimeLogService getInstance(){
        if(timeLogService ==null){
            timeLogService = new TimeLogService();
        }
        return timeLogService;
    }
    
    public TimeLog log(int employeeId){
        TimeLog timeLog = new TimeLog();
        try {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return timeLog;
    }

    public void deleteAllLogs(){
        timeLogDao.deleteAllLogs();
    }

    private StateEnum getEmployeeState(int id){
        try {
            TimeLog timeLog = timeLogDao.getLastLogById(id);
            StateEnum state = timeLog.getType();
            if(state.equals(StateEnum.IN)){
                return StateEnum.OUT;
            }
        }catch(Exception e){
           e.printStackTrace();
        }
        return StateEnum.IN;
    }

      
}




