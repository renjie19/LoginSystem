package com.lourence.jonh.controller;

import com.lourence.jonh.model.timelogdao.TimeLog;
import com.lourence.jonh.model.timelogdao.TimeLogDao;
import com.lourence.jonh.model.timelogdao.TimeLogDaoImpl;
import com.lourence.jonh.util.StateEnum;

public class TimeLogController {
    private static TimeLogController timeLogController;
    private TimeLogDao timeLogDao;
    
    private TimeLogController(){
        timeLogDao = new TimeLogDaoImpl();
    }
    
    public static TimeLogController getInstance(){
        if(timeLogController==null){
            timeLogController = new TimeLogController();
        }
        return timeLogController;
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




