package com.lourence.jonh.timelog.service;

import com.lourence.jonh.timelog.repository.TimeLog;
import com.lourence.jonh.timelog.repository.TimeLogDao;
import com.lourence.jonh.timelog.repository.TimeLogDaoImpl;
import com.lourence.jonh.util.StateEnum;

public class TimeLogService {
    private static TimeLogService timeLogService;
    private TimeLogDao timeLogDao;
    
    private TimeLogService(){
        timeLogDao = new TimeLogDaoImpl();
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
            timeLog.setId(employeeId);
            timeLog.setType(getEmployeeState(timeLog.getId()));
            int rowAffected = timeLogDao.addLog(timeLog);
            if(rowAffected != 0 && timeLog.getType().equals(StateEnum.IN)){
                System.out.println("Login Successful");
            }else if(rowAffected != 0 && timeLog.getType().equals(StateEnum.OUT)){
                System.out.println("Logout Success");
            }
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




